package at.medevit.ecrit.pharmacy_at.application.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

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

public class StockOrderOverviewPart {
	private Text txtSearch;
	private Table table;
	private TableViewer tableViewer;
	
	@Inject
	public StockOrderOverviewPart(){
		// TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent){
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		txtSearch = new Text(composite, SWT.BORDER);
		txtSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn colNumber = tableViewerColumn.getColumn();
		colNumber.setWidth(100);
		colNumber.setText("Number");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn colOrderStatus = tableViewerColumn_2.getColumn();
		colOrderStatus.setWidth(100);
		colOrderStatus.setText("Order Status");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn colStock = tableViewerColumn_1.getColumn();
		colStock.setWidth(100);
		colStock.setText("Stock");
		// TODO Your code here
	}
	
	public void update(){
		SampleModel.getAllStockOrders();
		tableViewer.refresh();
	}
	
}