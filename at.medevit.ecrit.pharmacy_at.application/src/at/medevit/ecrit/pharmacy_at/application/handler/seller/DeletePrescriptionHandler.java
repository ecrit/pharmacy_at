package at.medevit.ecrit.pharmacy_at.application.handler.seller;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.SampleModel;
import at.medevit.ecrit.pharmacy_at.application.part.InvoicePart;
import at.medevit.ecrit.pharmacy_at.application.part.PrescriptionPart;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class DeletePrescriptionHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		Prescription p = (Prescription) selectionService.getSelection(Messages.ID_PART_PRESCRIPTION);
		SampleModel.getInvoice().getPrescription().remove(p);
		
		MPart pPart = partService.findPart(Messages.ID_PART_PRESCRIPTION);
		PrescriptionPart prescPart = (PrescriptionPart) pPart.getObject();
		prescPart.updateTable();
		
		MPart iPart = partService.findPart(Messages.ID_PART_INVOICE);
		InvoicePart invoicePart = (InvoicePart) iPart.getObject();
		invoicePart.updateTable();
	}

	@CanExecute
	public boolean canExecute() {
		Object selection = selectionService.getSelection(Messages.ID_PART_PRESCRIPTION);
		if (selection != null && selection instanceof Prescription) {
			return true;
		} else {
			return false;
		}
	}

}