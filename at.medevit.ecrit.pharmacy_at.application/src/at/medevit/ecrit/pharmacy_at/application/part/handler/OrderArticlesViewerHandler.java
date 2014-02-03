package at.medevit.ecrit.pharmacy_at.application.part.handler;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.util.EcoreUtil;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.part.StockOrderOverviewPart;
import at.medevit.ecrit.pharmacy_at.application.part.StockOrderPart;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
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
		StockOrder order = setupStockOrder();
		SampleModel.addStockOrder(order);
		
		for (StockOrder so : SampleModel.getAllStockOrders()) {
			System.out.println(so.getArticle().size());
		}
		
		MPart part1 = partService.findPart(Messages.getString("ID_PART_STOCKORDER"));
		StockOrderPart stockOrderPart = (StockOrderPart) part1.getObject();
		stockOrderPart.updatePart();
		
		MPart part2 = partService.findPart(Messages.getString("ID_PART_STOCKORDER_OVERVIEW"));
		StockOrderOverviewPart sooPart = (StockOrderOverviewPart) part2.getObject();
// sooPart.update();
	}
	
	private StockOrder setupStockOrder(){
		StockOrder stockOrder = ModelFactory.eINSTANCE.createStockOrder();
		
		Random rnd = new Random();
		stockOrder.setNumber(rnd.nextInt(Integer.MAX_VALUE));
		stockOrder.setBoundFor(SampleModel.getStock());
		stockOrder.setIssuer("TestIssuer");
		stockOrder.setStatus(StockOrderStatus.ORDERED);
		
		for (StockArticle sa : articlesToOrder) {
			for (int i = 0; i < sa.getNumberOrdered(); i++) {
				stockOrder.getArticle().add(EcoreUtil.copy(sa.getArticle()));
			}
		}
		return stockOrder;
	}
	
	@CanExecute
	public boolean canExecute(){
		Object selection = selectionService.getSelection(Messages.getString("ID_PART_STOCKORDER"));
		if (selection != null && selection instanceof List<?>) {
			this.articlesToOrder = (List<StockArticle>) selection;
			return true;
		} else {
			this.articlesToOrder = null;
			return false;
		}
	}
	
}