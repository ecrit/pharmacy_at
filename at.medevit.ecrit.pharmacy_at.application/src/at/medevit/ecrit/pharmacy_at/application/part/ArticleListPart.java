package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ArticleAvailability;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;
import at.medevit.ecrit.pharmacy_at.util.ArticleFilter;

public class ArticleListPart {
	private TableViewer tableViewer;
	private ArticleFilter filter;
	
	@Inject
	private EPartService partService;

	private static final String ID_PROPERTIES_PART = "at.medevit.ecrit.pharmacy_at.application.part.properties";
	
	@Inject
	public ArticleListPart() {
	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		final Text txtSearch = new Text(composite, SWT.BORDER | SWT.SEARCH);
		txtSearch.setMessage("Search");
		txtSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		txtSearch.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				filter.setSearchText(txtSearch.getText());
				tableViewer.refresh();
			}
		});

		tableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		ObservableListContentProvider cp = new ObservableListContentProvider();
		initColumns(cp);
		IObservableList input = Properties.selfList(StockArticle.class)
				.observe(createStockArticles());
		tableViewer.setContentProvider(cp);

		// add search filter to tableviewer
		filter = new ArticleFilter();
		tableViewer.addFilter(filter);

		// add drag support
		Transfer[] transferTypes = new Transfer[] { TextTransfer.getInstance() };
		tableViewer.addDragSupport(DND.DROP_COPY, transferTypes,
				new DragSourceAdapter() {
					@Override
					public void dragSetData(DragSourceEvent event) {
						IStructuredSelection selection = (IStructuredSelection) tableViewer
								.getSelection();
						StockArticle a = (StockArticle) selection
								.getFirstElement();

						if (TextTransfer.getInstance().isSupportedType(
								event.dataType)) {
							event.data = a.getArticle().getName();
						}
					}

					@Override
					public void dragFinished(DragSourceEvent event) {
						if (event.detail == DND.DROP_COPY) {
							IStructuredSelection selection = (IStructuredSelection) tableViewer
									.getSelection();
							StockArticle a = (StockArticle) selection
									.getFirstElement();
							a.setNumberOnStock(a.getNumberOnStock() - 1);
						}
					}
				});

		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						IStructuredSelection selection = (IStructuredSelection)event.getSelection();
						StockArticle stockArticle = (StockArticle) selection.getFirstElement();
						
						//TODO replace with databinding
						MPart mPart = partService.findPart(ID_PROPERTIES_PART);
						PropertiesPart propertyPart = (PropertiesPart) mPart.getObject();
						propertyPart.setArticle(stockArticle.getArticle());
					}
				});

		// set model
		tableViewer.setInput(input);
	}

	private void initColumns(ObservableListContentProvider cp) {
		String[] columnNames = new String[] { "AdmNr", "Name", "Availalbility" };
		EAttribute[] columnAttributes = new EAttribute[] {
				ModelPackage.Literals.ARTICLE__ADMISSION_NUMBER,
				ModelPackage.Literals.ARTICLE__NAME,
				ModelPackage.Literals.ARTICLE__AVAILABILITY };
		int[] columnWidths = new int[] { 80, 100, 100 };

		for (int i = 0; i < columnNames.length; i++) {
			TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);

			// determine the attribute that should be observed
			FeaturePath path = FeaturePath.fromList(
					ModelPackage.Literals.STOCK_ARTICLE__ARTICLE,
					columnAttributes[i]);

			// bind the feature and setup a table column
			IObservableMap map = EMFProperties.value(path).observeDetail(
					cp.getKnownElements());
			// IObservableMap map = EMFProperties.value(columnAttributes[i])
			// .observeDetail(cp.getKnownElements());
			tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));

			// set the column title & size
			tvc.getColumn().setText(columnNames[i]);
			tvc.getColumn().setWidth(columnWidths[i]);
			tvc.getColumn().setResizable(true);
		}

		// FeaturePath path = FeaturePath.fromList(
		// ModelPackage.Literals.STOCK_ARTICLE__ARTICLE,
		// ModelPackage.Literals.STOCK_ARTICLE__NUMBER_ON_STOCK);

		// bind the feature and setup a table column
		IObservableMap stockMap = EMFProperties.value(
				ModelPackage.Literals.STOCK_ARTICLE__NUMBER_ON_STOCK)
				.observeDetail(cp.getKnownElements());
		TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(stockMap));
		tvc.getColumn().setText("OnStock");
		tvc.getColumn().setWidth(80);

	}

	/**
	 * TODO: only test values - remove/replace this at some point only for
	 * testing
	 * 
	 * @return a list of sample articles
	 */
	private List<Article> createArticles() {
		List<Article> articleList = new ArrayList<Article>();
		int[] admNr = new int[] { 301213, 311213, 010114 };
		String[] name = new String[] { "Aspirin", "MexaVit", "Lemocin" };
		String[] description = new String[] { "only 4 testing", "not real",
				"fake medicin" };
		ArticleAvailability[] availability = new ArticleAvailability[] {
				ArticleAvailability.AVAILABLE, ArticleAvailability.AVAILABLE,
				ArticleAvailability.BLACKLISTED };
		int[] onStock = new int[] { 20, 10, 0 };

		ModelFactory factory = ModelFactory.eINSTANCE;
		for (int i = 0; i < admNr.length; i++) {
			Article article = factory.createArticle();
			article.setAdmissionNumber(admNr[i]);
			article.setName(name[i]);
			article.setDescription(description[i]);
			article.setAvailability(availability[i]);

			StockArticle stockArticle = factory.createStockArticle();
			stockArticle.setArticle(article);
			stockArticle.setLowerBound(1);
			stockArticle.setNumberOnStock(onStock[i]);

			articleList.add(article);
		}
		return articleList;
	}

	/**
	 * TODO: only test values - remove/replace this at some point only for
	 * testing
	 * 
	 * @return a list of sample stockarticles
	 */
	private List<StockArticle> createStockArticles() {
		List<StockArticle> articleList = new ArrayList<StockArticle>();
		int[] admNr = new int[] { 301213, 311213, 010114 };
		String[] name = new String[] { "Aspirin", "MexaVit", "Lemocin" };
		String[] description = new String[] { "only 4 testing", "not real",
				"fake medicin" };
		ArticleAvailability[] availability = new ArticleAvailability[] {
				ArticleAvailability.AVAILABLE, ArticleAvailability.AVAILABLE,
				ArticleAvailability.BLACKLISTED };
		int[] onStock = new int[] { 20, 10, 0 };

		ModelFactory factory = ModelFactory.eINSTANCE;
		for (int i = 0; i < admNr.length; i++) {
			Article article = factory.createArticle();
			article.setAdmissionNumber(admNr[i]);
			article.setName(name[i]);
			article.setDescription(description[i]);
			article.setAvailability(availability[i]);

			StockArticle stockArticle = factory.createStockArticle();
			stockArticle.setArticle(article);
			stockArticle.setLowerBound(1);
			stockArticle.setNumberOnStock(onStock[i]);

			articleList.add(stockArticle);
		}
		return articleList;
	}

}
