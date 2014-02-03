package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockOrder;

public class StockOrderOverviewPart {
	private Text txtSearch;
	private TableViewer tableViewer;
	private List<StockOrder> stockOrders;
	
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
	
}