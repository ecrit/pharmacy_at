package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
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

import at.medevit.ecrit.pharmacy_at.application.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ArticleAvailability;
import at.medevit.ecrit.pharmacy_at.model.Invoice;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;

public class BillPart {
	private Invoice invoice;
	private List<Article> noDuplicateArticles;
	private HashMap<String, Integer> amountMap = new HashMap<String, Integer>();
	private IObservableList input;

	private TableViewer tableViewer;
	private Table table;

	@Inject
	private EPartService partService;
	@Inject
	private ESelectionService selectionService;
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;
	
	private static final String ID_PRESCRIPTION_PART = "at.medevit.ecrit.pharmacy_at.application.part.prescription";
	private static final String ID_INVOICE_PART = "at.medevit.ecrit.pharmacy_at.application.part.invoice";
	private static final String ID_ADD_TO_INVOICE_CMD = "at.medevit.ecrit.pharmacy_at.application.command.addToInvoice";

	@Inject
	public BillPart() {
		invoice = SampleModel.getInvoice();
		noDuplicateArticles = new ArrayList<Article>();
		// amountMap = new HashMap<String, Integer>();
	}

	@PostConstruct
	public void postConstruct(final Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		composite.setLayout(new GridLayout(1, false));

		Label lblBillpart = new Label(composite, SWT.NONE);
		GridData gd_lblBillpart = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_lblBillpart.widthHint = 400;
		lblBillpart.setLayoutData(gd_lblBillpart);
		lblBillpart.setText("Placed on the invoice");

		// initialize tableviewer
		initTableViewer(composite);

		// Buttons
		Composite buttonComposite = new Composite(composite, SWT.NONE);
		buttonComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		buttonComposite.setLayout(new GridLayout(2, false));

		// payment button
		Button btnPay = new Button(buttonComposite, SWT.PUSH);
		btnPay.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		btnPay.setText("Cash up");
		btnPay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(parent.getShell(), "Receipt",
						"Receipt printed... TODO ");
			}
		});

		// cancle button
		Button btnRevert = new Button(buttonComposite, SWT.PUSH);
		btnRevert.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		btnRevert.setText("Cancel Cash up");
		btnRevert.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (MessageDialog.openConfirm(
						parent.getShell(),
						"Cancle selling",
						"Are you sure you want to cancle this selling process?\n All changes will be lost!")){
					SampleModel.revertInvoice(invoice);
					invoice = SampleModel.getInvoice();
					updateTable();
					updateConnectedParts();
				}
			}
		});
	}

	protected void updateConnectedParts() {
		MPart pPart = partService.findPart(ID_PRESCRIPTION_PART);
		PrescriptionPart prescPart = (PrescriptionPart) pPart.getObject();
		prescPart.clearPrescriptions();
		prescPart.updateTable();
		
		MPart iPart = partService.findPart(ID_INVOICE_PART);
		InvoicePart invoicePart = (InvoicePart) iPart.getObject();
		invoicePart.updateTable();
		
	}

	private void initTableViewer(Composite composite) {
		tableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// set content provider and init columns
		ObservableListContentProvider cp = new ObservableListContentProvider();
		initColumns(cp);
		tableViewer.setContentProvider(cp);

		// add drop support
		Transfer[] transferTypes = new Transfer[] { TextTransfer.getInstance() };
		tableViewer.addDropSupport(DND.DROP_COPY, transferTypes,
				new DropTargetAdapter() {
					@Override
					public void dragEnter(DropTargetEvent event) {
						event.detail = DND.DROP_COPY;
						tableViewer.refresh();
					}

					@Override
					public void drop(DropTargetEvent event) {
						Command cmd = commandService
								.getCommand(ID_ADD_TO_INVOICE_CMD);
						ParameterizedCommand pCmd = new ParameterizedCommand(
								cmd, null);

						// only execute if command can be executed
						if (handlerService.canExecute(pCmd)) {
							handlerService.executeHandler(pCmd);
						}
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
	private void initColumns(ObservableListContentProvider cp) {
		String[] columnNames = new String[] { "Amount", "Article Name" };
		int[] columnWidths = new int[] { 100, 200 };

		for (int i = 0; i < columnNames.length; i++) {
			TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);

			if (i == 0) {
				tvc.setLabelProvider(new ColumnLabelProvider() {
					@Override
					public String getText(Object element) {
						Article a = (Article) element;
						if (amountMap.get(a.getName()) != null) {
							return Integer.toString(amountMap.get(a.getName()));
						}
						return "1";
					}
				});
			} else {
				IObservableMap map = EMFProperties.value(
						ModelPackage.Literals.ARTICLE__NAME).observeDetail(
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
	protected boolean isDuplicate(Article a) {
		for (Article val : noDuplicateArticles) {
			if (val.getName().equals(a.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * makes sure article is only displayed once but amount is increased if an
	 * article occures more than once
	 */
	private void assureNoDuplicates(List<Article> articles) {
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

	public void updateSelection(List<Article> aList) {
		tableViewer.getTable().setFocus();
		selectionService.setSelection(aList);
	}

	public void updateTable() {
		if (tableViewer != null) {
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