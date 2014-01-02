package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
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

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Bill;
import at.medevit.ecrit.pharmacy_at.model.Date;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;

public class BillPart {
	private Bill bill;
	private TableViewer tableViewer;
	private IObservableList input;

	@Inject
	public BillPart() {
		bill = ModelFactory.eINSTANCE.createBill();
		
		Date date = ModelFactory.eINSTANCE.createDate();
		date.setDate(new java.util.Date());
		bill.setDateTime(date);
		
		int testNr = 1;
		bill.setNumber(testNr);
	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite.setLayout(new GridLayout(1, false));
		
		Label lblBillpart = new Label(composite, SWT.NONE);
		GridData gd_lblBillpart = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_lblBillpart.widthHint = 400;
		lblBillpart.setLayoutData(gd_lblBillpart);
		lblBillpart.setText("BillPart");

		// some billing information in the header
		Composite headerComposite = new Composite(composite, SWT.NONE);
		GridData gd_headerComposite = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_headerComposite.widthHint = 397;
		headerComposite.setLayoutData(gd_headerComposite);
		headerComposite.setLayout(new GridLayout(1, true));
		
		Label lblDate = new Label(headerComposite, SWT.RIGHT);
		lblDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblDate.setText("Date: \t 02.01.2014");

		Label lblBillNumber = new Label(headerComposite, SWT.RIGHT);
		GridData gd_lblBillNumber = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_lblBillNumber.widthHint = 390;
		lblBillNumber.setLayoutData(gd_lblBillNumber);
		lblBillNumber.setText("BillNumber: \t " + bill.getNumber());
//		lblDate.setText(bill.getDateTime().toString());
		
		// initialises the tableviewer
		initTableViewer(composite);
		
		// payment button
		Button btnPay = new Button(composite, SWT.PUSH);
		btnPay.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnPay.setText("Cash up");
		btnPay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO implement payment button functionality
				super.widgetSelected(e);
			}
		});

	}
	
	private void initTableViewer(Composite composite){
		tableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		ObservableListContentProvider cp = new ObservableListContentProvider();
		initColumns(cp);
		input = Properties.selfList(Article.class).observe(new ArrayList<Article>());
		tableViewer.setContentProvider(cp);

		// add drag support
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
						
						input.add(a);						
						tableViewer.refresh();
					}
				});

		// set model
		tableViewer.setInput(input);
	}

	private void initColumns(ObservableListContentProvider cp) {
		String[] columnNames = new String[] { "Name" };
		EAttribute[] columnAttributes = new EAttribute[] { ModelPackage.Literals.ARTICLE__NAME };
		int[] columnWidths = new int[] { 200 };

		for (int i = 0; i < columnNames.length; i++) {
			TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);

			IObservableMap map = EMFProperties.value(columnAttributes[i])
					.observeDetail(cp.getKnownElements());
			tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));

			// set the column title & size
			tvc.getColumn().setText(columnNames[i]);
			tvc.getColumn().setWidth(columnWidths[i]);
			tvc.getColumn().setResizable(true);
		}
	}
}