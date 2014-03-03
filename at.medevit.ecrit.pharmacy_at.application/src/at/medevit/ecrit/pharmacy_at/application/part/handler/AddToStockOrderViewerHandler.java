package at.medevit.ecrit.pharmacy_at.application.part.handler;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.util.EcoreUtil;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.part.StockOrderPart;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class AddToStockOrderViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	// TableViewer selection
	private StockArticle selection;
	private List<StockArticle> articleToOrder;
	
	@Execute
	public void execute(@Named("commandparameter.modelelement.addToStockOrder")
	String stockArticle){
		StockOrderPart stockOrderPart =
			(StockOrderPart) partService.findPart(Messages.getString("ID_PART_STOCKORDER"))
				.getObject();
		if (isNoDuplicate()) {
			selection.setNumberOrdered(1);
			articleToOrder.add(EcoreUtil.copy(selection));
		}
		stockOrderPart.updateArticlesToOrder(articleToOrder);
	}
	
	private boolean isNoDuplicate(){
		String articleName = selection.getArticle().getName();
		for (StockArticle sa : articleToOrder) {
			if (articleName.equals(sa.getArticle().getName())) {
				return false;
			}
		}
		return true;
	}
	
	@CanExecute
	public boolean canExecute(){
		selection =
			CommandUtil.getSelectionOfType(StockArticle.class,
				selectionService.getSelection(Messages.getString("ID_PART_ARTICLELIST")));
		articleToOrder =
			CommandUtil.getSelectionOfType(List.class,
				selectionService.getSelection(Messages.getString("ID_PART_STOCKORDER")));
		
		if (selection == null && (articleToOrder == null || articleToOrder.isEmpty())) {
			return false;
		} else {
			return true;
		}
	}
}