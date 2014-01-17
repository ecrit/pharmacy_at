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

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ArticleAvailability;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Prescription;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class PrescriptionPart {

	private TableViewer tableViewer;
	private IObservableList input;
	private List<Prescription> prescriptions; 
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

	@Inject
	public PrescriptionPart() {
		prescriptions = SampleModel.getInvoice().getPrescription();
	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Label lblPrescriptionpart = new Label(parent, SWT.NONE);
		lblPrescriptionpart.setText("PrescriptionPart");

		initTableViewer(parent);
		menuService.registerContextMenu(tableViewer.getTable(), Messages.ID_POPUP_PRESCRIPTION);
	}

	@EcritDrop(command="at.medevit.ecrit.pharmacy_at.application.command.addPrescritption")
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
							InvoiceDataPart invoiceDataPart = (InvoiceDataPart) partService
									.findPart(Messages.ID_PART_INVOICE_DATA).getObject();

							if (event.item != null) {
								selectionService.setSelection((Prescription) event.item.getData());
								
								Command cmd = commandService
										.getCommand(Messages.ID_CMD_ADD_TO_PRESCRIPTION);
								ParameterizedCommand pCmd = new ParameterizedCommand(
										cmd, null);

								// only execute if command can be executed
								if (handlerService.canExecute(pCmd)) {
									handlerService.executeHandler(pCmd);
								}
//								p.getArticle().add(a);								
//								SampleModel.getInvoice().getArticle().add(a);
								
							} else {
								StockArticle sa = (StockArticle) selectionService.getSelection(Messages.ID_PART_ARTICLELIST);
								List<Article> tmpArticleList = new ArrayList<Article>();
								tmpArticleList.add(sa.getArticle());
								
								invoiceDataPart.updateSelection(tmpArticleList);

								Command cmd = commandService
										.getCommand(Messages.ID_CMD_ADD_PRESCRIPTION);
								ParameterizedCommand pCmd = new ParameterizedCommand(
										cmd, null);

								// only execute if command can be executed
								if (handlerService.canExecute(pCmd)) {
									handlerService.executeHandler(pCmd);
								}
								sa.setNumberOnStock(sa.getNumberOnStock() - 1);
							}
							invoiceDataPart.updateTable();
						}
					}
				});

		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				Command cmd = commandService
						.getCommand(Messages.ID_CMD_OPEN_PRESCRIPTION);
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
		input = Properties.selfList(Prescription.class).observe(prescriptions);
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
			prescriptions = SampleModel.getInvoice().getPrescription();
			tableViewer.refresh();
		}
	}
	
	
	public void clearPrescriptions() {
		prescriptions.clear();
	}
}