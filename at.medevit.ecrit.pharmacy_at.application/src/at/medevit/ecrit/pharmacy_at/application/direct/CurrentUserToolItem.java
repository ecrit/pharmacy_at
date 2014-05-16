package at.medevit.ecrit.pharmacy_at.application.direct;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import at.medevit.ecrit.pharmacy_at.application.util.Images;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;

public class CurrentUserToolItem {
	private String currentUser;
	private String loginTime;
	
	@Inject
	public CurrentUserToolItem(){
		currentUser = SampleModel.getPharmacy().getCurrentUser().getName();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		loginTime = dateFormat.format(cal.getTime());
	}
	
	@PostConstruct
	public void createGui(Composite parent){
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		GridData data = new GridData(SWT.FILL, SWT.TOP, true, false);
		container.setLayoutData(data);
		
		Label lblUserImage = new Label(container, SWT.NONE);
		lblUserImage.setImage(Images.USER);

		Label lblCurrentUser = new Label(container, SWT.NONE);
		lblCurrentUser.setText(currentUser);
		
		Label lblTime = new Label(container, SWT.NONE);
		lblTime.setText(loginTime);
		
	}
}