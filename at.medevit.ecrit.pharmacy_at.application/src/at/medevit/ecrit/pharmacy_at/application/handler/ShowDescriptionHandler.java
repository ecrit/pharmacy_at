 
package at.medevit.ecrit.pharmacy_at.application.handler;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import at.medevit.ecrit.pharmacy_at.application.part.PropertiesPart;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class ShowDescriptionHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	private static final String ID_PROPERTIES_PART = "at.medevit.ecrit.pharmacy_at.application.part.properties";
	private static final String ID_ARTILELIST_PART = "at.medevit.ecrit.pharmacy_at.application.part.articlelist";
	
	@Execute
	public void execute() {
		StockArticle stockArticle = (StockArticle)selectionService.getSelection(ID_ARTILELIST_PART);
		
		MPart mPart = partService.findPart(ID_PROPERTIES_PART);
		PropertiesPart propertyPart = (PropertiesPart) mPart.getObject();
//		propertyPart.setArticle(stockArticle.getArticle());
				
		
	}
		
}