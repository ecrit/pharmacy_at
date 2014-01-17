package at.medevit.ecrit.pharmacy_at.application.handler.seller;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.SampleModel;
import at.medevit.ecrit.pharmacy_at.application.part.InvoiceDataPart;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class AddToInvoiceHandler {

	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;

	@Execute
	public void execute(@Named("at.medevit.ecrit.pharmacy_at.application.commandparameter.modelelement.Article") StockArticle article) {
		System.out.println(article.toString());
		
		StockArticle a = (StockArticle) selectionService
				.getSelection(Messages.ID_PART_ARTICLELIST);
		a.setNumberOnStock(a.getNumberOnStock() - 1);

		// put a copy of this article on the invoice
		Article arti = EcoreUtil.copy(a.getArticle());
		SampleModel.getInvoice().getArticle().add(arti);

		MPart part = partService.findPart(Messages.ID_PART_INVOICE_DATA);
		InvoiceDataPart invoiceDataPart = (InvoiceDataPart) part.getObject();
		invoiceDataPart.addArticleAndUpdate(a.getArticle());
	}

	@CanExecute
	public boolean canExecute() {
		Object selection = selectionService
				.getSelection(Messages.ID_PART_ARTICLELIST);
		if (selection != null && selection instanceof StockArticle) {
			return true;
		} else {
			return false;
		}
	}

}