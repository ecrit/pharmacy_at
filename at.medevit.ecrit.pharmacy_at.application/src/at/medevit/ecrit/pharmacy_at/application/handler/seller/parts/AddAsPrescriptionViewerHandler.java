package at.medevit.ecrit.pharmacy_at.application.handler.seller.parts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.dialog.PrescriptionDialog;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
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
	
	private StockArticle stockArticleSelection;
	private List<Article> prescribables;
	
	@Execute
	public void execute(@Optional
	@Named("commandparameter.addAsPrescriptionStockArticle")
	String stockArticle, @Optional
	@Named("commandparameter.addAsPrescriptionArticle")
	String articleList, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		
		Prescription p = ModelFactory.eINSTANCE.createPrescription();
		PrescriptionDialog dlg = new PrescriptionDialog(shell, prescribables);
		dlg.setPrescription(p);
		
		if (dlg.open() == IDialogConstants.OK_ID) {
			Article arti = includedSelection(p);
			if (arti != null) {
				int articleIdx = p.getArticle().indexOf(arti);
				p.getArticle().set(articleIdx, SampleModel.getValidArticleCopy(arti));
				stockArticleSelection
					.setNumberOnStock(stockArticleSelection.getNumberOnStock() - 1);
				synchPrescriptedArticlesWithInvoice(p);
			}
			SampleModel.getInvoice().getPrescription().add(p);
			
			List<String> partIds = new ArrayList<String>();
			partIds.add(AppModelId.PART_PART_PRESCRIPTION);
			partIds.add(AppModelId.PART_PART_INVOICEDATA);
			partIds.add(AppModelId.PART_PART_INVOICE);
			PartUpdater.updatePart(partService, partIds);
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
	
	@CanExecute
	public boolean canExecute(){
		// TODO only allow in seller tab/ for seller user
		stockArticleSelection =
			CommandUtil.getSelectionOfType(StockArticle.class,
				selectionService.getSelection(AppModelId.PART_PART_ARTICLELIST));
		setPrescribableArticles();
		
		if (stockArticleSelection == null && prescribables.isEmpty()) {
			return false;
		}
		if (stockArticleSelection.getNumberOnStock() < 1) {
			this.stockArticleSelection = null;
			return false;
		}
		prescribables.add(EcoreUtil.copy(stockArticleSelection.getArticle()));
		return true;
	}
	
	private void setPrescribableArticles(){
		List<Article> notPrescripted = SampleModel.getNotYetPrescriptedArticle();
		if (notPrescripted.isEmpty()) {
			prescribables = new ArrayList<Article>();
		} else {
			prescribables = notPrescripted;
		}
	}
	
	private void synchPrescriptedArticlesWithInvoice(Prescription p){
		List<Article> onInvoice = SampleModel.getInvoice().getArticle();
		List<Article> onPrescription = p.getArticle();
		
		for (Article a : onPrescription) {
			if (!onInvoice.contains(a)) {
				SampleModel.getInvoice().getArticle().add(a);
			}
		}
	}
}