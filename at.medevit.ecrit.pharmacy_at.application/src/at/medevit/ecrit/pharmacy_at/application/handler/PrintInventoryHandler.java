package at.medevit.ecrit.pharmacy_at.application.handler;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.util.PrintInventoryPDF;

public class PrintInventoryHandler {
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		new PrintInventoryPDF(shell);
	}
	
}