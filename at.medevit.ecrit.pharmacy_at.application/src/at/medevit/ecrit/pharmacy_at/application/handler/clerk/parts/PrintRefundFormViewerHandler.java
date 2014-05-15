package at.medevit.ecrit.pharmacy_at.application.handler.clerk.parts;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.application.util.PrintRefundPDF;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;

public class PrintRefundFormViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	private List<Object> checked;
	
	@Execute
	public void execute(@Named("commandparameter.printRefund")
	String selectedPrescriptions, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		new PrintRefundPDF(shell, checked);
	}
	
	@CanExecute
	public boolean canExecute(){
		if (SampleModel.getPharmacy().getCurrentUser().getRole().contains(UserRole.CLERK)) {
			Object selection =
				selectionService.getSelection(AppModelId.PART_PART_INVOICEPRESCRIPTIONOVERVIEW);
			if (selection != null && selection instanceof Object[]) {
				this.checked = Arrays.asList((Object[]) selection);
				return true;
			} else {
				this.checked = null;
				return false;
			}
		}
		this.checked = null;
		return false;
	}
	
}