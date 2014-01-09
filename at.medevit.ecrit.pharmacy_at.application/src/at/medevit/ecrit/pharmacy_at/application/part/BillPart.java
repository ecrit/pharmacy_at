package at.medevit.ecrit.pharmacy_at.application.part;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Invoice;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;

public class BillPart {
	private Invoice invoice;
	private TableViewer tableViewer;
	private Table table;
	private IObservableList input;
	private List<Article> articles;
	private List<Article> articles4Prescription;
	private HashMap<String, Integer> amountMap;

	@Inject
	private ESelectionService selectionService;

	@Inject
	public BillPart() {
		invoice = ModelFactory.eINSTANCE.createInvoice();
		invoice.setDate(new Date());
		invoice.setId(1);

		articles = new ArrayList<Article>();
		articles4Prescription = new ArrayList<Article>();
		amountMap = new HashMap<String, Integer>();
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

		// initialises the tableviewer
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

	private List<String> getArticles() {
		List<String> articleList = new ArrayList<String>();
		Iterator<?> it = input.iterator();

		for (int i = 0; it.hasNext(); i++) {
			Article a = (Article) it.next();
			articleList.add(a.getName());
		}
		return articleList;
	}

	private void initTableViewer(Composite composite) {
		tableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		ObservableListContentProvider cp = new ObservableListContentProvider();
		initColumns(cp);
		input = Properties.selfList(Article.class).observe(
				new ArrayList<Article>());
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
						String name = (String) event.data;
						Article a = ModelFactory.eINSTANCE.createArticle();
						a.setName(name);
						articles4Prescription.add(a);

						if(isAlreadyOnInvoice(a)){
							int newAmount = amountMap.get(a.getName()) + 1;
							amountMap.put(a.getName(), newAmount);
						}else {
							articles.add(a);
							amountMap.put(a.getName(), 1);
							input.add(a);
						} 
						
						tableViewer.refresh();
						updateSelection(articles4Prescription);
					}
				});

		// set model
		tableViewer.setInput(input);
	}

	protected boolean isAlreadyOnInvoice(Article a) {
		for (Article val : articles) {
			if(val.getName().equals(a.getName())){
				return true;
			}
		}
		return false;
	}

	private void initColumns(ObservableListContentProvider cp) {
		String[] columnNames = new String[] { "Amount", "Article Name" };
//		EAttribute[] columnAttributes = new EAttribute[] {  };
		int[] columnWidths = new int[] { 100, 200 };

		for (int i = 0; i < columnNames.length; i++) {
			TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);

			if (i == 0) {
				tvc.setLabelProvider(new ColumnLabelProvider() {
					@Override
					public String getText(Object element) {
						Article a = (Article) element;
						return Integer.toString(amountMap.get(a.getName()));
					}
				});
			} else {
				IObservableMap map = EMFProperties.value(ModelPackage.Literals.ARTICLE__NAME) 
						// TODO attention this wont be here for long  *bad-stuff* 
						// use columnAttributes[i]
						.observeDetail(cp.getKnownElements());
				tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
			}

			// set the column title & size
			tvc.getColumn().setText(columnNames[i]);
			tvc.getColumn().setWidth(columnWidths[i]);
			tvc.getColumn().setResizable(true);
		}

	}
	
	public void updateSelection(List<Article> aList){
		tableViewer.getTable().setFocus();
		selectionService.setSelection(aList);
	}

}