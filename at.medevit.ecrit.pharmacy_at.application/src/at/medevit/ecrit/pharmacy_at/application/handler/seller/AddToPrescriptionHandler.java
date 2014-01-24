package at.medevit.ecrit.pharmacy_at.application.handler.seller;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.part.PrescriptionPart;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Prescription;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class AddToPrescriptionHandler {
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	@Execute
	public void execute(){
		StockArticle a =
			(StockArticle) selectionService.getSelection(Messages.getString("ID_PART_ARTICLELIST"));
		a.setNumberOnStock(a.getNumberOnStock() - 1);
		
		MPart part = partService.findPart(Messages.getString("ID_PART_PRESCRIPTION"));
		PrescriptionPart presPart = (PrescriptionPart) part.getObject();
		Prescription p =
			(Prescription) selectionService
				.getSelection(Messages.getString("ID_PART_PRESCRIPTION"));
		
		p.getArticle().add(a.getArticle());
		SampleModel.getInvoice().getArticle().add(a.getArticle());
		
	}
	
	@CanExecute
	public boolean canExecute(){
		Object selection = selectionService.getSelection(Messages.getString("ID_PART_ARTICLELIST"));
		if (selection != null && selection instanceof StockArticle) {
			return true;
		} else {
			return false;
		}
	}
}