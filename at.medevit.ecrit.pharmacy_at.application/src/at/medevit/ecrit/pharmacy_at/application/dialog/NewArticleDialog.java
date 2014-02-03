package at.medevit.ecrit.pharmacy_at.application.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ArticleAvailability;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class NewArticleDialog extends TitleAreaDialog {
	private Text txtName;
	private Text txtAdmissionNr;
	private Text txtDescription;
	private Text txtPrice;
	private Spinner spinOnStock;
	private Spinner spinLowerBound;
	private Spinner spinOrdered;
	private StockArticle stockArticle;
	
	public NewArticleDialog(Shell parentShell){
		super(parentShell);
		stockArticle = ModelFactory.eINSTANCE.createStockArticle();
		Article a = ModelFactory.eINSTANCE.createArticle();
		stockArticle.setArticle(a);
	}
	
	@Override
	protected Control createDialogArea(Composite parent){
		setTitle("New Article");
		setMessage("Insert article details below in order to add a new article");
		
		Composite area = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) area.getLayout();
		gridLayout.marginRight = 10;
		gridLayout.marginLeft = 10;
// Composite container = new Composite(area, SWT.NONE);
// container.setLayout(new GridLayout(2, false));
// GridData gd_container = new GridData(GridData.FILL_BOTH);
// gd_container.heightHint = 174;
// container.setLayoutData(gd_container);
		
		Group grpBasicInformation = new Group(area, SWT.NONE);
		grpBasicInformation.setLayout(new GridLayout(2, false));
		grpBasicInformation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		grpBasicInformation.setText("Basic Information");
		
		Label lblName = new Label(grpBasicInformation, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setSize(32, 15);
		lblName.setText("Name");
		
		txtName = new Text(grpBasicInformation, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		txtName.setSize(347, 21);
		
		Label lblAdminssionNr = new Label(grpBasicInformation, SWT.NONE);
		lblAdminssionNr.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAdminssionNr.setText("Adminssion Nr.");
		
		txtAdmissionNr = new Text(grpBasicInformation, SWT.BORDER);
		txtAdmissionNr.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPrice = new Label(grpBasicInformation, SWT.NONE);
		lblPrice.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPrice.setText("Price (€)/ Unit ");
		
		txtPrice = new Text(grpBasicInformation, SWT.BORDER);
		txtPrice.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDescription = new Label(grpBasicInformation, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDescription.setText("Description");
		
		txtDescription = new Text(grpBasicInformation, SWT.BORDER);
		txtDescription.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpUnits = new Group(area, SWT.NONE);
		GridLayout gl_grpUnits = new GridLayout(6, true);
		gl_grpUnits.marginLeft = 7;
		gl_grpUnits.marginWidth = 0;
		gl_grpUnits.marginRight = 10;
		grpUnits.setLayout(gl_grpUnits);
		grpUnits.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		grpUnits.setText("Units");
		
		Label lblOnStock = new Label(grpUnits, SWT.NONE);
		lblOnStock.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblOnStock.setText("On Stock");
		spinOnStock = new Spinner(grpUnits, SWT.BORDER);
		spinOnStock.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		spinOnStock.setSize(47, 22);
		
		Label lblOrdered = new Label(grpUnits, SWT.NONE);
		lblOrdered.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblOrdered.setSize(81, 15);
		lblOrdered.setText("Ordered");
		spinOrdered = new Spinner(grpUnits, SWT.BORDER);
		spinOrdered.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		spinOrdered.setSize(47, 22);
		
		Label lblLowerBound = new Label(grpUnits, SWT.NONE);
		lblLowerBound.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLowerBound.setText("Lower Bound");
		spinLowerBound = new Spinner(grpUnits, SWT.BORDER);
		spinLowerBound.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		return area;
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		createButton(parent, IDialogConstants.OK_ID, "Save", true);
		
	}
	
	@Override
	protected void okPressed(){
		stockArticle.setLowerBound(spinLowerBound.getSelection());
		stockArticle.setNumberOnStock(spinOnStock.getSelection());
		stockArticle.setNumberOrdered(spinOrdered.getSelection());
		stockArticle.getArticle().setName(txtName.getText());
		stockArticle.getArticle().setAdmissionNumber(Integer.parseInt(txtAdmissionNr.getText()));
		stockArticle.getArticle().setPrice(Float.parseFloat(txtPrice.getText()));
		stockArticle.getArticle().setDescription(txtDescription.getText());
		stockArticle.getArticle().setAvailability(ArticleAvailability.AVAILABLE);
		boolean success = SampleModel.addToStock(stockArticle);
		
		if (success == false) {
			MessageDialog.openInformation(getShell(), "Article exists",
				"Article already exists. You can not add the same article twice!");
		}
		super.okPressed();
	}
	
	@Override
	protected Point getInitialSize(){
		return new Point(480, 350);
	}
}
