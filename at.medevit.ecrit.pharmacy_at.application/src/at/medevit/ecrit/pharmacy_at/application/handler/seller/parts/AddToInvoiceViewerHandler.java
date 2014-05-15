package at.medevit.ecrit.pharmacy_at.application.handler.seller.parts;

import java.util.Collections;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.Active;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.application.part.InvoiceDataPart;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class AddToInvoiceViewerHandler {
	@Inject
	private EModelService modelService;
	@Inject
	private MWindow window;
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	private StockArticle selection;
	
	@Execute
	public void execute(@Named("commandparameter.modelelement.Article") String stockArticle){
		selection.setNumberOnStock(selection.getNumberOnStock() - 1);
		
		// put a copy of this article on the invoice
		Article article = SampleModel.getValidArticleCopy(selection.getArticle());
		SampleModel.getInvoice().getArticle().add(article);
		
		InvoiceDataPart invDataPart =
			(InvoiceDataPart) partService.findPart(AppModelId.PART_PART_INVOICEDATA).getObject();
		invDataPart.addArticleAndUpdate(selection.getArticle());
		
		PartUpdater
			.updatePart(partService, Collections.singletonList(AppModelId.PART_PART_INVOICE));
		
	}
	
	@CanExecute
	public boolean canExecute(@Active MPart activePart){
		if (SampleModel.getPharmacy().getCurrentUser().getRole().contains(UserRole.SELLER)) {
			if (modelService.getActivePerspective(window).getElementId()
				.equals(AppModelId.PERSPECTIVE_PERSPECTIVE_SELLER)) {
				MMenuElement addToInvoiceMenu = activePart.getMenus().get(0).getChildren().get(0);
				addToInvoiceMenu.setVisible(true);
				
				this.selection =
					CommandUtil.getSelectionOfType(StockArticle.class,
						selectionService.getSelection(AppModelId.PART_PART_ARTICLELIST));
				if (selection != null && selection.getNumberOnStock() > 0) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			MMenuElement addToInvoiceMenu = activePart.getMenus().get(0).getChildren().get(0);
			addToInvoiceMenu.setVisible(false);
			return false;
		}
		return false;
	}
}
