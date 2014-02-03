package at.medevit.ecrit.pharmacy_at.application.part.handler;

import java.util.ArrayList;
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

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.dialog.PrescriptionDialog;
import at.medevit.ecrit.pharmacy_at.application.part.InvoicePart;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class EditPrescriptionViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	private Prescription selection;
	
	@Execute
	public void execute(@Named("commandparameter.editPrescription")
	String prescription, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		PrescriptionDialog dlg = new PrescriptionDialog(shell, getAvailableArticles());
		dlg.setPrescription(selection);
		dlg.setSelectedArticles(selection.getArticle());
		
		if (dlg.open() == IDialogConstants.OK_ID) {
			MPart iPart = partService.findPart(Messages.getString("ID_PART_INVOICE"));
			InvoicePart invoicePart = (InvoicePart) iPart.getObject();
			invoicePart.updateTable();
		}
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
	
	private List<Article> getAvailableArticles(){
		List<Article> availableArticles = new ArrayList<Article>();
		availableArticles.addAll(selection.getArticle());
		availableArticles.addAll(SampleModel.getNotYetPrescriptedArticle());
		
		return availableArticles;
	}
	
}