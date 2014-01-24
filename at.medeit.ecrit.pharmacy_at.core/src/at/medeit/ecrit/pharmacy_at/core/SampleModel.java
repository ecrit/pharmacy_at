package at.medeit.ecrit.pharmacy_at.core;

import java.util.Calendar;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ArticleAvailability;
import at.medevit.ecrit.pharmacy_at.model.Invoice;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.Stock;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;
import at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl;

public class SampleModel {
	static ModelFactory factory = ModelFactory.eINSTANCE;
	static Resource resource = null;
	
	public static Resource getSampleModel(){
		if (resource == null) {
			ModelPackageImpl.init();
			initSampleModel();
		}
		return resource;
	}
	
	public static Stock getStock(){
		Resource s = getSampleModel();
		return (Stock) s.getContents().get(0);
	}
	
	public static Invoice getInvoice(){
		Resource s = getSampleModel();
		return (Invoice) s.getContents().get(1);
	}
	
	public static void revertInvoice(Invoice i){
		resource.getContents().remove(i);
		resource.getContents().add(initInvoice());
	}
	
	public static void addArticleToInvoice(StockArticle stockArticle){
		Article arti = EcoreUtil.copy(stockArticle.getArticle());
		getInvoice().getArticle().add(arti);
	}
	
	private static void initSampleModel(){
		ResourceSet resSet = new ResourceSetImpl();
		// Create a resource
		resource = resSet.createResource(URI.createURI("pharmacy_at/my.model"));
		
		Stock stock = initStock();
		Invoice i1 = initInvoice();
		
		resource.getContents().add(stock);
		resource.getContents().add(i1);
		
		// try {
		// resource.save(Collections.EMPTY_MAP);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}
	
	private static Stock initStock(){
		Stock stock = factory.createStock();
		
		Article a1 = factory.createArticle();
		a1.setAdmissionNumber(012345);
		a1.setAvailability(ArticleAvailability.AVAILABLE);
		a1.setDescription("This medicin has multiple usage cases but be careful and don't take all at once");
		a1.setName("Aspirin");
		a1.setPrice(3.0f);
		StockArticle sa1 = factory.createStockArticle();
		sa1.setArticle(a1);
		sa1.setLowerBound(5);
		sa1.setNumberOnStock(40);
		
		Article a2 = factory.createArticle();
		a2.setAdmissionNumber(012346);
		a2.setAvailability(ArticleAvailability.AVAILABLE);
		a2.setDescription("This is an advanced form of the normal aspirin. \n"
			+ "It has multiple usage cases but be careful and don't take all at once");
		a2.setName("Aspirin Complex");
		a2.setPrice(4.0f);
		StockArticle sa2 = factory.createStockArticle();
		sa2.setArticle(a2);
		sa2.setLowerBound(0);
		sa2.setNumberOnStock(20);
		
		Article a3 = factory.createArticle();
		a3.setAdmissionNumber(034343);
		a3.setAvailability(ArticleAvailability.AVAILABLE);
		a3.setDescription("Adviced dose per day: 2 pieces a day (i.e. one in the morning, one in the evening)");
		a3.setName("MagicPainkiller");
		a3.setPrice(8.0f);
		StockArticle sa3 = factory.createStockArticle();
		sa3.setArticle(a3);
		sa3.setLowerBound(0);
		sa3.setNumberOnStock(20);
		
		Article a4 = factory.createArticle();
		a4.setAdmissionNumber(001122);
		a4.setAvailability(ArticleAvailability.BLACKLISTED);
		a4.setDescription("Be careful, as it can cause insomnia");
		a4.setName("Coffedrops");
		a4.setPrice(3.0f);
		StockArticle sa4 = factory.createStockArticle();
		sa4.setArticle(a4);
		sa4.setLowerBound(0);
		sa4.setNumberOnStock(8);
		
		Article a5 = factory.createArticle();
		a5.setAdmissionNumber(010203);
		a5.setAvailability(ArticleAvailability.AVAILABLE);
		a5.setDescription("Usually to use once a week. Can be used more often if adviced by issuing practitioner");
		a5.setName("Elmex Zahngel");
		a5.setPrice(4.0f);
		StockArticle sa5 = factory.createStockArticle();
		sa5.setArticle(a5);
		sa5.setLowerBound(0);
		sa5.setNumberOnStock(77);
		
		stock.getArticles().add(sa1);
		stock.getArticles().add(sa2);
		stock.getArticles().add(sa3);
		stock.getArticles().add(sa4);
		stock.getArticles().add(sa5);
		
		return stock;
	}
	
	private static Invoice initInvoice(){
		Invoice i1 = factory.createInvoice();
		i1.setDate(Calendar.getInstance().getTime());
		i1.setId(0001);
		
		return i1;
	}
	
}
