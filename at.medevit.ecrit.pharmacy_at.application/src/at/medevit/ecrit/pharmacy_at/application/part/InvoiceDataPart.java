package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;
import java.util.HashMap;
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
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.e4.ui.workbench.swt.modeling.EMenuService;
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

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.handler.seller.CancelInvoiceHandler;
import at.medevit.ecrit.pharmacy_at.application.part.handler.AddToInvoiceViewerHandler;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Invoice;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;

public class InvoiceDataPart {
	private Invoice invoice;
	private List<Article> noDuplicateArticles;
	private HashMap<String, Integer> amountMap = new HashMap<String, Integer>();
	private IObservableList input;
	
	private TableViewer tableViewer;
	private Table table;
	
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
		invoice = SampleModel.getCurrentInvoice();
		noDuplicateArticles = new ArrayList<Article>();
		// amountMap = new HashMap<String, Integer>();
	}
	
	@PostConstruct
	public void postConstruct(final Composite parent){
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite.setLayout(new GridLayout(1, false));
		
		Label lblBillpart = new Label(composite, SWT.NONE);
		GridData gd_lblBillpart = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_lblBillpart.widthHint = 400;
		lblBillpart.setLayoutData(gd_lblBillpart);
		lblBillpart.setText("Invoice Form");
		
		// initialize tableviewer
		initTableViewer(composite);
		
		// Buttons
		Composite buttonComposite = new Composite(composite, SWT.NONE);
		buttonComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		buttonComposite.setLayout(new GridLayout(2, false));
		
		// payment button
		Button btnPay = new Button(buttonComposite, SWT.PUSH);
		btnPay.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnPay.setText("Cash up");
		btnPay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				MessageDialog.openInformation(parent.getShell(), "Receipt",
					"Receipt printed... TODO ");
				SampleModel.saveInvoice();
				MPart idPart = partService.findPart(Messages.getString("ID_PART_INVOICE_DATA"));
				InvoiceDataPart invoiceDataPart = (InvoiceDataPart) idPart.getObject();
				invoiceDataPart.updateTable();
				
				MPart pPart = partService.findPart(Messages.getString("ID_PART_PRESCRIPTION"));
				PrescriptionPart prescPart = (PrescriptionPart) pPart.getObject();
				prescPart.updateTable();
				
				MPart iPart = partService.findPart(Messages.getString("ID_PART_INVOICE"));
				InvoicePart invoicePart = (InvoicePart) iPart.getObject();
				invoicePart.updateTable();
				invoicePart.updateBinding();
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
					
					Command cmd =
						commandService.getCommand(Messages.getString("ID_CMD_CANCEL_INVOICE"));
					ParameterizedCommand pCmd = new ParameterizedCommand(cmd, null);
					
					// tell the HandlerService which handler we're talking about
					CancelInvoiceHandler cancelInvoiceHandler = new CancelInvoiceHandler();
					// manually inject as all the injected values are null otherwise
					ContextInjectionFactory.inject(cancelInvoiceHandler, context);
					handlerService.activateHandler(Messages.getString("ID_CMD_CANCEL_INVOICE"),
						cancelInvoiceHandler);
					
					if (handlerService.canExecute(pCmd)) {
						handlerService.executeHandler(pCmd);
					}
				}
			}
		});
		
		menuService.registerContextMenu(tableViewer.getTable(),
			Messages.getString("ID_POPUP_INVOICE_DATA"));
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
					Command cmd =
						commandService.getCommand(Messages.getString("ID_CMD_ADD_TO_INVOICE"));
					ParameterizedCommand pCmd = prepareCommandWithParameters(cmd);
					
					// tell the HandlerService which handler we're talking about
					AddToInvoiceViewerHandler addToInvoiceViewerHandler =
						new AddToInvoiceViewerHandler();
					// manually inject as all the injected values are null otherwise
					ContextInjectionFactory.inject(addToInvoiceViewerHandler, context);
					handlerService.activateHandler(Messages.getString("ID_CMD_ADD_TO_INVOICE"),
						addToInvoiceViewerHandler);
					
					if (handlerService.canExecute(pCmd)) {
						handlerService.executeHandler(pCmd);
					}
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
	
	protected ParameterizedCommand prepareCommandWithParameters(Command cmd){
		ParameterizedCommand pCmd = new ParameterizedCommand(cmd, null);
		try {
			Object stockArticle =
				selectionService.getSelection(Messages.getString("ID_PART_ARTICLELIST"));
			
			// get parameters
			IParameter iparam = cmd.getParameter("commandparameter.modelelement.Article");
			ArrayList<Parameterization> parameters = new ArrayList<Parameterization>();
			parameters.add(new Parameterization(iparam, stockArticle.toString()));
			
			// create parameterized command
			pCmd =
				new ParameterizedCommand(cmd, parameters.toArray(new Parameterization[parameters
					.size()]));
		} catch (NotDefinedException e) {
			e.printStackTrace();
		}
		return pCmd;
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
	
	public void updateTable(){
		if (tableViewer != null) {
			invoice = SampleModel.getCurrentInvoice();
			noDuplicateArticles.clear();
			assureNoDuplicates(invoice.getArticle());
			selectionService.setSelection(invoice.getArticle());
			tableViewer.refresh();
		}
	}
	
	public void addArticleAndUpdate(Article a){
		List<Article> articles = new ArrayList<>();
		articles.add(a);
		assureNoDuplicates(articles);
		tableViewer.refresh();
		updateSelection(invoice.getArticle());
	}
}