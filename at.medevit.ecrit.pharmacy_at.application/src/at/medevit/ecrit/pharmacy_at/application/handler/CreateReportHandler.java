package at.medevit.ecrit.pharmacy_at.application.handler;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.dialog.ReportDialog;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.Report;

public class CreateReportHandler {
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		Report report = ModelFactory.eINSTANCE.createReport();
		ReportDialog dlg = new ReportDialog(shell, report);
		
		if (dlg.open() == IDialogConstants.OK_ID) {
			SampleModel.addReport(report);
		}
	}
	
	@CanExecute
	public boolean canExecute(){
		return true;
	}
	
}