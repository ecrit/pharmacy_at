package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.wb.swt.SWTResourceManager;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.handler.seller.CancelInvoiceHandler;
import at.medevit.ecrit.pharmacy_at.application.handler.seller.parts.AddToInvoiceViewerHandler;
import at.medevit.ecrit.pharmacy_at.application.handler.seller.parts.PrintInvoiceViewerHandler;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Invoice;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;

public class InvoiceDataPart implements IPart {
	private Invoice invoice;
	private List<Article> noDuplicateArticles;
	private HashMap<String, Integer> amountMap = new HashMap<String, Integer>();
	private IObservableList input;
	
	private TableViewer tableViewer;
	private Table table;
	
	@Inject
	private MWindow window;
	@Inject
	private EModelService modelService;
	@Inject
	private IEclipseContext context;
	@Inject
	private EMenuService menuService;
	@Inject
	private EPartService partService;
	@Inject
	private ESelectionService selectionService;
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;
	
	@Inject
	public InvoiceDataPart(){
		invoice = SampleModel.getInvoice();
		noDuplicateArticles = new ArrayList<Article>();
		// amountMap = new HashMap<String, Integer>();
	}
	
	@PostConstruct
	public void postConstruct(final Composite parent){
		parent.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		parent.setLayout(new GridLayout(1, false));
		
		Label lblBillpart = new Label(parent, SWT.NONE);
		lblBillpart.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		GridData gd_lblBillpart = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_lblBillpart.widthHint = 400;
		lblBillpart.setLayoutData(gd_lblBillpart);
		lblBillpart.setText("Create Invoice");
		
		// initialize tableviewer
		initTableViewer(parent);
		
		// Buttons
		Composite buttonComposite = new Composite(parent, SWT.NONE);
		buttonComposite.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false, 1, 1));
		buttonComposite.setLayout(new GridLayout(2, false));
		
		// payment button
		Button btnPay = new Button(buttonComposite, SWT.PUSH);
		btnPay.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnPay.setText("Cash up");
		btnPay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				selectionService.setSelection(amountMap);
				CommandUtil.setContextAndServices(context, commandService, handlerService);
				CommandUtil.manuallyCallCommand(AppModelId.COMMAND_COMMAND_PRINTINVOICE,
					"commandparameter.printInvoice", "article-amount map",
					new PrintInvoiceViewerHandler());
			}
		});
		
		// cancle button
		Button btnRevert = new Button(buttonComposite, SWT.PUSH);
		btnRevert.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnRevert.setText("Cancel Cash up");
		btnRevert.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				if (MessageDialog.openConfirm(parent.getShell(), "Cancle selling",
					"Are you sure you want to cancle this selling process?\n All changes will be lost!")) {
					
					CommandUtil.setContextAndServices(context, commandService, handlerService);
					CommandUtil.manuallyCallCommand(AppModelId.COMMAND_COMMAND_CANCELINVOICE,
						null, null, new CancelInvoiceHandler());
				}
			}
		});
		
		menuService.registerContextMenu(tableViewer.getTable(),
			AppModelId.POPUPMENU_AT_MEDEVIT_ECRIT_PHARMACY_AT_APPLICATION_POPUPMENU_INVOICEDATA);
	}
	
	private void initTableViewer(Composite composite){
		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		// set content provider and init columns
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
					CommandUtil.manuallyCallCommand(AppModelId.COMMAND_AT_MEDEVIT_ECRIT_PHARMACY_AT_APPLICATION_COMMAND_ADDTOINVOICE,
						"commandparameter.modelelement.Article", "put article on invoice",
						new AddToInvoiceViewerHandler());
					
				}
			}
		});
		
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				Article article = (Article) selection.getFirstElement();
				selectionService.setSelection(article);
			}
		});
		
		// set model
		input = Properties.selfList(Article.class).observe(noDuplicateArticles);
		tableViewer.setInput(input);
	}
	
	/**
	 * initialise columns and setup databinding
	 * 
	 * @param cp
	 */
	private void initColumns(ObservableListContentProvider cp){
		String[] columnNames = new String[] {
			"Amount", "Article Name"
		};
		int[] columnWidths = new int[] {
			100, 200
		};
		
		for (int i = 0; i < columnNames.length; i++) {
			TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
			
			if (i == 0) {
				tvc.setLabelProvider(new ColumnLabelProvider() {
					@Override
					public String getText(Object element){
						Article a = (Article) element;
						if (amountMap.get(a.getName()) != null) {
							return Integer.toString(amountMap.get(a.getName()));
						}
						return "1";
					}
				});
			} else {
				IObservableMap map =
					EMFProperties.value(ModelPackage.Literals.ARTICLE__NAME).observeDetail(
						cp.getKnownElements());
				tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
			}
			
			// set the column title & size
			tvc.getColumn().setText(columnNames[i]);
			tvc.getColumn().setWidth(columnWidths[i]);
			tvc.getColumn().setResizable(true);
		}
	}
	
	/**
	 * checks if article is already displayed on invoice
	 * 
	 * @param a
	 *            article
	 * @return true if article is part of noDuplicateList, false if not
	 */
	protected boolean isDuplicate(Article a){
		for (Article val : noDuplicateArticles) {
			if (val.getName().equals(a.getName())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * makes sure article is only displayed once but amount is increased if an article occures more
	 * than once
	 */
	private void assureNoDuplicates(List<Article> articles){
		for (Article a : articles) {
			if (isDuplicate(a)) {
				int newAmount = amountMap.get(a.getName()) + 1;
				amountMap.put(a.getName(), newAmount);
			} else {
				noDuplicateArticles.add(a);
				amountMap.put(a.getName(), 1);
			}
		}
	}
	
	public void updateSelection(List<Article> aList){
		tableViewer.getTable().setFocus();
		selectionService.setSelection(aList);
	}
	
	public void addArticleAndUpdate(Article a){
		List<Article> articles = new ArrayList<>();
		articles.add(a);
		assureNoDuplicates(articles);
		tableViewer.refresh();
		updateSelection(invoice.getArticle());
	}
	
	@Override
	public void updatePart(){
		if (tableViewer != null) {
			invoice = SampleModel.getInvoice();
			noDuplicateArticles.clear();
			assureNoDuplicates(invoice.getArticle());
			selectionService.setSelection(invoice.getArticle());
			tableViewer.refresh();
		}
	}
}