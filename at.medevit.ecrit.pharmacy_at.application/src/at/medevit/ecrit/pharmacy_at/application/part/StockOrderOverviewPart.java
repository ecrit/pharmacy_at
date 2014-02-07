package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.IParameter;
import org.eclipse.core.commands.Parameterization;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.part.handler.EditStockOrderStatusViewerHandler;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockOrder;
import at.medevit.ecrit.pharmacy_at.model.StockOrderStatus;

public class StockOrderOverviewPart {
	private Text txtSearch;
	private TableViewer tableViewer;
	private List<StockOrder> stockOrders;
	
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
	
	@Inject
	public StockOrderOverviewPart(){
		stockOrders = SampleModel.getAllStockOrders();
	}
	
	@PostConstruct
	public void postConstruct(Composite parent){
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		txtSearch = new Text(composite, SWT.BORDER);
		txtSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setLinesVisible(false);
		table.setHeaderVisible(true);
		
		ObservableListContentProvider cp = new ObservableListContentProvider();
		initColumns(cp);
		tableViewer.setContentProvider(cp);
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				StockOrder order = (StockOrder) selection.getFirstElement();
				
			}
		});
		// set model
		IObservableList input = Properties.selfList(StockOrder.class).observe(stockOrders);
		tableViewer.setInput(input);
	}
	
	private void initColumns(ObservableListContentProvider cp){
		TableViewerColumn tvcID = new TableViewerColumn(tableViewer, SWT.NONE);
		IObservableMap idMap =
			EMFProperties.value(ModelPackage.Literals.STOCK_ORDER__NUMBER).observeDetail(
				cp.getKnownElements());
		tvcID.setLabelProvider(new ObservableMapCellLabelProvider(idMap));
		TableColumn colID = tvcID.getColumn();
		colID.setWidth(100);
		colID.setText("ID");
		
		TableViewerColumn tvcStatus = new TableViewerColumn(tableViewer, SWT.NONE);
		IObservableMap statusMap =
			EMFProperties.value(ModelPackage.Literals.STOCK_ORDER__STATUS).observeDetail(
				cp.getKnownElements());
		tvcStatus.setLabelProvider(new ObservableMapCellLabelProvider(statusMap));
		tvcStatus.setEditingSupport(new StatusEditingSupport(tvcStatus.getViewer()));
		TableColumn colStatus = tvcStatus.getColumn();
		colStatus.setWidth(100);
		colStatus.setText("Order Status");
		
		TableViewerColumn tvcStock = new TableViewerColumn(tableViewer, SWT.NONE);
		IObservableMap stockMap =
			EMFProperties.value(ModelPackage.Literals.STOCK_ORDER__ISSUER).observeDetail(
				cp.getKnownElements());
		tvcStock.setLabelProvider(new ObservableMapCellLabelProvider(stockMap));
		TableColumn colStock = tvcStock.getColumn();
		colStock.setWidth(500);
		colStock.setText("Issuing Enterprise");
	}
	
	public void updatePart(){
		stockOrders = SampleModel.getAllStockOrders();
		tableViewer.refresh();
	}
	
	class StatusEditingSupport extends EditingSupport {
		
		private ComboBoxViewerCellEditor cellEditor = null;
		
		private StatusEditingSupport(ColumnViewer viewer){
			super(viewer);
			cellEditor =
				new ComboBoxViewerCellEditor((Composite) getViewer().getControl(), SWT.READ_ONLY);
			cellEditor.setLabelProvider(new LabelProvider());
			cellEditor.setContenProvider(new ArrayContentProvider());
			cellEditor.setInput(StockOrderStatus.values());
		}
		
		@Override
		protected CellEditor getCellEditor(Object element){
			return cellEditor;
		}
		
		@Override
		protected boolean canEdit(Object element){
			return true;
		}
		
		@Override
		protected Object getValue(Object element){
			if (element instanceof StockOrder) {
				StockOrder data = (StockOrder) element;
				return data.getStatus();
			}
			return null;
		}
		
		@Override
		protected void setValue(Object element, Object value){
			if (element instanceof StockOrder && value instanceof StockOrderStatus) {
				StockOrder data = (StockOrder) element;
				StockOrderStatus newStatus = (StockOrderStatus) value;
				// only set new value if it differs from old one
				if (!data.getStatus().equals(newStatus)) {
					data.setStatus(newStatus);
					selectionService.setSelection(data);
					callEditStockOrderStatusViewerHandler();
				}
			}
		}
		
		private void callEditStockOrderStatusViewerHandler(){
			Command cmd =
				commandService.getCommand(Messages.getString("ID_CMD_EDIT_STOCKORDER_STATUS"));
			ParameterizedCommand pCmd =
				prepareCommandWithParameters(cmd, "commandparameter.editStockOrderStatus");
			
			EditStockOrderStatusViewerHandler editSOStatusHandler =
				new EditStockOrderStatusViewerHandler();
			ContextInjectionFactory.inject(editSOStatusHandler, context);
			handlerService.activateHandler(Messages.getString("ID_CMD_EDIT_STOCKORDER_STATUS"),
				editSOStatusHandler);
			
			if (handlerService.canExecute(pCmd)) {
				handlerService.executeHandler(pCmd);
			}
		}
		
		protected ParameterizedCommand prepareCommandWithParameters(Command cmd, String parameter){
			ParameterizedCommand pCmd = new ParameterizedCommand(cmd, null);
			try {
				// get parameters
				IParameter iparam = cmd.getParameter(parameter);
				ArrayList<Parameterization> parameters = new ArrayList<Parameterization>();
				parameters.add(new Parameterization(iparam, "order to change status from"));
				
				// create parameterized command
				pCmd =
					new ParameterizedCommand(cmd,
						parameters.toArray(new Parameterization[parameters.size()]));
			} catch (NotDefinedException e) {
				e.printStackTrace();
			}
			return pCmd;
		}
		
	}
}