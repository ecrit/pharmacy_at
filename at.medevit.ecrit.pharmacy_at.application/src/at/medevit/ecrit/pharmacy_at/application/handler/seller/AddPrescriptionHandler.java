package at.medevit.ecrit.pharmacy_at.application.handler.seller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.SampleModel;
import at.medevit.ecrit.pharmacy_at.application.dialog.PrescriptionDialog;
import at.medevit.ecrit.pharmacy_at.application.part.InvoicePart;
import at.medevit.ecrit.pharmacy_at.application.part.PrescriptionPart;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.Prescription;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class AddPrescriptionHandler {

	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		List<Article> articles = (List<Article>) selectionService.getSelection(Messages.ID_PART_INVOICE_DATA);

		Prescription p = ModelFactory.eINSTANCE.createPrescription();
		PrescriptionDialog dlg = new PrescriptionDialog(shell, getNotYetPrescriptedArticle(articles));
		dlg.setPrescription(p);
		
		int retVal = dlg.open();
		if (retVal == IDialogConstants.OK_ID) {
			if (p != null) {
				SampleModel.getInvoice().getPrescription().add(p);
				List<Article>aList = SampleModel.getInvoice().getArticle();
				List<Article>paList = p.getArticle();
				
				// if article is directly added to prescription 
				// add to invoice articles as well
				for (Article a : paList) {
					if(!aList.contains(a)){
						SampleModel.getInvoice().getArticle().add(a);
					}
				}

				// assure tables are updated properly
				// TODO check if this can be solved via injection as well (selection inj. didn't work as expected)
				MPart pPart = partService.findPart(Messages.ID_PART_PRESCRIPTION);
				PrescriptionPart prescPart = (PrescriptionPart) pPart.getObject();
				prescPart.updateTable();
				
				MPart iPart = partService.findPart(Messages.ID_PART_INVOICE);
				InvoicePart invoicePart = (InvoicePart) iPart.getObject();
				invoicePart.updateTable();
			}
		}
	}

	private List<Article> getNotYetPrescriptedArticle(List<Article> articles) {
		List<Article> notPrescripted = new ArrayList<Article>();
		List<Article> prescripted = new ArrayList<Article>();
		
		// get all articles that have a prescription
		for (Prescription p : SampleModel.getInvoice().getPrescription()) {
			prescripted.addAll(p.getArticle());
		}
		
		// add only articles that have no prescription yet
		for (Article article : articles) {
			if(!prescripted.contains(article)){
				notPrescripted.add(article);
			}			
		}
		return notPrescripted; 
	}

	@CanExecute
	public boolean canExecute() {
		Object selection = selectionService.getSelection(Messages.ID_PART_INVOICE_DATA);
		if (selection != null && selection instanceof List<?>) {
			return true;
		} else {
			return false;
		}
	}
}