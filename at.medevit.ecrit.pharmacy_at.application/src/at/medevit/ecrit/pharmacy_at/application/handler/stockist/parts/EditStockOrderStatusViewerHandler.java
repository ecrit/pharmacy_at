package at.medevit.ecrit.pharmacy_at.application.handler.stockist.parts;

import java.util.Collections;
import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
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
		HashMap<String, Integer> articleAmountMap = calcUnitsPerArticle();
		
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
		SampleModel.update();
		PartUpdater.updatePart(partService,
			Collections.singletonList(AppModelId.PART_PART_ARTICLELIST));
	}
	
	private HashMap<String, Integer> calcUnitsPerArticle(){
		HashMap<String, Integer> articleAmountMap = new HashMap<>();
		for (Article a : selection.getArticle()) {
			if (articleAmountMap.containsKey(a.getName())) {
				int newAmount = articleAmountMap.get(a.getName()) + 1;
				articleAmountMap.put(a.getName(), newAmount);
			} else {
				articleAmountMap.put(a.getName(), 1);
			}
		}
		return articleAmountMap;
	}
	
	@CanExecute
	public boolean canExecute(){
		// TODO only allow in stockist tab/ for stockist user
		Object selection =
			selectionService.getSelection(AppModelId.PART_PART_STOCKORDEROVERVIEW);
		if (selection != null && selection instanceof StockOrder) {
			this.selection = (StockOrder) selection;
			return true;
		} else {
			this.selection = null;
			return false;
		}
	}
	
}