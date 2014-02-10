package at.medevit.ecrit.pharmacy_at.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ArticleAvailability;
import at.medevit.ecrit.pharmacy_at.model.Invoice;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.Prescription;
import at.medevit.ecrit.pharmacy_at.model.Report;
import at.medevit.ecrit.pharmacy_at.model.Stock;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;
import at.medevit.ecrit.pharmacy_at.model.StockOrder;
import at.medevit.ecrit.pharmacy_at.model.StockOrderStatus;
import at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl;

public class SampleModel {
	static ModelFactory factory = ModelFactory.eINSTANCE;
	static Resource resource = null;
	static List<Report> reports = new ArrayList<Report>();
	static List<Invoice> invoices = new ArrayList<Invoice>();
	static List<StockOrder> orders = new ArrayList<StockOrder>();
	static StockOrder currOrder;
	
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
	
	public static void saveInvoice(){
		Invoice newInvoice = initInvoice();
		Resource s = getSampleModel();
		s.getContents().add(newInvoice);
	}
	
	public static Invoice getCurrentInvoice(){
		Resource s = getSampleModel();
		// get index of latest invoice
		Invoice current = invoices.get(invoices.size() - 1);
		int idx = s.getContents().indexOf(current);
		return (Invoice) s.getContents().get(idx);
	}
	
	public static List<Invoice> getAllInvoices(){
		return invoices.subList(0, invoices.size() - 1);
	}
	
	public static StockOrder getStockOrderInstance(){
		currOrder = factory.createStockOrder();
		Random rnd = new Random();
		currOrder.setNumber(rnd.nextInt(Integer.MAX_VALUE));
		
		return currOrder;
	}
	
	public static StockOrder getCurrentStockOrder(){
		return currOrder;
	}
	
	public static void addStockOrder(StockOrder order){
		Resource s = getSampleModel();
		s.getContents().add(order);
		orders.add(order);
	}
	
	public static List<StockOrder> getAllStockOrders(){
		return orders;
	}
	
	public static void addReport(Report report){
		Resource s = getSampleModel();
		s.getContents().add(report);
		reports.add(report);
	}
	
	public static Report getLatestReport(){
		Report latestReport = reports.get(reports.size() - 1);
		Resource s = getSampleModel();
		return (Report) s.getContents().get(s.getContents().indexOf(latestReport));
	}
	
	public static void revertReport(Report r){
		reports.remove(r);
		resource.getContents().remove(r);
	}
	
	public static void revertCurrentInvoice(){
		Invoice i = getCurrentInvoice();
		
		for (Article article : i.getArticle()) {
			for (StockArticle stockArticle : getStock().getArticles()) {
				// find stock article on list and reset number on stock
				if (stockArticle.getArticle().getName().equals(article.getName())) {
					stockArticle.setNumberOnStock(stockArticle.getNumberOnStock() + 1);
				}
			}
		}
		invoices.remove(i);
		resource.getContents().remove(i);
		resource.getContents().add(initInvoice());
	}
	
	public static void addArticleToInvoice(StockArticle stockArticle){
		Article arti = EcoreUtil.copy(stockArticle.getArticle());
		getCurrentInvoice().getArticle().add(arti);
	}
	
	private static void initSampleModel(){
		ResourceSet resSet = new ResourceSetImpl();
		// Create a resource
		resource = resSet.createResource(URI.createURI("pharmacy_at/my.model"));
		
		Stock stock = initStock();
		Invoice invoice = initInvoice();
		StockOrder stockOrder = initStockOrder(stock);
		
		resource.getContents().add(stock);
		resource.getContents().add(invoice);
		resource.getContents().add(stockOrder);
		
		// try {
		// resource.save(Collections.EMPTY_MAP);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}
	
	private static StockOrder initStockOrder(Stock stock){
		StockOrder stockOrder = getStockOrderInstance();
		stockOrder
			.setIssuer("Novartis Austria GmbH \nCorporate & Pharma Communications \nStella-Klein-Löw-Weg 17 \n1020 Wien");
		stockOrder.setStatus(StockOrderStatus.ORDERED);
		stockOrder.setBoundFor(stock);
		stockOrder.getArticle().add(stock.getArticles().get(0).getArticle());
		stockOrder.getArticle().add(stock.getArticles().get(1).getArticle());
		orders.add(stockOrder);
		return stockOrder;
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
		sa1.setLowerBound(10);
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
		sa2.setLowerBound(10);
		sa2.setNumberOnStock(20);
		
		Article a3 = factory.createArticle();
		a3.setAdmissionNumber(034343);
		a3.setAvailability(ArticleAvailability.AVAILABLE);
		a3.setDescription("Adviced dose per day: 2 pieces a day (i.e. one in the morning, one in the evening)");
		a3.setName("MagicPainkiller");
		a3.setPrice(8.0f);
		StockArticle sa3 = factory.createStockArticle();
		sa3.setArticle(a3);
		sa3.setLowerBound(10);
		sa3.setNumberOnStock(20);
		
		Article a4 = factory.createArticle();
		a4.setAdmissionNumber(001122);
		a4.setAvailability(ArticleAvailability.BLACKLISTED);
		a4.setDescription("Be careful, as it can cause insomnia");
		a4.setName("Coffedrops");
		a4.setPrice(3.0f);
		StockArticle sa4 = factory.createStockArticle();
		sa4.setArticle(a4);
		sa4.setLowerBound(8);
		sa4.setNumberOnStock(8);
		
		Article a5 = factory.createArticle();
		a5.setAdmissionNumber(010203);
		a5.setAvailability(ArticleAvailability.AVAILABLE);
		a5.setDescription("Usually to use once a week. Can be used more often if adviced by issuing practitioner");
		a5.setName("Elmex Zahngel");
		a5.setPrice(4.0f);
		StockArticle sa5 = factory.createStockArticle();
		sa5.setArticle(a5);
		sa5.setLowerBound(30);
		sa5.setNumberOnStock(77);
		
		stock.getArticles().add(sa1);
		stock.getArticles().add(sa2);
		stock.getArticles().add(sa3);
		stock.getArticles().add(sa4);
		stock.getArticles().add(sa5);
		
		return stock;
	}
	
	public static boolean addToStock(StockArticle newStockArticle){
		for (StockArticle sa : getStock().getArticles()) {
			if (sa.getArticle().getName().equals(newStockArticle.getArticle().getName())) {
				if (sa.getArticle().getAdmissionNumber() == newStockArticle.getArticle()
					.getAdmissionNumber()) {
					return false;
				}
			}
		}
		getStock().getArticles().add(newStockArticle);
		return true;
	}
	
	private static Invoice initInvoice(){
		Invoice i1 = factory.createInvoice();
		i1.setDate(Calendar.getInstance().getTime());
		Random rnd = new Random();
		i1.setId(rnd.nextInt(Integer.MAX_VALUE));
		
		invoices.add(i1);
		return i1;
	}
	
	public static void addPrescription(Prescription p){
		getCurrentInvoice().getPrescription().add(p);
	}
	
	/**
	 * Adds prescription and assures synch with invoice data
	 * 
	 * @param p
	 *            Prescription to add
	 */
	public static void addPrescriptionAndSync(Prescription p){
		getCurrentInvoice().getPrescription().add(p);
		synchPrescriptedArticlesWithInvoice(p);
	}
	
	/**
	 * in case article was added to prescription directly -> add to invoice articles as well
	 * 
	 * @param p
	 *            Prescription that was added
	 */
	private static void synchPrescriptedArticlesWithInvoice(Prescription p){
		List<Article> onInvoice = getCurrentInvoice().getArticle();
		List<Article> onPrescription = p.getArticle();
		
		for (Article a : onPrescription) {
			if (!onInvoice.contains(a)) {
				getCurrentInvoice().getArticle().add(a);
			}
		}
	}
	
	public static List<Prescription> getAllPrescriptionsForCurrentInvoice(){
		return getCurrentInvoice().getPrescription();
	}
	
	public static void addArticleToPrescription(Prescription prescription, StockArticle stockArticle){
		Article arti = EcoreUtil.copy(stockArticle.getArticle());
		prescription.getArticle().add(arti);
	}
	
	public static void deletePrescription(Prescription prescription){
		getCurrentInvoice().getPrescription().remove(prescription);
	}
	
	public static void removeArticleFromPrescription(Prescription prescription, Article a){
		prescription.getArticle().remove(a);
		
	}
	
	public static void removeArticleFromInvoice(Article a){
		for (Article arti : getCurrentInvoice().getArticle()) {
			if (arti.getName().equals(a.getName())) {
				getCurrentInvoice().getArticle().remove(arti);
				resetNumberOnStock(a);
				break;
			}
		}
	}
	
	private static void resetNumberOnStock(Article a){
		for (StockArticle sa : getStock().getArticles()) {
			if (sa.getArticle().getName().equals(a.getName())) {
				sa.setNumberOnStock(sa.getNumberOnStock() + 1);
			}
		}
	}
	
	public static boolean isSingleInvoiceArticle(Article a){
		int counter = 0;
		for (Article arti : getCurrentInvoice().getArticle()) {
			if (arti.getName().equals(a.getName())) {
				counter++;
			}
		}
		if (counter == 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * compares all invoice articles with all prescripted articles
	 * 
	 * @return only unprescripted articles (empty list if all are prescripted)
	 */
	public static List<Article> getNotYetPrescriptedArticle(){
		List<Article> notPrescripted = new ArrayList<Article>();
		List<Article> prescripted = new ArrayList<Article>();
		
		// get all articles that have a prescription
		for (Prescription p : SampleModel.getAllPrescriptionsForCurrentInvoice()) {
			prescripted.addAll(p.getArticle());
		}
		
		// add only articles that have no prescription yet
		for (Article article : getCurrentInvoice().getArticle()) {
			if (!prescripted.contains(article)) {
				notPrescripted.add(article);
			}
		}
		return notPrescripted;
	}
	
	public static void deleteFromStock(StockArticle selection){
		getStock().getArticles().remove(selection);
	}
	
	public static List<Prescription> getAllPrescriptions(){
		List<Prescription> prescriptions = new ArrayList<>();
		for (int i = 0; i < invoices.size(); i++) {
			prescriptions.addAll(invoices.get(i).getPrescription());
		}
		return prescriptions;
	}
	
}
