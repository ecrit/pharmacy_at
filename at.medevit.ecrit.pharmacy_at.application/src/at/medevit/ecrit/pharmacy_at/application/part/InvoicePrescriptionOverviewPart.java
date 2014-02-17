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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import at.medevit.ecrit.pharmacy_at.application.control.InvoiceOverviewComposite;
import at.medevit.ecrit.pharmacy_at.application.control.PrescriptionOverviewComposite;
import at.medevit.ecrit.pharmacy_at.application.util.Images;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;

public class InvoicePrescriptionOverviewPart {
	private static InvoiceOverviewComposite ioc;
	private static PrescriptionOverviewComposite poc;
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
		parent.setLayout(new GridLayout(1, false));
		
		Group grpInvPrescOverview = new Group(parent, SWT.NONE);
		grpInvPrescOverview.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 12, 1));
		GridLayout gl_grpStockOrder_1 = new GridLayout(2, false);
		gl_grpStockOrder_1.marginLeft = 10;
		gl_grpStockOrder_1.marginRight = 10;
		grpInvPrescOverview.setLayout(gl_grpStockOrder_1);
		grpInvPrescOverview.setText("Invoice/Prescription Overview");
		
		Composite composite = new Composite(grpInvPrescOverview, SWT.NONE);
		composite.setLayout(new GridLayout(5, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblFrom = new Label(composite, SWT.NONE);
		lblFrom.setText("From ");
		
		final DateTime dateFrom = new DateTime(composite, SWT.BORDER);
		GridData gd_dateFrom = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateFrom.widthHint = 80;
		gd_dateFrom.minimumWidth = 80;
		dateFrom.setLayoutData(gd_dateFrom);
		
		Label lblTo = new Label(composite, SWT.NONE);
		lblTo.setText("To ");
		
		final DateTime dateTo = new DateTime(composite, SWT.BORDER);
		GridData gd_dateTo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateTo.widthHint = 80;
		gd_dateTo.minimumWidth = 80;
		dateTo.setLayoutData(gd_dateTo);
		
		Button btnFilter = new Button(composite, SWT.TOGGLE);
		GridData gd_btnFilter = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		btnFilter.setLayoutData(gd_btnFilter);
		btnFilter.setText("Filter");
		btnFilter.setImage(Images.FILTER);
		btnFilter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				if (((Button) e.widget).getSelection()) {
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
				} else {
					ioc.removeFilter();
				}
			}
		});
		
		ioc =
			new InvoiceOverviewComposite(grpInvPrescOverview, SWT.NONE,
				SampleModel.getAllInvoices());
		poc =
			new PrescriptionOverviewComposite(grpInvPrescOverview, SWT.NONE,
				SampleModel.getAllPrescriptions());
		
		Composite compositeTotal = new Composite(grpInvPrescOverview, SWT.NONE);
		compositeTotal.setLayout(new GridLayout(2, false));
		compositeTotal.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblTotalInvoice = new Label(compositeTotal, SWT.NONE);
		lblTotalInvoice.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD | SWT.ITALIC));
		lblTotalInvoice.setText("Invoice: ");
		
		txtTotalInvoice = new Text(compositeTotal, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_txtTotalInvoice = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtTotalInvoice.minimumWidth = 150;
		txtTotalInvoice.setLayoutData(gd_txtTotalInvoice);
		
		Label lblTotalprescriptions = new Label(compositeTotal, SWT.NONE);
		lblTotalprescriptions.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD
			| SWT.ITALIC));
		lblTotalprescriptions.setText("- Prescriptions:");
		
		txtTotalPrescription = new Text(compositeTotal, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_txtTotalPrescription = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtTotalPrescription.minimumWidth = 150;
		txtTotalPrescription.setLayoutData(gd_txtTotalPrescription);
		
		Label lblTotal = new Label(compositeTotal, SWT.NONE);
		lblTotal.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
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
		ioc.calcTotalCosts();
		poc.calcTotalRefund();
	}
	
	/**
	 * 
	 * @param invoices
	 *            summed up price
	 * @param updateTotalInvoice
	 * @param prescriptions
	 *            summed up price
	 * @param updateTotalPrescriptons
	 */
	public static void updateBalance(float invoices, boolean updateTotalInvoice,
		float prescriptions, boolean updateTotalPrescriptons){
		if (updateTotalInvoice) {
			totalInvoice = invoices;
		}
		if (updateTotalPrescriptons) {
			totalPrescription = prescriptions;
		}
		total = totalInvoice - totalPrescription;
		
		txtTotalInvoice.setText(totalInvoice + " €");
		txtTotalPrescription.setText(totalPrescription + " €");
		txtTotal.setText(total + " €");
	}
	
	public static void updateInput(){
		if (ioc != null && poc != null) {
			ioc.updateTree(SampleModel.getAllInvoices());
			poc.updateTree(SampleModel.getAllPrescriptions());
			
			ioc.calcTotalCosts();
			poc.calcTotalRefund();
		}
	}
}