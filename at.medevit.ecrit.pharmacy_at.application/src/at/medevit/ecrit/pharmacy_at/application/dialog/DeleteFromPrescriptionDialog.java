package at.medevit.ecrit.pharmacy_at.application.dialog;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class DeleteFromPrescriptionDialog extends TitleAreaDialog {
	
	private List<Prescription> prescriptions;
	private Prescription selectedPrescription;
	private TableViewer tableViewer;
	private boolean notClosable = false;
	
	public DeleteFromPrescriptionDialog(Shell parentShell, List<Prescription> prescriptions,
		boolean isSingleInvoiceArticle){
		super(parentShell);
		this.prescriptions = prescriptions;
		this.notClosable = isSingleInvoiceArticle;
		
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		super.createButtonsForButtonBar(parent);
		if (notClosable) {
			getButton(IDialogConstants.CANCEL_ID).setEnabled(false);
		}
	}
	
	@Override
	protected Control createDialogArea(Composite parent){
		setTitle("Article used in prescription");
		setMessage("Select prescription from which article should be deleted",
			IMessageProvider.INFORMATION);
		
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		createTableViewerPart(area);
		return area;
	}
	
	private void createTableViewerPart(Composite container){
		tableViewer = new TableViewer(container, SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
		final Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				if (!(event.getSelection().equals(StructuredSelection.EMPTY))) {
					IStructuredSelection selection =
						(IStructuredSelection) tableViewer.getSelection();
					Prescription p = (Prescription) selection.getFirstElement();
					
					if (p.equals(selectedPrescription)) {
						selectedPrescription = null;
						tableViewer.setSelection(StructuredSelection.EMPTY, true);
					} else {
						selectedPrescription = p;
					}
				}
			}
		});
		
		TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
		tvc.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element){
				Prescription p = (Prescription) element;
				StringBuilder sb = new StringBuilder();
				for (Article a : p.getArticle()) {
					sb.append(a.getName());
					sb.append(", ");
				}
				return "Nr: " + p.getNumber() + " | " + sb.toString();
			}
		});
		// set the column title & size
		tvc.getColumn().setText("Prescription");
		tvc.getColumn().setWidth(300);
		tvc.getColumn().setResizable(false);
		
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setInput(prescriptions);
	}
	
	@Override
	protected void okPressed(){
		prescriptions.clear();
		if (selectedPrescription != null) {
			prescriptions.add(selectedPrescription);
		}
		super.okPressed();
	}
	
	@Override
	protected boolean canHandleShellCloseEvent(){
		if (notClosable) {
			return false;
		}
		return true;
	}
}
