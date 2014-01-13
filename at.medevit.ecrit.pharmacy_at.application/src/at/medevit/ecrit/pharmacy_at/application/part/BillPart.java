package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
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

		// payment button
		Button btnPay = new Button(composite, SWT.PUSH);
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
						Article a = convertStringToArticle((String) event.data);
						invoice.getArticle().add(a);

						if (isDuplicate(a)) {
							int newAmount = amountMap.get(a.getName()) + 1;
							amountMap.put(a.getName(), newAmount);
						} else {
							noDuplicateArticles.add(a);
							amountMap.put(a.getName(), 1);
						}
						tableViewer.refresh();
						updateSelection(invoice.getArticle());
					}
				});

		// set model
		input = Properties.selfList(Article.class).observe(noDuplicateArticles);
		tableViewer.setInput(input);
	}
	
	/**
	 * initialise columns and setup databinding
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
				IObservableMap map = EMFProperties.value(ModelPackage.Literals.ARTICLE__NAME).observeDetail(cp.getKnownElements());
				tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
			}

			// set the column title & size
			tvc.getColumn().setText(columnNames[i]);
			tvc.getColumn().setWidth(columnWidths[i]);
			tvc.getColumn().setResizable(true);
		}
	}

	/**
	 * Convert the string with article information to an actual article
	 * 
	 * @param value
	 *            article.toString();
	 * @return article
	 */
	protected Article convertStringToArticle(String value) {
		Article a = ModelFactory.eINSTANCE.createArticle();
		int beginIdx = value.indexOf("name: ");
		beginIdx = value.indexOf(" ", beginIdx) + 1;
		int endIdx = value.indexOf(", description: ", beginIdx);
		a.setName(value.substring(beginIdx, endIdx));

		beginIdx = endIdx + 2;
		beginIdx = value.indexOf(" ", beginIdx) + 1;
		endIdx = value.indexOf(", admissionNumber: ", beginIdx);
		a.setDescription(value.substring(beginIdx, endIdx));

		beginIdx = endIdx + 2;
		beginIdx = value.indexOf(" ", beginIdx) + 1;
		endIdx = value.indexOf(", availability: ", beginIdx);
		a.setAdmissionNumber(Integer.parseInt(value.substring(beginIdx, endIdx)));

		beginIdx = endIdx + 2;
		beginIdx = value.indexOf(" ", beginIdx) + 1;
		endIdx = value.indexOf(", price: ", beginIdx);
		a.setAvailability(ArticleAvailability.get(value.substring(beginIdx,
				endIdx)));

		beginIdx = endIdx + 2;
		beginIdx = value.indexOf(" ", beginIdx) + 1;
		endIdx = value.indexOf(")", beginIdx);
		a.setPrice(Float.parseFloat(value.substring(beginIdx, endIdx)));

		return a;
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
	private void assureNoDuplicates() {
		noDuplicateArticles.clear();
		int newAmount = 0;
		for (Article a : invoice.getArticle()) {
			if (isDuplicate(a)) {
				newAmount = amountMap.get(a.getName()) + 1;
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
			assureNoDuplicates();
			tableViewer.refresh();
		}
	}

}