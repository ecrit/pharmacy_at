package at.medevit.ecrit.pharmacy_at.application.handler.seller;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.dialog.PrescriptionDialog;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class OpenPrescriptionHandler {
	
	@Inject
	private ESelectionService selectionService;
	
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		Prescription p =
			(Prescription) selectionService
				.getSelection(Messages.getString("ID_PART_PRESCRIPTION"));
		
		PrescriptionDialog dlg = new PrescriptionDialog(shell, p.getArticle());
		dlg.setPrescription(p);
		dlg.disableSelection();
		dlg.open();
	}
	
	@CanExecute
	public boolean canExecute(){
		Object selection =
			selectionService.getSelection(Messages.getString("ID_PART_PRESCRIPTION"));
		if (selection != null && selection instanceof Prescription) {
			return true;
		} else {
			return false;
		}
	}
}