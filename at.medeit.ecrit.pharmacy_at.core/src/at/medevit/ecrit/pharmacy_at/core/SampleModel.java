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
import at.medevit.ecrit.pharmacy_at.model.impl.ModelPackageImpl;

//this is the sample model
public class SampleModel {
	static ModelFactory factory = ModelFactory.eINSTANCE;
	static EMFModelLoad loader = new EMFModelLoad();
	static Pharmacy pharmacy = null;
	
	static StockOrder currOrder;
	private static Invoice curInvoice;
	
	public static Pharmacy getPharmacy(){
		if (pharmacy == null) {
			ModelPackageImpl.init();
			pharmacy = loader.load();
		}
		return pharmacy;
	}
	
	public static Stock getStock(){
		return getPharmacy().getStock();
	}
	
	public static Invoice getInvoice(){
		if (curInvoice == null) {
			initNewInvoice();
		}
		return curInvoice;
	}
	
	public static StockOrder getStockOrder(){
		if (currOrder == null) {
			initNewStockOrderInstance();
		}
		return currOrder;
	}
	
	public static Article getValidArticleCopy(Article a){
		Article copy = EcoreUtil.copy(a);
		pharmacy.getLineItems().getArticle().add(copy);
		return copy;
	}
	
	public static List<Article> getNotYetPrescriptedArticle(){
		List<Article> notPrescripted = new ArrayList<Article>();
		List<Article> prescripted = new ArrayList<Article>();
		
		// get all articles that have a prescription
		for (Prescription p : getInvoice().getPrescription()) {
			prescripted.addAll(p.getArticle());
		}
		
		// add only articles that have no prescription yet
		for (Article article : getInvoice().getArticle()) {
			if (!prescripted.contains(article)) {
				notPrescripted.add(article);
			}
		}
		return notPrescripted;
	}
	
	public static List<Prescription> getAllPrescriptions(){
		List<Prescription> prescriptions = new ArrayList<>();
		for (int i = 0; i < pharmacy.getInvoices().size(); i++) {
			prescriptions.addAll(pharmacy.getInvoices().get(i).getPrescription());
		}
		return prescriptions;
	}
	
	public static void addInvoice(Invoice invoice){
		pharmacy.getInvoices().add(invoice);
		curInvoice = null;
		loader.save();
	}
	
	public static void addReport(Report report){
		pharmacy.getReports().add(report);
		loader.save();
	}
	
	public static void addStockOrder(StockOrder order){
		pharmacy.getStockOrders().add(order);
		currOrder = null;
		loader.save();
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
	
	private static void initNewInvoice(){
		Invoice i1 = factory.createInvoice();
		i1.setDate(Calendar.getInstance().getTime());
		Random rnd = new Random();
		i1.setId(rnd.nextInt(Integer.MAX_VALUE));
		
		curInvoice = i1;
	}
	
	private static void initNewStockOrderInstance(){
		currOrder = factory.createStockOrder();
		Random rnd = new Random();
		currOrder.setNumber(rnd.nextInt(Integer.MAX_VALUE));
	}
	
	public static void revertCurrentInvoice(){
		Invoice i = getInvoice();
		
		for (Article article : i.getArticle()) {
			resetNumberOnStock(article);
			removeLineItem(article);
		}
		pharmacy.getInvoices().remove(i);
		curInvoice = null;
		loader.save();
	}
	
	private static void resetNumberOnStock(Article a){
		for (StockArticle sa : getStock().getArticles()) {
			if (sa.getArticle().getName().equals(a.getName())) {
				sa.setNumberOnStock(sa.getNumberOnStock() + 1);
			}
		}
	}
	
	public static void removeArticleFromInvoice(Article a){
		for (Article arti : getInvoice().getArticle()) {
			if (arti.getName().equals(a.getName())) {
				getInvoice().getArticle().remove(arti);
				resetNumberOnStock(a);
				removeLineItem(a);
				break;
			}
		}
	}
	
	public static void removeFromStock(StockArticle selection){
		getStock().getArticles().remove(selection);
	}
	
	private static void removeLineItem(Article a){
		pharmacy.getLineItems().getArticle().remove(a);
	}
	
	public static void removeReport(Report report){
		pharmacy.getReports().remove(report);
	}
	
	public static boolean isSingleInvoiceArticle(Article a){
		int counter = 0;
		for (Article arti : getInvoice().getArticle()) {
			if (arti.getName().equals(a.getName())) {
				counter++;
			}
		}
		if (counter == 1) {
			return true;
		}
		return false;
	}
	
	public static void update(){
		loader.save();
	}
}
