package at.medevit.ecrit.pharmacy_at.application.part.handler;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.part.StockOrderPart;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;
import at.medevit.ecrit.pharmacy_at.model.StockOrder;
import at.medevit.ecrit.pharmacy_at.model.StockOrderStatus;

public class OrderArticlesViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	private List<StockArticle> articlesToOrder;
	
	@Execute
	public void execute(@Named("commandparameter.modelelement.articlesToOrder")
	String articlesToOrder){
		StockOrder order = setOrderValues();
		SampleModel.addStockOrder(order);
		
		for (StockOrder so : SampleModel.getPharmacy().getStockOrders()) {
			System.out.println(so.getArticle().size());
		}
		
		StockOrderPart stockOrderPart =
			((StockOrderPart) partService.findPart(Messages.getString("ID_PART_STOCKORDER"))
				.getObject());
		stockOrderPart.cleanPart();
		List<String> partIds = new ArrayList<String>();
		partIds.add(Messages.getString("ID_PART_STOCKORDER_OVERVIEW"));
		partIds.add(Messages.getString("ID_PART_ARTICLELIST"));
		PartUpdater.updatePart(partService, partIds);
		
	}
	
	private StockOrder setOrderValues(){
		StockOrder stockOrder = SampleModel.getStockOrder();
		stockOrder.setStatus(StockOrderStatus.ORDERED);
		
		for (StockArticle sa : articlesToOrder) {
			for (int i = 0; i < sa.getNumberOrdered(); i++) {
				stockOrder.getArticle().add(SampleModel.getValidArticleCopy(sa.getArticle()));
			}
		}
		return stockOrder;
	}
	
	@CanExecute
	public boolean canExecute(){
		articlesToOrder =
			CommandUtil.getSelectionOfType(List.class,
				selectionService.getSelection(Messages.getString("ID_PART_STOCKORDER")));
		if (articlesToOrder != null) {
			return true;
		} else {
			return false;
		}
	}
	
}