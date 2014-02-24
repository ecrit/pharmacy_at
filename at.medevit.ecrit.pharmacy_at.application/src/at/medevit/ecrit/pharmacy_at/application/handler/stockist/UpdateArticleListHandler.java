package at.medevit.ecrit.pharmacy_at.application.handler.stockist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.part.ArticleListPart;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ArticleAvailability;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class UpdateArticleListHandler {
	
	private static String DELIMITER = "|";
	private static int NAME_IDX = 0;
	private static int ADM_NR_IDX = 1;
	private static int DESCRIPTION_IDX = 2;
	private static int PRICE_IDX = 3;
	
	private List<StockArticle> catalog;
	private List<StockArticle> local;
	private StockArticle matchingArticle;
	private int blacklistCounter;
	private int removedCounter;
	
	@Inject
	private EPartService partService;
	
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		FileDialog fileDialog = new FileDialog(shell, SWT.OPEN);
		fileDialog.setText("Load");
		fileDialog.setFilterPath("C:/");
		String[] filterExt = {
			"*.csv", "*.txt", "*.*"
		};
		fileDialog.setFilterExtensions(filterExt);
		String selected = fileDialog.open();
		if (selected != null) {
			File catalogFile = new File(selected);
			catalog = loadCatalog(catalogFile);
			updateLocalArticleList();
			SampleModel.updateArticleList();
			MessageDialog.openInformation(shell, "Article List Updated",
				"The synchronisation with the article catalog was successfull." + "\n["
					+ blacklistCounter + "] articles blacklisted" + "\n[" + removedCounter
					+ "] articles removed");
			
			MPart part = partService.findPart(Messages.getString("ID_PART_ARTICLELIST"));
			ArticleListPart alPart = (ArticleListPart) part.getObject();
			alPart.updatePart();
		}
	}
	
	private void updateLocalArticleList(){
		handleRemovedArticles();
		
		for (StockArticle sa : catalog) {
			if (containsArticle(local, sa.getArticle())) {
				Float price = matchingArticle.getArticle().getPrice();
				String description = matchingArticle.getArticle().getDescription();
				local.get(local.indexOf(matchingArticle)).getArticle().setPrice(price);
				local.get(local.indexOf(matchingArticle)).getArticle().setDescription(description);
			} else {
				local.add(sa);
			}
		}
		
	}
	
	private void handleRemovedArticles(){
		local = SampleModel.getStock().getArticles();
		blacklistCounter = 0;
		removedCounter = 0;
		
		for (int i = 0; i < local.size(); i++) {
			StockArticle sa = local.get(i);
			if (!containsArticle(catalog, sa.getArticle())) {
				if (sa.getNumberOnStock() > 0 || isUsedAsLineItem(sa.getArticle())) {
					if (sa.getArticle().getAvailability() == ArticleAvailability.AVAILABLE) {
						local.get(i).getArticle().setAvailability(ArticleAvailability.BLACKLISTED);
						blacklistCounter += 1;
					}
				} else {
					local.remove(local.get(i));
					removedCounter += 1;
				}
			}
		}
	}
	
	private boolean isUsedAsLineItem(Article article){
		List<Article> lineItems = SampleModel.getAllLineItems();
		for (Article a : lineItems) {
			if (a.getName().equals(article.getName())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean containsArticle(List<StockArticle> list, Article article){
		for (StockArticle sa : list) {
			if (sa.getArticle().getName().equals(article.getName())) {
				matchingArticle = sa;
				return true;
			}
		}
		return false;
	}
	
	private List<StockArticle> loadCatalog(File catalogFile){
		List<StockArticle> catalog = new ArrayList<StockArticle>();
		
		try {
			String line;
			int counter = 0;
			BufferedReader br = new BufferedReader(new FileReader(catalogFile));
			while ((line = br.readLine()) != null) {
				if (counter != 0) {
					catalog.add(createStockArticle(line));
				}
				counter++;
			}
			br.close();
		} catch (IOException e) {
			// TODO auto-generated
		}
		return catalog;
	}
	
	private StockArticle createStockArticle(String line){
		StockArticle sa = ModelFactory.eINSTANCE.createStockArticle();
		Article a = ModelFactory.eINSTANCE.createArticle();
		String[] splitLine = line.split("\\|");
		
		a.setName(splitLine[NAME_IDX]);
		a.setAdmissionNumber(Integer.parseInt(splitLine[ADM_NR_IDX]));
		a.setDescription(splitLine[DESCRIPTION_IDX]);
		a.setPrice(Float.parseFloat(splitLine[PRICE_IDX]));
		a.setAvailability(ArticleAvailability.AVAILABLE);
		
		sa.setNumberOnStock(0);
		sa.setNumberOrdered(0);
		sa.setLowerBound(0);
		sa.setArticle(a);
		return sa;
	}
	
}