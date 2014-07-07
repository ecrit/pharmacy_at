package at.medevit.ecrit.pharmacy_at.fragment.handler;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class AboutHandler {
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell){
		MessageDialog
			.openInformation(
				shell,
				"About",
				"This is the PharmAT demo application created during the Ecrit project!\nFor further information see: www.ecrit.at");
	}
	
}