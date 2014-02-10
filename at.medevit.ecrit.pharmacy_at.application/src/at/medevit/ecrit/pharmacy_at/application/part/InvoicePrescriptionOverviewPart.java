package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.application.control.InvoiceOverviewComposite;
import at.medevit.ecrit.pharmacy_at.application.control.PrescriptionOverviewComposite;

public class InvoicePrescriptionOverviewPart {
	private InvoiceOverviewComposite ioc;
	private PrescriptionOverviewComposite poc;
	private static Text txtTotalInvoice;
	private static float totalInvoice;
	private static Text txtTotalPrescription;
	private static float totalPrescription;
	private static Text txtTotal;
	private static float total;
	
	@Inject
	public InvoicePrescriptionOverviewPart(){}
	
	@PostConstruct
	public void postConstruct(Composite parent){
		parent.setLayout(new GridLayout(2, false));
		
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gl_composite = new GridLayout(5, false);
		gl_composite.marginHeight = 0;
		gl_composite.marginRight = 10;
		composite.setLayout(gl_composite);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblFrom = new Label(composite, SWT.NONE);
		lblFrom.setBounds(0, 0, 55, 15);
		lblFrom.setText("From");
		
		final DateTime dateFrom = new DateTime(composite, SWT.BORDER);
		dateFrom.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblTo = new Label(composite, SWT.NONE);
		lblTo.setText("To");
		
		final DateTime dateTo = new DateTime(composite, SWT.BORDER);
		
		Button btnApply = new Button(composite, SWT.NONE);
		btnApply.setText("Filter");
		btnApply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				Calendar from = Calendar.getInstance();
				from.set(Calendar.DAY_OF_MONTH, dateFrom.getDay());
				from.set(Calendar.MONTH, dateFrom.getMonth());
				from.set(Calendar.YEAR, dateFrom.getYear());
				from.set(Calendar.HOUR, 0);
				from.set(Calendar.MINUTE, 0);
				Date dFrom = from.getTime();
				
				Calendar to = Calendar.getInstance();
				to.set(Calendar.DAY_OF_MONTH, dateTo.getDay());
				to.set(Calendar.MONTH, dateTo.getMonth());
				to.set(Calendar.YEAR, dateTo.getYear());
				to.set(Calendar.HOUR, 12);
				to.set(Calendar.MINUTE, 59);
				Date dTo = to.getTime();
				ioc.filterInvoices(dFrom, dTo);
				poc.filterPrescriptions(dFrom, dTo);
			}
		});
		
		ioc = new InvoiceOverviewComposite(parent, SWT.NONE);
		poc = new PrescriptionOverviewComposite(parent, SWT.NONE);
		
		Composite compositeTotal = new Composite(parent, SWT.NONE);
		compositeTotal.setLayout(new GridLayout(2, false));
		compositeTotal.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblTotalInvoice = new Label(compositeTotal, SWT.NONE);
		lblTotalInvoice.setText("Invoice: ");
		
		txtTotalInvoice = new Text(compositeTotal, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_txtTotalInvoice = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtTotalInvoice.minimumWidth = 150;
		txtTotalInvoice.setLayoutData(gd_txtTotalInvoice);
		
		Label lblTotalprescriptions = new Label(compositeTotal, SWT.NONE);
		lblTotalprescriptions.setText("- Prescriptions:");
		
		txtTotalPrescription = new Text(compositeTotal, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_txtTotalPrescription = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtTotalPrescription.minimumWidth = 150;
		txtTotalPrescription.setLayoutData(gd_txtTotalPrescription);
		
		Label lblTotal = new Label(compositeTotal, SWT.NONE);
		lblTotal.setText("Actual Balance: ");
		
		txtTotal = new Text(compositeTotal, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_txtTotal = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtTotal.minimumWidth = 150;
		txtTotal.setLayoutData(gd_txtTotal);
		
		Button btnPrintRefund = new Button(compositeTotal, SWT.NONE);
		btnPrintRefund.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 2, 1));
		btnPrintRefund.setText("Print Refund From");
		btnPrintRefund.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				Object[] checked = poc.getCheckedElements();
				for (Object obj : checked) {
					System.out.println(obj.toString());
				}
			}
		});
		new Label(compositeTotal, SWT.NONE);
		new Label(compositeTotal, SWT.NONE);
		ioc.calcTotalCosts();
	}
	
	public static void updateTotalPrescription(float sum){
		totalPrescription = sum;
		txtTotalPrescription.setText(totalPrescription + " €");
		updateTotal();
	}
	
	public static void updateTotalInvoice(float sum){
		totalInvoice = sum;
		txtTotalInvoice.setText(totalInvoice + " €");
		updateTotal();
	}
	
	private static void updateTotal(){
		total = totalInvoice - totalPrescription;
		txtTotal.setText(total + " €");
	}
}