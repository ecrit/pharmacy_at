package at.medevit.ecrit.pharmacy_at.application.handler.seller;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.part.InvoiceDataPart;
import at.medevit.ecrit.pharmacy_at.application.part.InvoicePart;
import at.medevit.ecrit.pharmacy_at.application.part.PrescriptionPart;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;

public class CancelInvoiceHandler {
	
	@Inject
	private EPartService partService;
	
	@Execute
	public void execute(){
		SampleModel.revertCurrentInvoice();
		
		MPart idPart = partService.findPart(Messages.getString("ID_PART_INVOICE_DATA"));
		InvoiceDataPart invoiceDataPart = (InvoiceDataPart) idPart.getObject();
		invoiceDataPart.updateTable();
		
		MPart pPart = partService.findPart(Messages.getString("ID_PART_PRESCRIPTION"));
		PrescriptionPart prescPart = (PrescriptionPart) pPart.getObject();
		prescPart.updateTable();
		
		MPart iPart = partService.findPart(Messages.getString("ID_PART_INVOICE"));
		InvoicePart invoicePart = (InvoicePart) iPart.getObject();
		invoicePart.updateTable();
	}
	
	@CanExecute
	public boolean canExecute(){
		return true;
	}
	
}