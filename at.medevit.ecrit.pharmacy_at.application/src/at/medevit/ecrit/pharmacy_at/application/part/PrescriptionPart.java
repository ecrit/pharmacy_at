package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;
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
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.e4.ui.workbench.swt.modeling.EMenuService;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

import at.medevit.ecrit.pharmacy_at.application.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ArticleAvailability;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class PrescriptionPart {

	private TableViewer tableViewer;
	private IObservableList input;

	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;
	@Inject
	private EPartService partService;
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EMenuService menuService;

	private static final String ID_ADD_PRESCRIPTION = "at.medevit.ecrit.pharmacy_at.application.popupmenu.addPrescritption";
	private static final String ID_ADD_PRESCRIPTION_CMD = "at.medevit.ecrit.pharmacy_at.application.command.addPrescritption";
	private static final String ID_OPEN_PRESCRIPTION_CMD = "at.medevit.ecrit.pharmacy_at.application.command.openPrescritption";
	private static final String ID_BILL_PART = "at.medevit.ecrit.pharmacy_at.application.part.bill";

	@Inject
	public PrescriptionPart() {
	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Label lblPrescriptionpart = new Label(parent, SWT.NONE);
		lblPrescriptionpart.setText("PrescriptionPart");

		initTableViewer(parent);
		menuService.registerContextMenu(tableViewer.getTable(),
				ID_ADD_PRESCRIPTION);
	}

	private void initTableViewer(Composite composite) {
		tableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

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
						if (TextTransfer.getInstance().isSupportedType(event.currentDataType)) {
							Article a = convertStringToArticle((String)event.data);
							BillPart billPart = (BillPart) partService
									.findPart(ID_BILL_PART).getObject();

							if (event.item != null) {
								Prescription p = (Prescription) event.item
										.getData();
								p.getArticle().add(a);								
								SampleModel.getInvoice().getArticle().add(a);
							} else {
								tableViewer.getTable().setFocus();
								List<Article> tmpArticleList = new ArrayList<Article>();
								tmpArticleList.add(a);
								
								billPart.updateSelection(tmpArticleList);

								Command cmd = commandService
										.getCommand(ID_ADD_PRESCRIPTION_CMD);
								ParameterizedCommand pCmd = new ParameterizedCommand(
										cmd, null);

								// only execute if command can be executed
								if (handlerService.canExecute(pCmd)) {
									handlerService.executeHandler(pCmd);
								}
							}
							billPart.updateTable();
						}
					}
				});

		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				Command cmd = commandService
						.getCommand(ID_OPEN_PRESCRIPTION_CMD);
				ParameterizedCommand pCmd = new ParameterizedCommand(cmd, null);

				// only execute if command can be executed
				if (handlerService.canExecute(pCmd)) {
					handlerService.executeHandler(pCmd);
				}
			}
		});

		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {

					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						IStructuredSelection sel = (IStructuredSelection) event
								.getSelection();
						Prescription p = (Prescription) sel.getFirstElement();
						if (p != null) {
							tableViewer.getTable().setFocus();
							selectionService.setSelection(p);
						}
					}
				});
		
		// set model
		input = Properties.selfList(Article.class).observe(SampleModel.getInvoice().getPrescription());
		tableViewer.setInput(input);
	}

	private void initColumns(ObservableListContentProvider cp) {
		String[] columnNames = new String[] { "Number", "Practitioner" };
		EAttribute[] columnAttributes = new EAttribute[] {
				ModelPackage.Literals.PRESCRIPTION__NUMBER,
				ModelPackage.Literals.PRESCRIPTION__ISSUING_PRACTITIONER };
		int[] columnWidths = new int[] { 100, 150 };

		for (int i = 0; i < columnNames.length; i++) {
			TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);

			// bind values
			IObservableMap map = EMFProperties.value(columnAttributes[i])
					.observeDetail(cp.getKnownElements());
			tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));

			// set the column title & size
			tvc.getColumn().setText(columnNames[i]);
			tvc.getColumn().setWidth(columnWidths[i]);
			tvc.getColumn().setResizable(true);
		}
	}

	public void updateTable() {
		if (tableViewer != null) {
			tableViewer.refresh();
		}
	}
	
	/**
	 * Convert the string with article information to an actual article 
	 * @param value article.toString()
	 * @return article
	 */
	protected Article convertStringToArticle(String value) {
		Article a = ModelFactory.eINSTANCE.createArticle();
		int beginIdx = value.indexOf("name: ");
		beginIdx = value.indexOf(" ", beginIdx) +1;
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
		a.setAvailability(ArticleAvailability.get(value.substring(beginIdx, endIdx)));
		
		beginIdx = endIdx + 2; 
		beginIdx = value.indexOf(" ", beginIdx) + 1;
		endIdx = value.indexOf(")", beginIdx);
		a.setPrice(Float.parseFloat(value.substring(beginIdx, endIdx)));
		
		return a;
	}
}