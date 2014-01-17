 
package at.medevit.ecrit.pharmacy_at.application.handler.seller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.SampleModel;
import at.medevit.ecrit.pharmacy_at.application.dialog.DeleteFromPrescriptionDialog;
import at.medevit.ecrit.pharmacy_at.application.part.InvoiceDataPart;
import at.medevit.ecrit.pharmacy_at.application.part.InvoicePart;
import at.medevit.ecrit.pharmacy_at.application.part.PrescriptionPart;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Prescription;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class DeleteFromInvoiceHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		Article a = (Article) selectionService.getSelection(Messages.ID_PART_INVOICE_DATA);		
		SampleModel.getInvoice().getArticle().remove(a);

		
		List<Prescription> prescriptions = SampleModel.getInvoice().getPrescription();
		List<Prescription> relevantPrescriptions = new ArrayList<Prescription>();
		for (Prescription p : prescriptions) {
			List<Article> articles = p.getArticle();
			for (Article arti : articles) {
				if(arti.getName().equals(a.getName())){
					relevantPrescriptions.add(p);
				}
			}
		}
		DeleteFromPrescriptionDialog dlg = new DeleteFromPrescriptionDialog(shell, relevantPrescriptions);
		int retVal = dlg.open();
		if (retVal == IDialogConstants.OK_ID) {
			if(!relevantPrescriptions.isEmpty()){
				relevantPrescriptions.get(0).getArticle().remove(a);
			}
			System.out.println(relevantPrescriptions.get(0));
		}
		
		MPart idataPart = partService.findPart(Messages.ID_PART_INVOICE_DATA);
		InvoiceDataPart invoiceDataPart = (InvoiceDataPart) idataPart.getObject();
		invoiceDataPart.updateTable();
		
		//TODO also update prescriptions if article is on prescription as well
		MPart iPart = partService.findPart(Messages.ID_PART_INVOICE);
		InvoicePart invoicePart = (InvoicePart) iPart.getObject();
		invoicePart.updateTable();
		
		MPart pPart = partService.findPart(Messages.ID_PART_PRESCRIPTION);
		PrescriptionPart prescPart = (PrescriptionPart) pPart.getObject();
		prescPart.updateTable();
	}

	@CanExecute
	public boolean canExecute() {
		Object selection = selectionService.getSelection(Messages.ID_PART_INVOICE_DATA);
		if (selection != null && selection instanceof Article) {
			return true;
		} else {
			return false;
		}
	}
		
}