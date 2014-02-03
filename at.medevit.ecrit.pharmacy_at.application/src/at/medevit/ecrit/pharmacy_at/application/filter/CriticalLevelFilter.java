package at.medevit.ecrit.pharmacy_at.application.filter;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class CriticalLevelFilter extends ViewerFilter {
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element){
		StockArticle sArticle = (StockArticle) element;
		int onStock = sArticle.getNumberOnStock();
		int lowerBound = sArticle.getLowerBound();
		
		if (onStock <= lowerBound) {
			return true;
		}
		return false;
	}
	
}
