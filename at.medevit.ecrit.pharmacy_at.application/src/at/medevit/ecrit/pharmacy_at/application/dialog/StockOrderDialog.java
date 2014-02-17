package at.medevit.ecrit.pharmacy_at.application.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.StockOrder;

public class StockOrderDialog extends TitleAreaDialog {
	private DataBindingContext m_bindingContext;
	private List<Article> articles = new ArrayList<Article>();
	private StockOrder stockOrder;
	private String message;
	private Text txtId;
	private Text txtStatus;
	private HashMap<String, Integer> articleUnits = new HashMap<String, Integer>();
	
	public StockOrderDialog(Shell parentShell, StockOrder stockOrder){
		super(parentShell);
		setHelpAvailable(false);
		this.stockOrder = stockOrder;
		int idx = stockOrder.getIssuer().indexOf("\n");
		this.message = stockOrder.getIssuer().substring(0, idx);
		
		for (Article a : stockOrder.getArticle()) {
			int units = 1;
			if (articleUnits.containsKey(a.getName())) {
				units = units + articleUnits.get(a.getName());
				articleUnits.put(a.getName(), units);
			} else {
				articleUnits.put(a.getName(), units);
				this.articles.add(a);
			}
		}
	}
	
	@Override
	protected Control createDialogArea(Composite parent){
		setTitle("Stock Order");
		setMessage(message);
		
		Composite area = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) area.getLayout();
		gridLayout.marginRight = 10;
		gridLayout.marginLeft = 10;
		
		Composite baseInfo = new Composite(area, SWT.NONE);
		baseInfo.setLayout(new GridLayout(4, false));
		baseInfo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		
		Label lblId = new Label(baseInfo, SWT.NONE);
		lblId.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblId.setText("ID: ");
		
		txtId = new Text(baseInfo, SWT.READ_ONLY);
		txtId.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblStatus = new Label(baseInfo, SWT.NONE);
		lblStatus.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStatus.setText("Status: ");
		
		txtStatus = new Text(baseInfo, SWT.READ_ONLY);
		txtStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		initTableViewer(area);
		return area;
	}
	
	private void initTableViewer(Composite area){
		TableViewer tableViewer = new TableViewer(area, SWT.BORDER | SWT.V_SCROLL);
		Table table = tableViewer.getTable();
		table.setFocus();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setLinesVisible(false);
		table.setHeaderVisible(true);
		
		TableViewerColumn tvcUnits = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn colUnits = tvcUnits.getColumn();
		colUnits.setWidth(100);
		colUnits.setText("Units");
		tvcUnits.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element){
				Article a = (Article) element;
				return articleUnits.get(a.getName()) + "";
			}
		});
		
		TableViewerColumn tvcName = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn colName = tvcName.getColumn();
		colName.setWidth(200);
		colName.setText("Name");
		tvcName.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element){
				Article a = (Article) element;
				return a.getName();
			}
		});
		
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setInput(articles);
		m_bindingContext = initDataBindings();
	}
	
	protected DataBindingContext initDataBindings(){
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtIdObserveWidget =
			WidgetProperties.text(SWT.NONE).observe(txtId);
		IObservableValue numberStockOrderObserveValue =
			PojoProperties.value("number").observe(stockOrder);
		bindingContext.bindValue(observeTextTxtIdObserveWidget, numberStockOrderObserveValue, null,
			null);
		//
		IObservableValue observeTextTxtStatusObserveWidget =
			WidgetProperties.text(SWT.NONE).observe(txtStatus);
		IObservableValue statusStockOrderObserveValue =
			PojoProperties.value("status").observe(stockOrder);
		bindingContext.bindValue(observeTextTxtStatusObserveWidget, statusStockOrderObserveValue,
			null, null);
		//
		return bindingContext;
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		createButton(parent, IDialogConstants.OK_ID, "OK", true);
	}
}
