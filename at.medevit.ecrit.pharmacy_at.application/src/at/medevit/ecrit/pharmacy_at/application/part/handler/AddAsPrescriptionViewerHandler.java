package at.medevit.ecrit.pharmacy_at.application.part.handler;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.dialog.PrescriptionDialog;
import at.medevit.ecrit.pharmacy_at.application.part.InvoiceDataPart;
import at.medevit.ecrit.pharmacy_at.application.part.InvoicePart;
import at.medevit.ecrit.pharmacy_at.application.part.PrescriptionPart;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.Prescription;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class AddAsPrescriptionViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	// ArtilceList TableViewer selection
	private StockArticle stockArticleSelection;
	// Invoice TableViewer selection
	private List<Article> invoiceArticles;
	
	@Execute
	public void execute(@Optional
	@Named("commandparameter.addAsPrescriptionStockArticle")
	String stockArticle, @Optional
	@Named("commandparameter.addAsPrescriptionArticle")
	String articleList, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		
		Prescription p = ModelFactory.eINSTANCE.createPrescription();
		PrescriptionDialog dlg = new PrescriptionDialog(shell, getAvailableArticles());
		dlg.setPrescription(p);
		
		if (dlg.open() == IDialogConstants.OK_ID) {
			Article arti = includedSelection(p);
			if (arti != null) {
				int articleIdx = p.getArticle().indexOf(arti);
				p.getArticle().set(articleIdx, SampleModel.getValidArticleCopy(arti));
				stockArticleSelection
					.setNumberOnStock(stockArticleSelection.getNumberOnStock() - 1);
				SampleModel.addPrescriptionAndSync(p);
			}
			SampleModel.addPrescription(p);
			
			// assure tables are updated properly
			// TODO check if this can be solved via injection as well (selection inj. didn't
			// work as expected)
			MPart pPart = partService.findPart(Messages.getString("ID_PART_PRESCRIPTION"));
			PrescriptionPart prescPart = (PrescriptionPart) pPart.getObject();
			prescPart.updateTable();
			
			MPart iPart = partService.findPart(Messages.getString("ID_PART_INVOICE"));
			InvoicePart invoicePart = (InvoicePart) iPart.getObject();
			invoicePart.updateTable();
			
			MPart idPart = partService.findPart(Messages.getString("ID_PART_INVOICE_DATA"));
			InvoiceDataPart invoiceDataPart = (InvoiceDataPart) idPart.getObject();
			invoiceDataPart.updateTable();
		}
	}
	
	private Article includedSelection(Prescription p){
		Article selArticle = stockArticleSelection.getArticle();
		for (Article a : p.getArticle()) {
			if (selArticle.getName().equals(a.getName())) {
				return a;
			}
		}
		return null;
	}
	
	private List<Article> getAvailableArticles(){
		List<Article> availableArticles = new ArrayList<Article>();
		
		if (invoiceArticles != null && !invoiceArticles.isEmpty()) {
			availableArticles.addAll(invoiceArticles);
		}
		if (stockArticleSelection != null) {
			availableArticles.add(EcoreUtil.copy(stockArticleSelection.getArticle()));
		}
		return availableArticles;
	}
	
	@CanExecute
	public boolean canExecute(){
		setupArticleListSelection();
		setupAvailableInvoiceArticles();
		
		if (stockArticleSelection == null && invoiceArticles == null) {
			return false;
		}
		if (stockArticleSelection.getNumberOnStock() < 1) {
			this.stockArticleSelection = null;
			return false;
		}
		return true;
	}
	
	private void setupArticleListSelection(){
		// is an article from the article list selected
		Object selection = selectionService.getSelection(Messages.getString("ID_PART_ARTICLELIST"));
		
		if (selection != null && selection instanceof StockArticle) {
			this.stockArticleSelection = (StockArticle) selection;
		} else {
			this.stockArticleSelection = null;
		}
	}
	
	private void setupAvailableInvoiceArticles(){
		invoiceArticles = SampleModel.getCurrentInvoice().getArticle();
// Collections.copy(invoiceArticles, SampleModel.getCurrentInvoice().getArticle());
		
		if (invoiceArticles != null && !invoiceArticles.isEmpty()) {
			List<Article> notPrescripted = SampleModel.getNotYetPrescriptedArticle();
			if (notPrescripted.isEmpty()) {
				this.invoiceArticles = null;
			} else {
				this.invoiceArticles = notPrescripted;
			}
		} else {
			this.invoiceArticles = null;
		}
	}
}