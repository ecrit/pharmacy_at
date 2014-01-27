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
	private StockArticle selection;
	// Invoice TableViewer selection
	private List<Article> articles;
	
	@Execute
	public void execute(@Optional
	@Named("commandparameter.addAsPrescriptionStockArticle")
	String stockArticle, @Optional
	@Named("commandparameter.addAsPrescriptionArticle")
	String articleList, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		
		Prescription p = ModelFactory.eINSTANCE.createPrescription();
		PrescriptionDialog dlg = new PrescriptionDialog(shell, getNotYetPrescriptedArticle());
		dlg.setPrescription(p);
		
		if (dlg.open() == IDialogConstants.OK_ID) {
			if (p != null) {
				if (p.getArticle().contains(selection.getArticle())) {
					selection.setNumberOnStock(selection.getNumberOnStock() - 1);
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
	}
	
	private List<Article> getNotYetPrescriptedArticle(){
		if (articles == null || articles.isEmpty()) {
			articles = new ArrayList<>();
			articles.add(selection.getArticle());
			return articles;
		}
		
		List<Article> notPrescripted = new ArrayList<Article>();
		List<Article> prescripted = new ArrayList<Article>();
		
		// get all articles that have a prescription
		for (Prescription p : SampleModel.getInvoice().getPrescription()) {
			prescripted.addAll(p.getArticle());
		}
		
		// add only articles that have no prescription yet
		for (Article article : articles) {
			if (!prescripted.contains(article)) {
				notPrescripted.add(article);
			}
		}
		
		// add article selected on articlelist part
		if (selection != null) {
			notPrescripted.add(selection.getArticle());
		}
		return notPrescripted;
	}
	
	@CanExecute
	public boolean canExecute(){
		initArticleListSelection();
		initInvoiceSelection();
		
		if (selection == null && articles == null) {
			return false;
		}
		if (selection.getNumberOnStock() < 1) {
			this.selection = null;
			return false;
		}
		return true;
	}
	
	private void initArticleListSelection(){
		// is an article from the article list selected
		Object selection = selectionService.getSelection(Messages.getString("ID_PART_ARTICLELIST"));
		
		if (selection != null && selection instanceof StockArticle) {
			this.selection = (StockArticle) selection;
		} else {
			this.selection = null;
		}
	}
	
	private void initInvoiceSelection(){
		// are there articles on the invoice data part
		Object selection =
			selectionService.getSelection(Messages.getString("ID_PART_INVOICE_DATA"));
		
		if (selection != null && selection instanceof List<?>) {
			this.articles = (List<Article>) selection;
		} else {
			this.articles = null;
		}
	}
}