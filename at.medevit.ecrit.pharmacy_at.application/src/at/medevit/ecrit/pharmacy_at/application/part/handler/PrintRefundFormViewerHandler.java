package at.medevit.ecrit.pharmacy_at.application.part.handler;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.util.PrintRefundPDF;

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
		Object selection =
			selectionService.getSelection(Messages
				.getString("ID_PART_INVOICE_PRESCRIPTION_OVERVIEW"));
		if (selection != null && selection instanceof Object[]) {
			this.checked = Arrays.asList((Object[]) selection);
			return true;
		} else {
			this.checked = null;
			return false;
		}
	}
	
}