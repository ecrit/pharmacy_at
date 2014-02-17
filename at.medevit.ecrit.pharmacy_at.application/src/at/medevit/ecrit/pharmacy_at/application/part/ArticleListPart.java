package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.e4.ui.workbench.swt.modeling.EMenuService;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.filter.ArticleFilter;
import at.medevit.ecrit.pharmacy_at.application.filter.CriticalLevelFilter;
import at.medevit.ecrit.pharmacy_at.application.handler.CommandUtil;
import at.medevit.ecrit.pharmacy_at.application.part.handler.AddToInvoiceViewerHandler;
import at.medevit.ecrit.pharmacy_at.application.util.Images;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class ArticleListPart {
	private TableViewer tableViewer;
	private List<StockArticle> stockArticles;
	private ArticleFilter filter;
	private CriticalLevelFilter criticalLevelFilter;
	
	@Inject
	private IEclipseContext context;
	@Inject
	private EMenuService menuService;
	@Inject
	private ESelectionService selectionService;
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;
	
	@Inject
	public ArticleListPart(){
		stockArticles = SampleModel.getStock().getArticles();
	}
	
	@PostConstruct
	public void postConstruct(Composite parent){
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		parent.setLayout(new GridLayout(1, false));
		
		// set critical stock level reached filter
		criticalLevelFilter = new CriticalLevelFilter();
		
		// search
		Composite filterComposite = new Composite(parent, SWT.NONE);
		filterComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		filterComposite.setLayout(new GridLayout(2, false));
		
		final Text txtSearch = new Text(filterComposite, SWT.BORDER | SWT.SEARCH);
		txtSearch.setMessage("Search");
		txtSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		txtSearch.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke){
				filter.setSearchText(txtSearch.getText());
				tableViewer.refresh();
			}
		});
		
		Button btnFilterCritical = new Button(filterComposite, SWT.TOGGLE);
		btnFilterCritical.setText("Only Critical");
		btnFilterCritical.setImage(Images.FILTER);
		btnFilterCritical.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				if (((Button) e.widget).getSelection()) {
					tableViewer.addFilter(criticalLevelFilter);
				} else {
					tableViewer.removeFilter(criticalLevelFilter);
				}
				tableViewer.refresh();
			}
		});
		
		initTableViewer(parent);
		menuService.registerContextMenu(tableViewer.getTable(),
			Messages.getString("ID_POPUP_ARTICLELIST"));
		
	}
	
	private void initTableViewer(Composite composite){
		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		ObservableListContentProvider cp = new ObservableListContentProvider();
		initColumns(cp);
		tableViewer.setContentProvider(cp);
		
		// add search filter
		filter = new ArticleFilter();
		tableViewer.addFilter(filter);
		
		// add drag support
		Transfer[] transferTypes = new Transfer[] {
			TextTransfer.getInstance()
		};
		tableViewer.addDragSupport(DND.DROP_COPY, transferTypes, new DragSourceAdapter() {
			@Override
			public void dragSetData(DragSourceEvent event){
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				StockArticle a = (StockArticle) selection.getFirstElement();
				selectionService.setSelection(a);
				
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = a.toString();
				}
			}
		});
		
		// add the selection change listener
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				StockArticle stockArticle = (StockArticle) selection.getFirstElement();
				selectionService.setSelection(stockArticle);
			}
		});
		
		// add double click listener
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event){
				CommandUtil.setContextAndServices(context, commandService, handlerService);
				CommandUtil.manuallyCallCommand(Messages.getString("ID_CMD_ADD_TO_INVOICE"),
					"commandparameter.modelelement.Article", "a stock article",
					new AddToInvoiceViewerHandler());
			}
		});
		
		// set model
		IObservableList input = Properties.selfList(StockArticle.class).observe(stockArticles);
		tableViewer.setInput(input);
		
	}
	
	private void initColumns(ObservableListContentProvider cp){
		String[] columnNames = new String[] {
			"AdmNr", "Name", "Availalbility"
		};
		EAttribute[] columnAttributes =
			new EAttribute[] {
				ModelPackage.Literals.ARTICLE__ADMISSION_NUMBER,
				ModelPackage.Literals.ARTICLE__NAME, ModelPackage.Literals.ARTICLE__AVAILABILITY
			};
		int[] columnWidths = new int[] {
			80, 100, 100
		};
		
		for (int i = 0; i < columnNames.length; i++) {
			TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
			tvc.getColumn().setText(columnNames[i]);
			tvc.getColumn().setWidth(columnWidths[i]);
			tvc.getColumn().setResizable(true);
			
			// determine the attribute that should be observed
			FeaturePath path =
				FeaturePath.fromList(ModelPackage.Literals.STOCK_ARTICLE__ARTICLE,
					columnAttributes[i]);
			
			// bind the feature and setup a table column
			IObservableMap map = EMFProperties.value(path).observeDetail(cp.getKnownElements());
			tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
		}
		
		TableViewerColumn tvcOnStock = new TableViewerColumn(tableViewer, SWT.NONE);
		tvcOnStock.getColumn().setText("OnStock");
		tvcOnStock.getColumn().setWidth(80);
		IObservableMap stockMap =
			EMFProperties.value(ModelPackage.Literals.STOCK_ARTICLE__NUMBER_ON_STOCK)
				.observeDetail(cp.getKnownElements());
		tvcOnStock.setLabelProvider(new ObservableMapCellLabelProvider(stockMap));
		
		ColumnViewerToolTipSupport.enableFor(tableViewer, ToolTip.NO_RECREATE);
		TableViewerColumn tvcOrdered = new TableViewerColumn(tableViewer, SWT.NONE);
		tvcOrdered.getColumn().setText("OrderStatus");
		tvcOrdered.getColumn().setWidth(80);
		EMFProperties.value(ModelPackage.Literals.STOCK_ARTICLE__NUMBER_ORDERED).observeDetail(
			cp.getKnownElements());
		tvcOrdered.setLabelProvider(new ColumnLabelProvider() {
			
			@Override
			public String getText(Object element){
				return null;
			}
			
			@Override
			public String getToolTipText(Object element){
				StockArticle stockArticle = (StockArticle) element;
				return "LowerBound: " + stockArticle.getLowerBound();
			}
			
			@Override
			public Image getImage(Object element){
				StockArticle stockArticle = (StockArticle) element;
				int value = stockArticle.getNumberOnStock() - stockArticle.getLowerBound();
				
				if (stockArticle.getNumberOrdered() > 0) {
					return Images.GREEN;
				}
				if (stockArticle.getNumberOnStock() < 1) {
					return Images.RED;
				}
				if (value < 1 && stockArticle.getNumberOrdered() <= 0) {
					return Images.YELLOW;
				}
				return Images.GREY;
			}
		});
	}
	
	public void updatePart(){
		stockArticles = SampleModel.getStock().getArticles();
		tableViewer.refresh();
	}
}
