package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.DateAndTimeObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.model.Invoice;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;

public class InvoicePart {
	private DataBindingContext m_bindingContext;

	private Invoice invoice = ModelFactory.eINSTANCE.createInvoice();
	private Text txtDate;
	private Text txtID;
	private Text txtTotalCosts;

	@Inject
	public InvoicePart() {
		// TODO Your code here
//		invoice.setDate(new Date());
//		invoice.setId(10);
//		invoice.setPaidAmount(10.0f);
//		setInvoice(invoice);
	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		composite.setLayout(new GridLayout(2, false));

		Label lblInvoicepart = new Label(composite, SWT.NONE);
		lblInvoicepart.setText("Invoice");
		new Label(composite, SWT.NONE);

		// some invoice information on top
		// set invoice date
		Label lblDate = new Label(composite, SWT.NONE);
		GridData gd_lblDate = new GridData(SWT.RIGHT, SWT.CENTER, true, false,
				1, 1);
		lblDate.setLayoutData(gd_lblDate);
		lblDate.setText("Date: ");

		txtDate = new Text(composite, SWT.NONE);
		txtDate.setEnabled(false);
		// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// txtDate.setText(dateFormat.format(element.getDate());

		// set invoice number
		Label lblID = new Label(composite, SWT.NONE);
		GridData gd_ID = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		lblID.setLayoutData(gd_ID);
		lblID.setText("InvoiceNumber: ");

		txtID = new Text(composite, SWT.NONE);
		txtID.setEnabled(false);

		// TODO insert all articles here
		// set invoice line items
		Text txtInvoice = new Text(composite, SWT.NONE);
		txtInvoice.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));
		txtInvoice.setText("At this place..."
				+ " the invoice will be placed soon....");
		txtInvoice.setEnabled(false);
		new Label(composite, SWT.NONE);

		// set total costs
		Label lblTotalCosts = new Label(composite, SWT.NONE);
		GridData gd_lblTotalCosts = new GridData(SWT.RIGHT, SWT.CENTER, true,
				false, 1, 1);
		lblTotalCosts.setLayoutData(gd_lblTotalCosts);
		lblTotalCosts.setText("Total Costs: ");

		txtTotalCosts = new Text(composite, SWT.NONE);
		txtTotalCosts.setEnabled(false);

		m_bindingContext = initDataBinding();
	}

	// @Inject
	// void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION)
	// Invoice invoice) {
	// element.setValue(invoice);
	// }

	public void setInvoice(Invoice invoice) {
		if (m_bindingContext != null) {
			m_bindingContext.dispose();
		}
		this.invoice = invoice;
		m_bindingContext = initDataBinding();
	}

	protected DataBindingContext initDataBinding() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
//		IObservableValue dateValue = new WritableValue(null, Date.class);
		IObservableValue dateObserveValue = EMFProperties.value(
				ModelPackage.Literals.INVOICE__DATE).observe(invoice);
		IObservableValue textDateObserveValue = WidgetProperties.text(
				SWT.Modify).observe(txtDate);
		bindingContext.bindValue(textDateObserveValue, dateObserveValue);

		//
		IObservableValue idObserveValue = EMFProperties.value(
				ModelPackage.Literals.INVOICE__ID).observe(invoice);
		IObservableValue textIdObserveValue = WidgetProperties.text(
				SWT.Modify).observe(txtID);
		bindingContext.bindValue(textIdObserveValue, idObserveValue);

		//
		IObservableValue totalCostsObserveValue = EMFProperties.value(ModelPackage.Literals.INVOICE__PAID_AMOUNT).observe(invoice);
		IObservableValue textTotalCostsObsereveVale = WidgetProperties.text(
				SWT.Modify).observe(txtTotalCosts);		
		bindingContext.bindValue(textTotalCostsObsereveVale, totalCostsObserveValue);
		//
		return bindingContext;
	}
}