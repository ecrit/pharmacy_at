package at.medevit.ecrit.pharmacy_at.application.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

import at.medevit.ecrit.pharmacy_at.application.part.InvoicePrescriptionOverviewPart;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Invoice;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;

public class InvoiceOverviewComposite extends Composite {
	private static List<Invoice> invoices;
	private static TreeViewer treeViewer;
	private Text txtTotal;
	private Invoice invSelection = ModelFactory.eINSTANCE.createInvoice();
	
	public InvoiceOverviewComposite(Composite parent, int style, List<Invoice> invoices){
		super(parent, style);
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		setLayout(new GridLayout(2, false));
		this.invoices = invoices;
		
		treeViewer = new TreeViewer(this, SWT.BORDER);
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				if (selection != null && selection.getFirstElement() instanceof Invoice) {
					Invoice invoice = (Invoice) selection.getFirstElement();
					if (invSelection.equals(invoice)) {
						PrescriptionOverviewComposite.loseFocus();
						treeViewer.setSelection(null);
					} else {
						invSelection = invoice;
						if (invoice.getPrescription() == null
							|| invoice.getPrescription().isEmpty()) {
							PrescriptionOverviewComposite.loseFocus();
						} else {
							PrescriptionOverviewComposite.focusInvoiceRelated(invoice
								.getPrescription());
						}
					}
				}
			}
		});
		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		
		TreeViewerColumn tvcInvoice = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn colInvoice = tvcInvoice.getColumn();
		colInvoice.setWidth(200);
		colInvoice.setText("Invoice");
		
		TreeViewerColumn tvcPrice = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn colPrice = tvcPrice.getColumn();
		colPrice.setWidth(100);
		colPrice.setText("Price");
		
		TreeViewerColumn tvcUnits = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn colUnits = tvcUnits.getColumn();
		colUnits.setWidth(120);
		colUnits.setText("Date");
		
		InvoiceTreeContentProvider contentProvider = new InvoiceTreeContentProvider();
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(new InvoiceTreeLabelProvider());
		treeViewer.setInput(this.invoices);
	}
	
	public void calcTotalCosts(){
		float total = 0.0f;
		for (Invoice i : invoices) {
			for (Article a : i.getArticle()) {
				total = total + a.getPrice();
			}
		}
		InvoicePrescriptionOverviewPart.updateBalance(total, true, 0.0f, false);
	}
	
	public void filterInvoices(Date dFrom, Date dTo){
		List<Invoice> matching = new ArrayList<>();
		for (Invoice i : invoices) {
			if (i.getDate().after(dFrom) && i.getDate().before(dTo)) {
				matching.add(i);
			}
		}
		treeViewer.setInput(matching);
	}
	
	public void removeFilter(){
		treeViewer.setInput(invoices);
	}
	
	public void updateTree(List<Invoice> iList){
		invoices = iList;
		if (treeViewer != null) {
			treeViewer.setInput(invoices);
			treeViewer.refresh();
		}
		
	}
}
