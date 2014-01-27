package at.medevit.ecrit.pharmacy_at.application.part.handler;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.dialog.PrescriptionSelectionDialog;
import at.medevit.ecrit.pharmacy_at.application.part.InvoiceDataPart;
import at.medevit.ecrit.pharmacy_at.application.part.InvoicePart;
import at.medevit.ecrit.pharmacy_at.application.part.PrescriptionPart;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Prescription;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class AddToPrescriptionViewerHandler {
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	// ArtilceList TableViewer selection
	private StockArticle selection;
	private boolean prescriptionSelected = false;
	
	@Execute
	public void execute(@Named("commandparameter.addToPrescription")
	String stockArticle, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		
		if (prescriptionSelected) {
			Object sel = selectionService.getSelection(Messages.getString("ID_PART_PRESCRIPTION"));
			if (sel != null && sel instanceof Prescription) {
				addArticleAndUpdate((Prescription) sel);
			}
		} else {
			List<Prescription> prescriptions = new ArrayList<Prescription>();
			prescriptions.addAll(SampleModel.getAllPrescriptionsForCurrentInvoice());
			
			Prescription selectedPrescription;
			PrescriptionSelectionDialog dlg = new PrescriptionSelectionDialog(shell, prescriptions);
			if (dlg.open() == IDialogConstants.OK_ID) {
				if (!prescriptions.isEmpty()) {
					selectedPrescription = prescriptions.get(0);
					addArticleAndUpdate(selectedPrescription);
				}
			}
		}
		MPart pPart = partService.findPart(Messages.getString("ID_PART_PRESCRIPTION"));
		PrescriptionPart prescPart = (PrescriptionPart) pPart.getObject();
		prescPart.updateTable();
		
		MPart iPart = partService.findPart(Messages.getString("ID_PART_INVOICE"));
		InvoicePart invoicePart = (InvoicePart) iPart.getObject();
		invoicePart.updateTable();
		
		MPart idPart = partService.findPart(Messages.getString("ID_PART_INVOICE_DATA"));
		InvoiceDataPart invoiceDataPart = (InvoiceDataPart) idPart.getObject();
		invoiceDataPart.updateTable();
		
		prescriptionSelected = false;
	}
	
	@CanExecute
	public boolean canExecute(){
		checkArticleListSelection();
		
		if (selection == null || !prescriptionsExist()) {
			return false;
		}
		return true;
		
	}
	
	private boolean prescriptionsExist(){
		List<Prescription> prescriptionList = SampleModel.getAllPrescriptionsForCurrentInvoice();
		
		if (prescriptionList == null || prescriptionList.isEmpty()) {
			return false;
		}
		return true;
		
	}
	
	private void checkArticleListSelection(){
		Object selection = selectionService.getSelection(Messages.getString("ID_PART_ARTICLELIST"));
		if (selection != null && selection instanceof StockArticle) {
			this.selection = (StockArticle) selection;
		} else {
			this.selection = null;
		}
		
	}
	
	private void addArticleAndUpdate(Prescription p){
		SampleModel.addArticleToPrescription(p, selection);
		SampleModel.addArticleToInvoice(selection);
		selection.setNumberOnStock(selection.getNumberOnStock() - 1);
	}
	
	public void setPrescriptionSelected(boolean b){
		prescriptionSelected = b;
	}
	
}