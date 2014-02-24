package at.medevit.ecrit.pharmacy_at.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.util.EcoreUtil;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Invoice;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.Pharmacy;
import at.medevit.ecrit.pharmacy_at.model.Prescription;
import at.medevit.ecrit.pharmacy_at.model.Report;
import at.medevit.ecrit.pharmacy_at.model.Stock;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;
import at.medevit.ecrit.pharmacy_at.model.StockOrder;
import at.medevit.ecrit.pharmacy_at.model.StockOrderStatus;
import at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl;

public class SampleModel {
	static ModelFactory factory = ModelFactory.eINSTANCE;
	static EMFModelLoad loader = new EMFModelLoad();
// static Resource resource = null;
	static Pharmacy pharmacy = null;
	
	static StockOrder currOrder;
	private static Invoice curInvoice;
	
	public static void initSampleModel(){
		ModelPackageImpl.init();
		pharmacy = loader.load();
	}
	
	private static Pharmacy getPharmacy(){
		if (pharmacy == null) {
			initSampleModel();
		}
		return pharmacy;
	}
	
	public static Stock getStock(){
		return getPharmacy().getStock();
	}
	
	public static List<Invoice> getAllInvoices(){
		return pharmacy.getInvoices();
	}
	
	public static void saveInvoice(Invoice invoice){
		pharmacy.getInvoices().add(invoice);
		curInvoice = null;
		loader.save();
	}
	
	public static Invoice getCurrentInvoice(){
		if (curInvoice == null) {
			initNewInvoice();
		}
		return curInvoice;
	}
	
	private static void initNewInvoice(){
		Invoice i1 = factory.createInvoice();
		i1.setDate(Calendar.getInstance().getTime());
		Random rnd = new Random();
		i1.setId(rnd.nextInt(Integer.MAX_VALUE));
		
		curInvoice = i1;
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
		pharmacy.getInvoices().remove(i);
		loader.save();
	}
	
	public static void addArticleToInvoice(StockArticle stockArticle){
		getCurrentInvoice().getArticle().add(getValidArticleCopy(stockArticle.getArticle()));
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
		pharmacy.getStockOrders().add(order);
		
		loader.save();
	}
	
	public static List<StockOrder> getAllStockOrders(){
		return pharmacy.getStockOrders();
	}
	
	public static void stockOrderReceived(StockOrder order){
		int orderIdx = pharmacy.getStockOrders().indexOf(order);
		pharmacy.getStockOrders().get(orderIdx).setStatus(StockOrderStatus.RECEIVED);
		
		loader.save();
	}
	
	public static void addReport(Report report){
		pharmacy.getReports().add(report);
		
		loader.save();
	}
	
	public static Report getLatestReport(){
		if (pharmacy.getReports().size() == 0) {
			return null;
		}
		return pharmacy.getReports().get(pharmacy.getReports().size() - 1);
	}
	
	public static void revertReport(Report report){
		pharmacy.getReports().remove(report);
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
		loader.save();
		return true;
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
		prescription.getArticle().add(getValidArticleCopy(stockArticle.getArticle()));
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
		for (int i = 0; i < pharmacy.getInvoices().size(); i++) {
			prescriptions.addAll(pharmacy.getInvoices().get(i).getPrescription());
		}
		return prescriptions;
	}
	
	public static Article getValidArticleCopy(Article a){
		Article copy = EcoreUtil.copy(a);
		pharmacy.getLineItems().getArticle().add(copy);
		return copy;
	}
	
	public static List<Article> getAllLineItems(){
		return pharmacy.getLineItems().getArticle();
	}
	
	public static void updateArticleList(){
		loader.save();
		
	}
}
