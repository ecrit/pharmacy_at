package at.medevit.ecrit.pharmacy_at.application.part.handler;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.part.PrescriptionPart;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class DeletePrescriptionViewerHandler {
	
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
		SampleModel.getInvoice().getPrescription().remove(selection);
		
		((PrescriptionPart) PartUpdater.findPart(Messages.getString("ID_PART_PRESCRIPTION")))
			.deselectAll();
		List<String> partIds = new ArrayList<String>();
		partIds.add(Messages.getString("ID_PART_PRESCRIPTION"));
		partIds.add(Messages.getString("ID_PART_INVOICE_DATA"));
		partIds.add(Messages.getString("ID_PART_INVOICE"));
		PartUpdater.updatePart(partService, partIds);
	}
	
	@CanExecute
	public boolean canExecute(){
		selection =
			CommandUtil.getSelectionOfType(Prescription.class,
				selectionService.getSelection(Messages.getString("ID_PART_PRESCRIPTION")));
		if (selection != null) {
			return true;
		} else {
			return false;
		}
	}
}