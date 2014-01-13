package at.medevit.ecrit.pharmacy_at.application.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
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

import at.medevit.ecrit.pharmacy_at.application.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;
import at.medevit.ecrit.pharmacy_at.util.ArticleFilter;

public class ArticleListPart {
	private TableViewer tableViewer;
	private ArticleFilter filter;

	@Inject
	private ESelectionService selectionService;

	@Inject
	public ArticleListPart() {
	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		// search 
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

		initTableViewer(composite);
	}

	private void initTableViewer(Composite composite) {
		tableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		ObservableListContentProvider cp = new ObservableListContentProvider();
		initColumns(cp);		
		tableViewer.setContentProvider(cp);

		// add search filter
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
							event.data = a.getArticle().toString();
						}
					}

					@Override
					public void dragFinished(DragSourceEvent event) {
						if (event.detail == DND.DROP_COPY) {
							IStructuredSelection selection = (IStructuredSelection) tableViewer
									.getSelection();
							StockArticle a = (StockArticle) selection
									.getFirstElement();
							// update aticles number on stock attribute
							a.setNumberOnStock(a.getNumberOnStock() - 1);
						}
					}
				});

		// add the selection change listener
		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						IStructuredSelection selection = (IStructuredSelection) event
								.getSelection();
						StockArticle stockArticle = (StockArticle) selection
								.getFirstElement();
						selectionService.setSelection(stockArticle.getArticle());
					}
				});

		// set model
		IObservableList input = Properties.selfList(StockArticle.class)
				.observe(SampleModel.getStock().getArticles());
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
			tvc.getColumn().setText(columnNames[i]);
			tvc.getColumn().setWidth(columnWidths[i]);
			tvc.getColumn().setResizable(true);
			
			// determine the attribute that should be observed
			FeaturePath path = FeaturePath.fromList(
					ModelPackage.Literals.STOCK_ARTICLE__ARTICLE,
					columnAttributes[i]);

			// bind the feature and setup a table column
			IObservableMap map = EMFProperties.value(path).observeDetail(
					cp.getKnownElements());
			tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
		}

		TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
		tvc.getColumn().setText("OnStock");
		tvc.getColumn().setWidth(80);
		IObservableMap stockMap = EMFProperties.value(
				ModelPackage.Literals.STOCK_ARTICLE__NUMBER_ON_STOCK)
				.observeDetail(cp.getKnownElements());
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(stockMap));
	}
}
