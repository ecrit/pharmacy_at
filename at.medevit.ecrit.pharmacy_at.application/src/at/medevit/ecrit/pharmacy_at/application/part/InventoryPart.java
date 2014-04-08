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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.handler.clerk.parts.CheckInventoryViewerHandler;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class InventoryPart implements IPart {
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
		
		Group grpInventory = new Group(parent, SWT.NONE);
		grpInventory.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout gl_grpStockOrder_1 = new GridLayout(1, false);
		gl_grpStockOrder_1.marginLeft = 10;
		gl_grpStockOrder_1.marginRight = 10;
		grpInventory.setLayout(gl_grpStockOrder_1);
		grpInventory.setText("Inventory Helper");
		
		Label label = new Label(grpInventory, SWT.NONE);
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label.heightHint = 6;
		gd_label.minimumHeight = 6;
		label.setLayoutData(gd_label);
		
		Label lblInventory = new Label(grpInventory, SWT.NONE);
		lblInventory.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));
		lblInventory
			.setText("Only check the articles below if the units on stock \nmatch your inventory notes!");
		
		new Label(grpInventory, SWT.NONE);
		
		tableViewer =
			CheckboxTableViewer.newCheckList(grpInventory, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Button btnInventoryChecked = new Button(grpInventory, SWT.NONE);
		btnInventoryChecked.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnInventoryChecked.setText("Finish Inventory");
		btnInventoryChecked.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				selectionService.setSelection(tableViewer.getCheckedElements());
				CommandUtil.setContextAndServices(context, commandService, handlerService);
				CommandUtil.manuallyCallCommand(AppModelId.COMMAND_COMMAND_CHECKINVENTORY,
					"commandparameter.checkInventory", "consistent articles",
					new CheckInventoryViewerHandler());
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
		colOnstock.setWidth(80);
		colOnstock.setText("OnStock");
		
		TableViewerColumn tvcName = new TableViewerColumn(tableViewer, SWT.NONE);
		FeaturePath pathName =
			FeaturePath.fromList(ModelPackage.Literals.STOCK_ARTICLE__ARTICLE,
				ModelPackage.Literals.ARTICLE__NAME);
		IObservableMap nameMap = EMFProperties.value(pathName).observeDetail(cp.getKnownElements());
		tvcName.setLabelProvider(new ObservableMapCellLabelProvider(nameMap));
		TableColumn colName = tvcName.getColumn();
		colName.setWidth(150);
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
	
	@Override
	public void updatePart(){
		// TODO Auto-generated method stub
		
	}
}