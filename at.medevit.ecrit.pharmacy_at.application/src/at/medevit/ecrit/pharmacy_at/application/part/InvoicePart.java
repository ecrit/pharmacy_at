package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.application.SampleModel;
import at.medevit.ecrit.pharmacy_at.application.converter.DateToStringConverter;
import at.medevit.ecrit.pharmacy_at.application.converter.FloatToStringConverter;
import at.medevit.ecrit.pharmacy_at.application.converter.IntToStringConverter;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Invoice;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class InvoicePart {
	private DataBindingContext m_bindingContext;
	
	private Invoice invoice;
	private HashMap<String, String> articleAmountMap;
	private List<Article> noDuplicateList;

	private Text txtDate;
	private Text txtID;
	private Text txtTotalCosts;
	private TableViewer tableViewer;
	private TableViewer presTableViewer;
	
	@Inject
	EPartService partService; 

	@Inject
	public InvoicePart() {
		invoice = SampleModel.getInvoice();
		invoice.setPaidAmount(10.0f);
		articleAmountMap = new HashMap<String, String>();
		noDuplicateList = new ArrayList<Article>();
	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		composite.setLayout(new GridLayout(2, false));

		Label lblInvoicepart = new Label(composite, SWT.NONE);
		lblInvoicepart.setText("Invoice");
		new Label(composite, SWT.NONE);

		// set invoice date
		Label lblDate = new Label(composite, SWT.NONE);
		GridData gd_lblDate = new GridData(SWT.RIGHT, SWT.CENTER, true, false,
				1, 1);
		lblDate.setLayoutData(gd_lblDate);
		lblDate.setText("Date: ");

		txtDate = new Text(composite, SWT.NONE);
		txtDate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false,
				1, 1));
		txtDate.setEnabled(false);

		// set invoice number
		Label lblID = new Label(composite, SWT.NONE);
		GridData gd_ID = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		lblID.setLayoutData(gd_ID);
		lblID.setText("InvoiceNumber: ");

		txtID = new Text(composite, SWT.NONE);
		txtID.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1,
				1));
		txtID.setEnabled(false);

		// set invoice line items
		initCostsTableViewer(composite);

		// set prescription voucher lines
		initPrescriptionTableViewer(composite);
		
		// set total costs
		Label lblTotalCosts = new Label(composite, SWT.NONE);
		GridData gd_lblTotalCosts = new GridData(SWT.RIGHT, SWT.CENTER, true,
				false, 1, 1);
		lblTotalCosts.setLayoutData(gd_lblTotalCosts);
		lblTotalCosts.setText("Total Costs (€): ");

		txtTotalCosts = new Text(composite, SWT.NONE);
		txtTotalCosts.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true,
				false, 1, 1));
		txtTotalCosts.setEnabled(false);

		m_bindingContext = initDataBinding();
	}

	private void initCostsTableViewer(Composite composite) {
		tableViewer = new TableViewer(composite, SWT.NONE);
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, true, false, 2, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(false);
		table.setEnabled(false);

		ObservableListContentProvider cp = new ObservableListContentProvider();
		tableViewer.setContentProvider(cp);
		initCostsColumns(cp);

		IObservableList input = Properties.selfList(Article.class).observe(noDuplicateList);
		tableViewer.setInput(input);
	}
	
	private void initPrescriptionTableViewer(Composite composite) {
		presTableViewer = new TableViewer(composite, SWT.NONE);
		Table table = presTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, true, false, 2, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(false);
		table.setEnabled(false);

		ObservableListContentProvider cp = new ObservableListContentProvider();
		presTableViewer.setContentProvider(cp);
		initPrescriptionColumns(cp);

		IObservableList input = Properties.selfList(Article.class).observe(invoice.getPrescription());
		presTableViewer.setInput(input);
	}

	private void initCostsColumns(ObservableListContentProvider cp) {
		String[] columnNames = new String[] { "Amount", "Article Name",
				"Price(Unit)", "Price" };
		int[] columnWidths = new int[] { 70, 200, 80, 80 };

		TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
		tvc.getColumn().setText(columnNames[0]);
		tvc.getColumn().setWidth(columnWidths[0]);
		tvc.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Article a = (Article) element;
				return articleAmountMap.get(a.getName());
			}
		});

		tvc = new TableViewerColumn(tableViewer, SWT.NONE);
		tvc.getColumn().setText(columnNames[1]);
		tvc.getColumn().setWidth(columnWidths[1]);
		IObservableMap nameMap = EMFProperties.value(
				ModelPackage.Literals.ARTICLE__NAME).observeDetail(
				cp.getKnownElements());
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(nameMap));

		tvc = new TableViewerColumn(tableViewer, SWT.NONE);
		tvc.getColumn().setText(columnNames[2]);
		tvc.getColumn().setWidth(columnWidths[2]);
		IObservableMap priceMap = EMFProperties.value(
				ModelPackage.Literals.ARTICLE__PRICE).observeDetail(
				cp.getKnownElements());
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(priceMap));

		tvc = new TableViewerColumn(tableViewer, SWT.NONE);
		tvc.getColumn().setText(columnNames[3]);
		tvc.getColumn().setWidth(columnWidths[3]);
		tvc.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Article a = (Article) element;
				int factor = Integer.parseInt(articleAmountMap.get(a.getName()));
				return Float.toString(a.getPrice() * factor);
			}
		});
	}
	
	private void initPrescriptionColumns(ObservableListContentProvider cp) {
		String[] columnNames = new String[] { "Number", "Articles", "Refund" };
		int[] columnWidths = new int[] { 60, 300, 80 };

		TableViewerColumn tvc = new TableViewerColumn(presTableViewer, SWT.NONE);
		tvc.getColumn().setText(columnNames[0]);
		tvc.getColumn().setWidth(columnWidths[0]);
		IObservableMap nrObserveMap = EMFProperties.value(
				ModelPackage.Literals.PRESCRIPTION__NUMBER).observeDetail(
				cp.getKnownElements());
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(nrObserveMap));

//		tvc = new TableViewerColumn(presTableViewer, SWT.NONE);
//		tvc.getColumn().setText(columnNames[1]);
//		tvc.getColumn().setWidth(columnWidths[1]);
//		IObservableMap practitionerObserveMap = EMFProperties.value(
//				ModelPackage.Literals.PRESCRIPTION__ISSUING_PRACTITIONER).observeDetail(
//				cp.getKnownElements());
//		tvc.setLabelProvider(new ObservableMapCellLabelProvider(practitionerObserveMap));

		tvc = new TableViewerColumn(presTableViewer, SWT.NONE);
		tvc.getColumn().setText(columnNames[1]);
		tvc.getColumn().setWidth(columnWidths[1]);
		tvc.getColumn().setResizable(true);
		tvc.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				Prescription p = (Prescription) element;
				StringBuilder sb = new StringBuilder();
				for (Article a : p.getArticle()) {
					sb.append(a.getName() + "; ");
				}
				return sb.toString();
			}
		});
		
		tvc = new TableViewerColumn(presTableViewer, SWT.NONE);
		tvc.getColumn().setText(columnNames[2]);
		tvc.getColumn().setWidth(columnWidths[2]);
		tvc.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Prescription p = (Prescription) element;
				float total = calculateTotalPrescriptionRefund(p);
				return Float.toString(total);
			}
		});
	}

	@Inject
	void setSelection(
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Object o) {
		updateTable();
	}
	
	public void updateTable(){
		if(presTableViewer != null && tableViewer != null){
			presTableViewer.refresh();	
			extractInvoiceRelevantValues(invoice.getArticle());
			calculateTotalCosts();
			tableViewer.refresh();
		}
	}

	/**
	 * check articles and if they occur multiple times
	 * if yes update amount of this article
	 * @param articles
	 */
	private void extractInvoiceRelevantValues(EList<Article> articles) {
		 articleAmountMap.clear();
		 noDuplicateList.clear();

		for (Article a : articles) {
			if (articleAmountMap.containsKey(a.getName())) {
				int amount = Integer
						.parseInt(articleAmountMap.get(a.getName())) + 1;
				articleAmountMap.put(a.getName(), Integer.toString(amount));
			} else {
				articleAmountMap.put(a.getName(), "1");
				noDuplicateList.add(a);
			}
		}
	}

	/**
	 * calculate the total costs of all articles, minus prescriptions
	 */
	private void calculateTotalCosts() {
		float totalAmount = 0.0f;
		for (Article a : invoice.getArticle()) {
			totalAmount += a.getPrice();
		}
		
		float refundAmount = 0.0f;
		for(Prescription p : invoice.getPrescription()){
			for (Article a : p.getArticle()) {
				refundAmount += a.getPrice();
			}
		}
		totalAmount = totalAmount - refundAmount;
		invoice.setPaidAmount(totalAmount);
	}

	/**
	 * calculate total refund caused by a prescription
	 * @param p prescription
	 * @return total costs of all articles from the prescription
	 */
	private float calculateTotalPrescriptionRefund(Prescription p) {
		List<Article> presArticles = p.getArticle();
		float sum = 0.0f;
		
		for (Article article : presArticles) {
			sum += article.getPrice();
		}
		return sum;		
	}
	
	protected DataBindingContext initDataBinding() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue dateObserveValue = EMFProperties.value(
				ModelPackage.Literals.INVOICE__DATE).observe(invoice);
		IObservableValue textDateObserveValue = WidgetProperties.text(
				SWT.Modify).observe(txtDate);
		bindingContext.bindValue(textDateObserveValue, dateObserveValue, null,
				new UpdateValueStrategy()
						.setConverter(new DateToStringConverter()));
		//
		IObservableValue idObserveValue = EMFProperties.value(
				ModelPackage.Literals.INVOICE__ID).observe(invoice);
		IObservableValue textIdObserveValue = WidgetProperties.text(SWT.Modify)
				.observe(txtID);
		bindingContext.bindValue(textIdObserveValue, idObserveValue, null,
				new UpdateValueStrategy()
						.setConverter(new IntToStringConverter()));
		//
		IObservableValue totalCostsObserveValue = EMFProperties.value(
				ModelPackage.Literals.INVOICE__PAID_AMOUNT).observe(invoice);
		IObservableValue textTotalCostsObsereveVale = WidgetProperties.text(
				SWT.Modify).observe(txtTotalCosts);
		bindingContext.bindValue(textTotalCostsObsereveVale,
				totalCostsObserveValue, null, new UpdateValueStrategy()
						.setConverter(new FloatToStringConverter()));
		//
		// ObservableListContentProvider cp = new
		// ObservableListContentProvider();
		// tableViewer.setContentProvider(cp);
		// IObservableMap map = EMFProperties.value(
		// ModelPackage.Literals.ARTICLE__NAME).observeDetail(
		// cp.getKnownElements());
		// tableViewer.setLabelProvider(new
		// ObservableMapCellLabelProvider(map));
		//

		return bindingContext;
	}
	
	@PreDestroy
	public void dispose() {
	}
}