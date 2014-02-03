package at.medevit.ecrit.pharmacy_at.application.part.handler;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.part.StockOrderPart;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class AddToStockOrderViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	// TableViewer selection
	private StockArticle selection;
	
	@Execute
	public void execute(@Named("commandparameter.modelelement.addToStockOrder")
	String stockArticle){
		MPart part = partService.findPart(Messages.getString("ID_PART_STOCKORDER"));
		StockOrderPart stockOrderPart = (StockOrderPart) part.getObject();
		stockOrderPart.addArticle(selection);
	}
	
	@CanExecute
	public boolean canExecute(){
		Object selection = selectionService.getSelection(Messages.getString("ID_PART_ARTICLELIST"));
		if (selection != null && selection instanceof StockArticle) {
			this.selection = (StockArticle) selection;
			return true;
		} else {
			this.selection = null;
			return false;
		}
	}
	
}