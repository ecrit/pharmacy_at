package at.medevit.ecrit.pharmacy_at.application.dialog;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.application.User;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;

public class LoginDialog extends Dialog {
	
	private Image titleImage;
	private ImageDescriptor imageDescriptor;
	
	private Text txtUsername;
	private Text txtPassword;
	
	private String username;
	private String password;
	
	public LoginDialog(Shell parentShell){
		super(parentShell);
	}
	
	@Override
	protected Control createDialogArea(Composite parent){
		this.getShell().setText("Login Dialog");
		
		Composite area = new Composite(parent, SWT.NONE);
		area.setBackgroundMode(SWT.INHERIT_DEFAULT);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		area.setLayout(gridLayout);
		
		if (imageDescriptor == null) {
			imageDescriptor =
				imageDescriptorFromURI(URI
					.createURI("platform:/plugin/at.medevit.ecrit.pharmacy_at.application/css/luna.png"));
		}
		if (imageDescriptor != null) {
			titleImage = imageDescriptor.createImage();
			Label imageLabel = new Label(area, SWT.NONE);
			
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.verticalAlignment = GridData.BEGINNING;
			data.horizontalSpan = 1;
			imageLabel.setLayoutData(data);
			imageLabel.setImage(titleImage);
		}
		
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(2, false);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		container.setLayout(layout);
		
		// username
		Label lblUsername = new Label(container, SWT.NONE);
		lblUsername.setText("Username");
		
		GridData dataUsername = new GridData();
		dataUsername.grabExcessHorizontalSpace = true;
		dataUsername.horizontalAlignment = GridData.FILL;
		
		txtUsername = new Text(container, SWT.BORDER);
		txtUsername.setLayoutData(dataUsername);
		
		// password
		Label lblPassword = new Label(container, SWT.NONE);
		lblPassword.setText("Password");
		
		GridData dataPassword = new GridData();
		dataPassword.grabExcessHorizontalSpace = true;
		dataPassword.horizontalAlignment = GridData.FILL;
		
		txtPassword = new Text(container, SWT.PASSWORD);
		txtPassword.setLayoutData(dataPassword);
		
		return area;
	}
	
	public ImageDescriptor imageDescriptorFromURI(URI iconPath){
		try {
			return ImageDescriptor.createFromURL(new URL(iconPath.toString()));
		} catch (MalformedURLException e) {
			System.err.println("iconURI \"" + iconPath.toString()
				+ "\" is invalid, a \"missing image\" icon will be shown");
			return ImageDescriptor.getMissingImageDescriptor();
		}
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		createButton(parent, IDialogConstants.OK_ID, "Login", true);
	}
	
	@Override
	protected void okPressed(){
		username = txtUsername.getText();
		password = txtPassword.getText();
		
		if ((username == null || username.isEmpty()) && (password == null || password.isEmpty())) {
			username = "test";
			password = "test";
		}
		List<User> staff = SampleModel.getPharmacy().getStaff();
		for (User user : staff) {
			if (user.getName().equals(username) && user.getPassword().equals(password)) {
				SampleModel.getPharmacy().setCurrentUser(EcoreUtil.copy(user));
				super.okPressed();
			}
		}
		
		if (SampleModel.getPharmacy().getCurrentUser() == null) {
			MessageDialog
				.openError(getShell(), "Login Failed", "Check your username and password!");
		}
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
}
