package at.medevit.ecrit.pharmacy_at.application.handler.seller.tobereplaced;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Prescription;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class AddToPrescriptionHandler {
	@Inject
	private ESelectionService selectionService;
	
	@Execute
	public void execute(){
		StockArticle a =
			(StockArticle) selectionService.getSelection(Messages.getString("ID_PART_ARTICLELIST"));
		a.setNumberOnStock(a.getNumberOnStock() - 1);
		
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