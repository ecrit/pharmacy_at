package at.medevit.ecrit.pharmacy_at.application.filter;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import at.medevit.ecrit.pharmacy_at.model.StockOrder;

public class StockOrderFilter extends ViewerFilter {
	
	private String searchTxt;
	
	public void setSearchText(String s){
		this.searchTxt = s.toLowerCase();
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element){
		if (searchTxt == null || searchTxt.length() == 0) {
			return true;
		}
		
		StockOrder stockOrder = (StockOrder) element;
		if (stockOrder.getIssuer().toLowerCase().contains(searchTxt)) {
			return true;
		}
		if ((Integer.toString(stockOrder.getNumber())).contains(searchTxt)) {
			return true;
		}
		if (stockOrder.getStatus().toString().toLowerCase().contains(searchTxt)) {
			return true;
		}
		return false;
	}
	
}
