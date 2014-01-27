package at.medevit.ecrit.pharmacy_at.application.part.handler;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.part.InvoiceDataPart;
import at.medevit.ecrit.pharmacy_at.application.part.InvoicePart;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class AddToInvoiceViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	// TableViewer selection
	private StockArticle selection;
	
	@Execute
	public void execute(@Named("commandparameter.modelelement.Article")
	String stockArticle){
		selection.setNumberOnStock(selection.getNumberOnStock() - 1);
		
		// put a copy of this article on the invoice
		SampleModel.addArticleToInvoice(selection);
		
		MPart part = partService.findPart(Messages.getString("ID_PART_INVOICE_DATA"));
		InvoiceDataPart invoiceDataPart = (InvoiceDataPart) part.getObject();
		invoiceDataPart.addArticleAndUpdate(selection.getArticle());
		
		MPart iPart = partService.findPart(Messages.getString("ID_PART_INVOICE"));
		InvoicePart invoicePart = (InvoicePart) iPart.getObject();
		invoicePart.updateTable();
	}
	
	@CanExecute
	public boolean canExecute(){
		Object selection = selectionService.getSelection(Messages.getString("ID_PART_ARTICLELIST"));
		if (selection != null && selection instanceof StockArticle) {
			this.selection = (StockArticle) selection;
			if (this.selection.getNumberOnStock() > 0) {
				return true;
			} else {
				this.selection = null;
				return false;
			}
		} else {
			this.selection = null;
			return false;
		}
	}
}
