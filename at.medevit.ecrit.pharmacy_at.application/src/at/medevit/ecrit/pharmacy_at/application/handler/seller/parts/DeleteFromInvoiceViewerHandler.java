package at.medevit.ecrit.pharmacy_at.application.handler.seller.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.application.dialog.DeleteFromPrescriptionDialog;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class DeleteFromInvoiceViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	@Execute
	public void execute(@Named("commandparameter.deleteFromInvocie")
	String articleToDelete, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		Article a = (Article) selectionService.getSelection(AppModelId.PART_PART_INVOICEDATA);
		
		List<Prescription> relevantPrescriptions = getRelevantPrescriptions(a);
		if (!relevantPrescriptions.isEmpty()) {
			boolean isSingleInvoiceArticle = SampleModel.isSingleInvoiceArticle(a);
			
			DeleteFromPrescriptionDialog dlg =
				new DeleteFromPrescriptionDialog(shell, relevantPrescriptions,
					isSingleInvoiceArticle);
			
			if (dlg.open() == IDialogConstants.OK_ID) {
				// nothing was selected in the dialog
				if (relevantPrescriptions.isEmpty()) {
					// if article only exists once as prescription return and show a warning it
					// wasn't deleted as nothing was selected
					if (isSingleInvoiceArticle) {
						MessageDialog
							.openWarning(shell, "Not deleted",
								"The article only exists on prescription and therefore must be deleted from there too!");
						return;
					}
				} else {
					Prescription selectedPrescription = relevantPrescriptions.get(0);
					selectedPrescription.getArticle().remove(a);
					
					if (selectedPrescription.getArticle().isEmpty()) {
						SampleModel.getInvoice().getPrescription().remove(selectedPrescription);
					}
					PartUpdater.updatePart(partService,
						Collections.singletonList(AppModelId.PART_PART_PRESCRIPTION));
				}
			}
		}
		SampleModel.removeArticleFromInvoice(a);
		
		List<String> partIds = new ArrayList<String>();
		partIds.add(AppModelId.PART_PART_PRESCRIPTION);
		partIds.add(AppModelId.PART_PART_INVOICEDATA);
		partIds.add(AppModelId.PART_PART_INVOICE);
		PartUpdater.updatePart(partService, partIds);
	}
	
	private List<Prescription> getRelevantPrescriptions(Article a){
		List<Prescription> prescriptions = SampleModel.getInvoice().getPrescription();
		List<Prescription> relevantPrescriptions = new ArrayList<Prescription>();
		
		for (Prescription p : prescriptions) {
			List<Article> articles = p.getArticle();
			for (Article arti : articles) {
				if (arti.getName().equals(a.getName())) {
					relevantPrescriptions.add(p);
					break;
				}
			}
		}
		return relevantPrescriptions;
	}
	
	@CanExecute
	public boolean canExecute(){
		if (SampleModel.getPharmacy().getCurrentUser().getRole().contains(UserRole.SELLER)) {
			Object selection =
				CommandUtil.getSelectionOfType(Article.class,
					selectionService.getSelection(AppModelId.PART_PART_INVOICEDATA));
			if (selection != null) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
}