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
import at.medevit.ecrit.pharmacy_at.application.part.InvoicePart;
import at.medevit.ecrit.pharmacy_at.application.part.PrescriptionPart;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class DeletePrescriptionHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	// equivalent to wished commandparameter (only there for documentation reasons currently)
	private Prescription selection;
	
	@Execute
	public void execute(@Named("commandparameter.deletePrescription")
	String prescription, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		SampleModel.deletePrescription(selection);
		
		MPart pPart = partService.findPart(Messages.getString("ID_PART_PRESCRIPTION"));
		PrescriptionPart prescPart = (PrescriptionPart) pPart.getObject();
		prescPart.deselectAll();
		prescPart.updateTable();
		
		MPart iPart = partService.findPart(Messages.getString("ID_PART_INVOICE"));
		InvoicePart invoicePart = (InvoicePart) iPart.getObject();
		invoicePart.updateTable();
	}
	
	@CanExecute
	public boolean canExecute(){
		Object selection =
			selectionService.getSelection(Messages.getString("ID_PART_PRESCRIPTION"));
		if (selection != null && selection instanceof Prescription) {
			this.selection = (Prescription) selection;
			return true;
		} else {
			this.selection = null;
			return false;
		}
	}
	
}