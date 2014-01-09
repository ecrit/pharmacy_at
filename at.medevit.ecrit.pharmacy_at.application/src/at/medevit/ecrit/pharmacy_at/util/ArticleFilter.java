package at.medevit.ecrit.pharmacy_at.util;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class ArticleFilter extends ViewerFilter {

	private String searchTxt;

	public void setSearchText(String s) {
		this.searchTxt = s.toLowerCase();
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchTxt == null || searchTxt.length() == 0) {
			return true;
		}

		StockArticle article = (StockArticle) element;
		if ((Integer.toString(article.getArticle().getAdmissionNumber()))
				.contains(searchTxt)) {
			return true;
		}

		if (article.getArticle().getAvailability().toString().toLowerCase()
				.contains(searchTxt)) {
			return true;
		}

		if ((article.getArticle().getName().toLowerCase()).contains(searchTxt)) {
			return true;
		}

		if ((article.getArticle().getDescription().toLowerCase()).contains(searchTxt)) {
			return true;
		}

		if (Integer.toString(article.getNumberOnStock()).contains(searchTxt)) {
			return true;
		}

		return false;
	}
}
