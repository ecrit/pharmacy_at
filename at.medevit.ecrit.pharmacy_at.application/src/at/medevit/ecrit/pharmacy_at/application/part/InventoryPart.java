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
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.handler.CommandUtil;
import at.medevit.ecrit.pharmacy_at.application.handler.clerk.CheckInventoryHandler;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class InventoryPart {
	private CheckboxTableViewer tableViewer;
	private List<StockArticle> stockArticles;
	
	@Inject
	private IEclipseContext context;
	@Inject
	private ESelectionService selectionService;
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;
	private Table table;
	
	@Inject
	public InventoryPart(){
		stockArticles = SampleModel.getStock().getArticles();
	}
	
	@PostConstruct
	public void postConstruct(Composite parent){
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		parent.setLayout(new GridLayout(1, false));
		
		Label label = new Label(parent, SWT.NONE);
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label.heightHint = 6;
		gd_label.minimumHeight = 6;
		label.setLayoutData(gd_label);
		
		Label lblInventory = new Label(parent, SWT.NONE);
		GridData gd_lblInventory = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblInventory.heightHint = 30;
		gd_lblInventory.minimumHeight = 30;
		lblInventory.setLayoutData(gd_lblInventory);
		lblInventory.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblInventory.setText("Inventory Helper");
		
		tableViewer = CheckboxTableViewer.newCheckList(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Button btnInventoryChecked = new Button(parent, SWT.NONE);
		btnInventoryChecked.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnInventoryChecked.setText("Finish Inventory");
		btnInventoryChecked.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				selectionService.setSelection(tableViewer.getCheckedElements());
				CommandUtil.setContextAndServices(context, commandService, handlerService);
				CommandUtil.manuallyCallCommand(Messages.getString("ID_CMD_CHECK_INVENTORY"),
					"commandparameter.checkInventory", "consistent articles",
					new CheckInventoryHandler());
			}
		});
		
		ObservableListContentProvider cp = new ObservableListContentProvider();
		initColumns(cp);
		tableViewer.setContentProvider(cp);
		
		// set model
		IObservableList input = Properties.selfList(StockArticle.class).observe(stockArticles);
		tableViewer.setInput(input);
		
	}
	
	private void initColumns(ObservableListContentProvider cp){
		TableViewerColumn tvcOnStock = new TableViewerColumn(tableViewer, SWT.NONE);
		IObservableMap stockMap =
			EMFProperties.value(ModelPackage.Literals.STOCK_ARTICLE__NUMBER_ON_STOCK)
				.observeDetail(cp.getKnownElements());
		tvcOnStock.setLabelProvider(new ObservableMapCellLabelProvider(stockMap));
		TableColumn colOnstock = tvcOnStock.getColumn();
		colOnstock.setWidth(100);
		colOnstock.setText("OnStock");
		
		TableViewerColumn tvcName = new TableViewerColumn(tableViewer, SWT.NONE);
		FeaturePath pathName =
			FeaturePath.fromList(ModelPackage.Literals.STOCK_ARTICLE__ARTICLE,
				ModelPackage.Literals.ARTICLE__NAME);
		IObservableMap nameMap = EMFProperties.value(pathName).observeDetail(cp.getKnownElements());
		tvcName.setLabelProvider(new ObservableMapCellLabelProvider(nameMap));
		TableColumn colName = tvcName.getColumn();
		colName.setWidth(100);
		colName.setText("Name");
		
		TableViewerColumn tvcAdmNr = new TableViewerColumn(tableViewer, SWT.NONE);
		FeaturePath pathAdmNr =
			FeaturePath.fromList(ModelPackage.Literals.STOCK_ARTICLE__ARTICLE,
				ModelPackage.Literals.ARTICLE__ADMISSION_NUMBER);
		IObservableMap admNrMap =
			EMFProperties.value(pathAdmNr).observeDetail(cp.getKnownElements());
		tvcAdmNr.setLabelProvider(new ObservableMapCellLabelProvider(admNrMap));
		TableColumn colAdmnr = tvcAdmNr.getColumn();
		colAdmnr.setWidth(100);
		colAdmnr.setText("AdmNr");
		
	}
}