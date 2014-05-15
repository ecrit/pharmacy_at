package at.medevit.ecrit.pharmacy_at.application.handler.seller.parts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.application.dialog.PrescriptionDialog;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class EditPrescriptionViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	private Prescription selection;
	
	@Execute
	public void execute(@Named("commandparameter.editPrescription")
	String prescription, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		PrescriptionDialog dlg = new PrescriptionDialog(shell, getAvailableArticles());
		dlg.setPrescription(selection);
		dlg.setSelectedArticles(selection.getArticle());
		
		if (dlg.open() == IDialogConstants.OK_ID) {
			List<String> partIds = new ArrayList<String>();
			partIds.add(AppModelId.PART_PART_INVOICE);
			PartUpdater.updatePart(partService, partIds);
			
		}
	}
	
	@CanExecute
	public boolean canExecute(){
		if (SampleModel.getPharmacy().getCurrentUser().getRole().contains(UserRole.SELLER)) {
			selection =
				CommandUtil.getSelectionOfType(Prescription.class,
					selectionService.getSelection(AppModelId.PART_PART_PRESCRIPTION));
			if (selection != null) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	private List<Article> getAvailableArticles(){
		List<Article> availableArticles = new ArrayList<Article>();
		availableArticles.addAll(selection.getArticle());
		availableArticles.addAll(SampleModel.getNotYetPrescriptedArticle());
		
		return availableArticles;
	}
	
}