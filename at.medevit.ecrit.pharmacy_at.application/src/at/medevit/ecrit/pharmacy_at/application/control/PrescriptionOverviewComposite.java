package at.medevit.ecrit.pharmacy_at.application.control;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import at.medevit.ecrit.pharmacy_at.application.part.InvoicePrescriptionOverviewPart;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class PrescriptionOverviewComposite extends Composite {
	private static CheckboxTreeViewer viewerTree;
	
	public PrescriptionOverviewComposite(Composite parent, int style){
		super(parent, SWT.NONE);
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		setLayout(new GridLayout(2, false));
		
		viewerTree = new CheckboxTreeViewer(this, SWT.BORDER | SWT.MULTI);
		Tree tree = viewerTree.getTree();
		tree.setHeaderVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(viewerTree, SWT.NONE);
		TreeColumn trclmnPrescription = treeViewerColumn.getColumn();
		trclmnPrescription.setWidth(200);
		trclmnPrescription.setText("Prescription");
		
		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(viewerTree, SWT.NONE);
		TreeColumn trclmnPractitioner = treeViewerColumn_1.getColumn();
		trclmnPractitioner.setWidth(100);
		trclmnPractitioner.setText("Practitioner");
		
		TreeViewerColumn treeViewerColumn_4 = new TreeViewerColumn(viewerTree, SWT.NONE);
		TreeColumn trclmnPrice = treeViewerColumn_4.getColumn();
		trclmnPrice.setWidth(100);
		trclmnPrice.setText("Price");
		new Label(this, SWT.NONE);
		
		Composite compositeSelect = new Composite(this, SWT.NONE);
		compositeSelect.setLayout(new RowLayout(SWT.HORIZONTAL));
		GridData gd_compositeSelect = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_compositeSelect.heightHint = 30;
		compositeSelect.setLayoutData(gd_compositeSelect);
		
		Button btnDeselectAll = new Button(compositeSelect, SWT.CHECK);
		btnDeselectAll.setText("Deselect All");
		btnDeselectAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				viewerTree.setAllChecked(false);
				calcTotalRefund();
			}
		});
		
		Button btnSelectAll = new Button(compositeSelect, SWT.CHECK);
		btnSelectAll.setText("Select All");
		btnSelectAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				viewerTree.setAllChecked(true);
				calcTotalRefund();
			}
		});
		
		viewerTree.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event){
				if (event.getChecked()) {
					if (event.getElement() instanceof Prescription) {
						Prescription p = (Prescription) event.getElement();
						for (Article a : p.getArticle()) {
							viewerTree.setChecked(a, true);
						}
					}
				} else {
					if (event.getElement() instanceof Prescription) {
						Prescription p = (Prescription) event.getElement();
						for (Article a : p.getArticle()) {
							viewerTree.setChecked(a, false);
						}
					}
				}
				calcTotalRefund();
			}
		});
		
		PrescriptionTreeContentProvider contentProvider = new PrescriptionTreeContentProvider();
		viewerTree.setCheckStateProvider(contentProvider);
		viewerTree.setContentProvider(contentProvider);
		viewerTree.setLabelProvider(new PrescriptionTreeLabelProvider());
		viewerTree.setInput(SampleModel.getAllPrescriptions());
		viewerTree.expandAll();
	}
	
	private static void calcTotalRefund(){
		float totalRefund = 0.0f;
		Object[] checked = viewerTree.getCheckedElements();
		for (Object obj : checked) {
			if (obj instanceof Article) {
				totalRefund = totalRefund + ((Article) obj).getPrice();
			}
		}
		InvoicePrescriptionOverviewPart.updateTotalPrescription(totalRefund);
	}
	
	public static void selectPrescription(List<Prescription> prescriptions){
		viewerTree.setAllChecked(false);
		for (Prescription p : prescriptions) {
			viewerTree.setChecked(p, true);
			viewerTree.setSubtreeChecked(p, true);
			
			calcTotalRefund();
		}
	}
	
	public static void deselectAll(){
		viewerTree.setAllChecked(false);
	}
	
	public void filterPrescriptions(Date dFrom, Date dTo){
		// TODO Auto-generated method stub
		
	}
	
	public Object[] getCheckedElements(){
		return viewerTree.getCheckedElements();
	}
	
	public static void focusRelated(EList<Prescription> prescriptions){
		TreeItem[] items = new TreeItem[prescriptions.size()];
		for (int i = 0; i < prescriptions.size(); i++) {
			for (TreeItem item : viewerTree.getTree().getItems()) {
				Prescription pres = (Prescription) item.getData();
				if (pres.equals(prescriptions.get(i))) {
					items[i] = item;
				}
			}
		}
		viewerTree.getTree().setSelection(items);
	}
	
	public static void loseFocus(){
		viewerTree.getTree().deselectAll();
		
	}
}
