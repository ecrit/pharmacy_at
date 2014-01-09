package at.medevit.ecrit.pharmacy_at.application.handler;

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

import at.medevit.ecrit.pharmacy_at.application.dialog.PrescriptionDialog;
import at.medevit.ecrit.pharmacy_at.application.part.PrescriptionPart;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class AddPrescriptionHandler {

	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;

	private static final String ID_BILL_PART = "at.medevit.ecrit.pharmacy_at.application.part.bill";
	private static final String ID_PRESCRIPTION_PART = "at.medevit.ecrit.pharmacy_at.application.part.prescription";

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		List<Article> articles = (List<Article>) selectionService.getSelection(ID_BILL_PART);

		Prescription p = ModelFactory.eINSTANCE.createPrescription();
		PrescriptionDialog dlg = new PrescriptionDialog(shell, articles);
		dlg.setPrescription(p);
		
		int retVal = dlg.open();
		if (retVal == IDialogConstants.OK_ID) {
			if (p != null) {
				// TODO once proper model exists -> binding should solves this
				MPart mPart = partService.findPart(ID_PRESCRIPTION_PART);
				PrescriptionPart prescPart = (PrescriptionPart) mPart
						.getObject();
				prescPart.addPrescription(p);

				// TODO remove articles that have a prescription already from
				// list that goes to prescription selection
				// BillPart billPart = (BillPart)
				// partService.findPart(ID_BILL_PART).getObject();
			}
		}
	}

	@CanExecute
	public boolean canExecute() {
		Object selection = selectionService.getSelection(ID_BILL_PART);
		if (selection != null && selection instanceof List<?>) {
			return true;
		} else {
			return false;
		}
	}
}