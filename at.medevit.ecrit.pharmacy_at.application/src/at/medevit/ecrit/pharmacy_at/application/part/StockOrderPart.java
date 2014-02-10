package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.handler.CommandUtil;
import at.medevit.ecrit.pharmacy_at.application.part.handler.AddToStockOrderViewerHandler;
import at.medevit.ecrit.pharmacy_at.application.part.handler.OrderArticlesViewerHandler;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class StockOrderPart {
	
	@Inject
	private IEclipseContext context;
	@Inject
	private EPartService partService;
	@Inject
	private ESelectionService selectionService;
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;
	
	private Group grpStockOrder_1;
	private Text txtTo;
	private TableViewer tableViewer;
	
	private List<StockArticle> articleToOrder;
	
	@Inject
	public StockOrderPart(){
		articleToOrder = new ArrayList<StockArticle>();
	}
	
	@PostConstruct
	public void postConstruct(Composite parent){
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		grpStockOrder_1 = new Group(composite, SWT.NONE);
		grpStockOrder_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout gl_grpStockOrder_1 = new GridLayout(2, false);
		gl_grpStockOrder_1.marginLeft = 10;
		gl_grpStockOrder_1.marginRight = 10;
		grpStockOrder_1.setLayout(gl_grpStockOrder_1);
		grpStockOrder_1.setText("Stock Order");
		
		Label lblTo = new Label(grpStockOrder_1, SWT.NONE);
		lblTo.setText("Issuing Enterprise");
		new Label(grpStockOrder_1, SWT.NONE);
		
		txtTo = new Text(grpStockOrder_1, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		GridData gd_txtTo = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		gd_txtTo.minimumWidth = 200;
		gd_txtTo.heightHint = 91;
		txtTo.setLayoutData(gd_txtTo);
		txtTo.setText("Bayer HealthCare Pharmaceuticals\r\nMüllerstr. 178\r\n13353 Berlin");
		
		initTableViewer(grpStockOrder_1);
		new Label(grpStockOrder_1, SWT.NONE);
		new Label(grpStockOrder_1, SWT.NONE);
		new Label(grpStockOrder_1, SWT.NONE);
		
		Button btnPlaceOrder = new Button(grpStockOrder_1, SWT.NONE);
		btnPlaceOrder.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnPlaceOrder.setText("Place Order");
		btnPlaceOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				SampleModel.getStockOrderInstance().setIssuer(txtTo.getText());
				selectionService.setSelection(articleToOrder);
				
				CommandUtil.setContextAndServices(context, commandService, handlerService);
				CommandUtil.manuallyCallCommand(Messages.getString("ID_CMD_ORDER_ARTICLES"),
					"commandparameter.modelelement.articlesToOrder", "stockOrder",
					new OrderArticlesViewerHandler());
			}
		});
	}
	
	private void initTableViewer(Group grpStockOrder){
		tableViewer = new TableViewer(grpStockOrder, SWT.BORDER | SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setLinesVisible(false);
		table.setHeaderVisible(true);
		
		ObservableListContentProvider cp = new ObservableListContentProvider();
		initColumns(cp);
		tableViewer.setContentProvider(cp);
		
		// add drop support
		Transfer[] transferTypes = new Transfer[] {
			TextTransfer.getInstance()
		};
		tableViewer.addDropSupport(DND.DROP_COPY, transferTypes, new DropTargetAdapter() {
			@Override
			public void dragEnter(DropTargetEvent event){
				event.detail = DND.DROP_COPY;
				tableViewer.refresh();
			}
			
			@Override
			public void drop(DropTargetEvent event){
				if (TextTransfer.getInstance().isSupportedType(event.currentDataType)) {
					CommandUtil.setContextAndServices(context, commandService, handlerService);
					CommandUtil.manuallyCallCommand(Messages.getString("ID_CMD_ADD_TO_STOCKORDER"),
						"commandparameter.modelelement.addToStockOrder", "article for order",
						new AddToStockOrderViewerHandler());
				}
			}
		});
		
		// set model
		IObservableList input = Properties.selfList(StockArticle.class).observe(articleToOrder);
		tableViewer.setInput(input);
	}
	
	private void initColumns(ObservableListContentProvider cp){
		// UNITS COLUMN
		TableViewerColumn tvcUnits = new TableViewerColumn(tableViewer, SWT.NONE);
		IObservableMap unitsMap =
			EMFProperties.value(ModelPackage.Literals.STOCK_ARTICLE__NUMBER_ORDERED).observeDetail(
				cp.getKnownElements());
		tvcUnits.setLabelProvider(new ObservableMapCellLabelProvider(unitsMap));
		tvcUnits.setEditingSupport(new UnitsEditingSupport(tableViewer));
		TableColumn colUnits = tvcUnits.getColumn();
		colUnits.setWidth(100);
		colUnits.setText("Units");
		
		// NAME COLUMN
		TableViewerColumn tvcName = new TableViewerColumn(tableViewer, SWT.NONE);
		// determine the attribute that should be observed and bind it
		FeaturePath path =
			FeaturePath.fromList(ModelPackage.Literals.STOCK_ARTICLE__ARTICLE,
				ModelPackage.Literals.ARTICLE__NAME);
		IObservableMap nameMap = EMFProperties.value(path).observeDetail(cp.getKnownElements());
		tvcName.setLabelProvider(new ObservableMapCellLabelProvider(nameMap));
		
		TableColumn colName = tvcName.getColumn();
		colName.setWidth(200);
		colName.setText("Name");
	}
	
	public void cleanPart(){
		articleToOrder.clear();
		tableViewer.refresh();
	}
	
	public void addArticle(StockArticle stockArticle){
		if (isNoDuplicate(stockArticle)) {
			stockArticle.setNumberOrdered(1);
			articleToOrder.add(stockArticle);
		}
		tableViewer.refresh();
	}
	
	private boolean isNoDuplicate(StockArticle stockArticle){
		String articleName = stockArticle.getArticle().getName();
		for (StockArticle sa : articleToOrder) {
			if (articleName.equals(sa.getArticle().getName())) {
				return false;
			}
		}
		return true;
	}
	
	class UnitsEditingSupport extends EditingSupport {
		
		private final TableViewer viewer;
		private final CellEditor editor;
		
		public UnitsEditingSupport(TableViewer viewer){
			super(viewer);
			this.viewer = viewer;
			this.editor = new TextCellEditor(viewer.getTable());
		}
		
		@Override
		protected CellEditor getCellEditor(Object element){
			return editor;
		}
		
		@Override
		protected boolean canEdit(Object element){
			return true;
		}
		
		@Override
		protected Object getValue(Object element){
			StockArticle sa = (StockArticle) element;
			return Integer.toString(sa.getNumberOrdered());
		}
		
		/**
		 * element = stockArticle, userInputValue = number
		 */
		@Override
		protected void setValue(Object element, Object userInputValue){
			StockArticle sa = (StockArticle) element;
			int userInput = Integer.parseInt((String) userInputValue);
			if (userInput < 1) {
				articleToOrder.remove(sa);
				userInput = 1;
			}
			sa.setNumberOrdered(userInput);
		}
	}
	
}