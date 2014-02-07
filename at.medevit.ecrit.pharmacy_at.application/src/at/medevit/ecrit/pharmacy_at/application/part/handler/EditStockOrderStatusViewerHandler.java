package at.medevit.ecrit.pharmacy_at.application.part.handler;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.part.ArticleListPart;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;
import at.medevit.ecrit.pharmacy_at.model.StockOrder;

public class EditStockOrderStatusViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	private StockOrder selection;
	
	@Execute
	public void execute(@Named("commandparameter.editStockOrderStatus")
	String stockOrder){
		HashMap<String, Integer> articleAmountMap = new HashMap<>();
		for (Article a : selection.getArticle()) {
			if (articleAmountMap.containsKey(a.getName())) {
				int newAmount = articleAmountMap.get(a.getName()) + 1;
				articleAmountMap.put(a.getName(), newAmount);
			} else {
				articleAmountMap.put(a.getName(), 1);
			}
			System.out.println(a.getName());
		}
		
		for (String name : articleAmountMap.keySet()) {
			for (StockArticle sa : SampleModel.getStock().getArticles()) {
				if (name.equals(sa.getArticle().getName())) {
					int newOnStockValue = sa.getNumberOnStock() + articleAmountMap.get(name);
					int newOrderedValue = sa.getNumberOrdered() - articleAmountMap.get(name);
					sa.setNumberOnStock(newOnStockValue);
					sa.setNumberOrdered(newOrderedValue);
				}
			}
		}
		
		MPart part = partService.findPart(Messages.getString("ID_PART_ARTICLELIST"));
		ArticleListPart alPart = (ArticleListPart) part.getObject();
		alPart.updatePart();
	}
	
	@CanExecute
	public boolean canExecute(){
		Object selection =
			selectionService.getSelection(Messages.getString("ID_PART_STOCKORDER_OVERVIEW"));
		if (selection != null && selection instanceof StockOrder) {
			this.selection = (StockOrder) selection;
			return true;
		} else {
			this.selection = null;
			return false;
		}
	}
	
}