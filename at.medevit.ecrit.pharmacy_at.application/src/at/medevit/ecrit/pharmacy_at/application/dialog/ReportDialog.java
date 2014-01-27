package at.medevit.ecrit.pharmacy_at.application.dialog;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Priority;
import at.medevit.ecrit.pharmacy_at.model.Report;

public class ReportDialog extends TitleAreaDialog {
	private Text txtTitle;
	private Text txtIssuer;
	private Combo comboPrio;
	private Text txtConcern;
	private Text txtTextfield;
	
	private DataBindingContext m_bindingContext;
	private Report report;
	
	public ReportDialog(Shell parentShell, Report report){
		super(parentShell);
		this.report = report;
	}
	
	@Override
	protected Control createDialogArea(Composite parent){
		setMessage("Fill in the following fields in order to report an issue with the system");
		setTitle("New Report");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		// Title
		Label lblTitle = new Label(container, SWT.NONE);
		lblTitle.setText("Title");
		
		txtTitle = new Text(container, SWT.BORDER);
		GridData gd_txtTitle = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtTitle.widthHint = 180;
		txtTitle.setLayoutData(gd_txtTitle);
		
		// Issuer
		Label lblIssuer = new Label(container, SWT.NONE);
		lblIssuer.setText("Issuer");
		
		txtIssuer = new Text(container, SWT.BORDER);
		GridData gd_txtIssuer = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtIssuer.widthHint = 180;
		txtIssuer.setLayoutData(gd_txtIssuer);
		
		// Priority
		Label lblPrio = new Label(container, SWT.NONE);
		lblPrio.setText("Priority");
		comboPrio = new Combo(container, SWT.NONE);
		GridData gd_comboPrio = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_comboPrio.widthHint = 165;
		comboPrio.setLayoutData(gd_comboPrio);
		comboPrio.add(Priority.LOW.toString());
		comboPrio.add(Priority.MEDIUM.toString());
		comboPrio.add(Priority.HIGH.toString());
		comboPrio.add(Priority.CRITICAL.toString());
		comboPrio.select(0);
		
		// Concern
		Label lblConcern = new Label(container, SWT.NONE);
		lblConcern.setText("Concern");
		
		txtConcern = new Text(container, SWT.BORDER);
		GridData gd_txtConcern = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtConcern.widthHint = 188;
		txtConcern.setLayoutData(gd_txtConcern);
		
		// Text
		Label lblTextfield = new Label(container, SWT.NONE);
		lblTextfield.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblTextfield.setText("Description");
		
		txtTextfield = new Text(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		GridData gd_txtTextfield = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_txtTextfield.heightHint = 110;
		txtTextfield.setLayoutData(gd_txtTextfield);
		
		m_bindingContext = initDataBinding();
		return area;
	}
	
	protected DataBindingContext initDataBinding(){
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue titleObserve =
			EMFProperties.value(ModelPackage.Literals.REPORT__TITLE).observe(report);
		IObservableValue txtTitleObserve = WidgetProperties.text(SWT.Modify).observe(txtTitle);
		bindingContext.bindValue(txtTitleObserve, titleObserve, null, null);
		//
		IObservableValue issuerObserve =
			EMFProperties.value(ModelPackage.Literals.REPORT__ISSUER).observe(report);
		IObservableValue txtIssuerObserve = WidgetProperties.text(SWT.Modify).observe(txtIssuer);
		bindingContext.bindValue(txtIssuerObserve, issuerObserve);
		//
		IObservableValue concernObserve =
			EMFProperties.value(ModelPackage.Literals.REPORT__CONCERNS).observe(report);
		IObservableValue txtConcernObserve = WidgetProperties.text(SWT.Modify).observe(txtConcern);
		bindingContext.bindValue(txtConcernObserve, concernObserve);
		//
		IObservableValue textfieldObserve =
			EMFProperties.value(ModelPackage.Literals.REPORT__TEXT).observe(report);
		IObservableValue txtTextfieldObserve =
			WidgetProperties.text(SWT.Modify).observe(txtTextfield);
		bindingContext.bindValue(txtTextfieldObserve, textfieldObserve);
		//
		
		//
		return bindingContext;
	}
	
	@Override
	protected void okPressed(){
		String priority = comboPrio.getItem(comboPrio.getSelectionIndex());
		report.setPriority(Priority.getByName(priority));
		
		super.okPressed();
	}
	
	@Override
	protected void configureShell(Shell newShell){
		super.configureShell(newShell);
		newShell.setText("Report Dialog");
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		super.createButtonsForButtonBar(parent);
		
		Button ok = getButton(IDialogConstants.OK_ID);
		ok.setText("Report");
		setButtonLayoutData(ok);
	}
}
