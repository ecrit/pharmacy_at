 
package at.medevit.ecrit.pharmacy_at.application.handler;

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
	
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		List<Article> articles = (List<Article>)selectionService.getSelection();
		if(articles == null){
			articles = new ArrayList<Article>();
		}
		Prescription p = ModelFactory.eINSTANCE.createPrescription();
		PrescriptionDialog dlg = new PrescriptionDialog(shell, articles);
		dlg.setPrescription(p);
//		dlg.create();
		int retVal = dlg.open();
		
		if(retVal == IDialogConstants.OK_ID){
			if (p != null) {
				MPart mPart = partService.findPart("at.medevit.ecrit.pharmacy_at.application.part.prescription");
				PrescriptionPart prescPart = (PrescriptionPart) mPart.getObject();
				prescPart.addPrescription(p);
			}
		}
	}

//	@CanExecute
//	public boolean canExecute() {
//		if(selectionService.getSelection() != null){
//			return true;
//		}else{
//			return false;
//		}
//	}
}