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
import at.medevit.ecrit.pharmacy_at.application.dialog.DeleteFromPrescriptionDialog;
import at.medevit.ecrit.pharmacy_at.application.part.InvoiceDataPart;
import at.medevit.ecrit.pharmacy_at.application.part.InvoicePart;
import at.medevit.ecrit.pharmacy_at.application.part.PrescriptionPart;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class DeleteFromInvoiceViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	@Execute
	public void execute(@Named("commandparameter.deleteFromInvocie")
	String articleToDelete, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		Article a =
			(Article) selectionService.getSelection(Messages.getString("ID_PART_INVOICE_DATA"));
		SampleModel.removeArticleFromInvoice(a);
		
		List<Prescription> relevantPrescriptions = getRelevantPrescriptions(a);
		if (!relevantPrescriptions.isEmpty()) {
			DeleteFromPrescriptionDialog dlg =
				new DeleteFromPrescriptionDialog(shell, relevantPrescriptions);
			
			if (dlg.open() == IDialogConstants.OK_ID) {
				if (!relevantPrescriptions.isEmpty()) {
					Prescription selectedPrescription = relevantPrescriptions.get(0);
					SampleModel.removeArticleFromPrescription(selectedPrescription, a);
					
					if (selectedPrescription.getArticle().isEmpty()) {
						SampleModel.deletePrescription(selectedPrescription);
					}
				}
			}
			MPart pPart = partService.findPart(Messages.getString("ID_PART_PRESCRIPTION"));
			PrescriptionPart prescPart = (PrescriptionPart) pPart.getObject();
			prescPart.updateTable();
		}
		MPart idataPart = partService.findPart(Messages.getString("ID_PART_INVOICE_DATA"));
		InvoiceDataPart invoiceDataPart = (InvoiceDataPart) idataPart.getObject();
		invoiceDataPart.updateTable();
		
		MPart iPart = partService.findPart(Messages.getString("ID_PART_INVOICE"));
		InvoicePart invoicePart = (InvoicePart) iPart.getObject();
		invoicePart.updateTable();
	}
	
	private List<Prescription> getRelevantPrescriptions(Article a){
		List<Prescription> prescriptions = SampleModel.getAllPrescriptionsForCurrentInvoice();
		List<Prescription> relevantPrescriptions = new ArrayList<Prescription>();
		
		for (Prescription p : prescriptions) {
			List<Article> articles = p.getArticle();
			for (Article arti : articles) {
				if (arti.getName().equals(a.getName())) {
					relevantPrescriptions.add(p);
					break;
				}
			}
		}
		return relevantPrescriptions;
	}
	
	@CanExecute
	public boolean canExecute(){
		Object selection =
			selectionService.getSelection(Messages.getString("ID_PART_INVOICE_DATA"));
		if (selection != null && selection instanceof Article) {
			return true;
		} else {
			return false;
		}
	}
	
}