package at.medevit.ecrit.pharmacy_at.application.handler.seller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.part.InvoicePart;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;

public class CancelInvoiceHandler {
	
	@Inject
	private EPartService partService;
	
	@Execute
	public void execute(){
		SampleModel.revertCurrentInvoice();
		
		List<String> partIds = new ArrayList<String>();
		partIds.add(AppModelId.PART_PART_PRESCRIPTION);
		partIds.add(AppModelId.PART_PART_INVOICEDATA);
		partIds.add(AppModelId.PART_PART_INVOICE);
		PartUpdater.updatePart(partService, partIds);
		((InvoicePart) PartUpdater.findPart(AppModelId.PART_PART_INVOICE)).updateBinding();
	}
	
	@CanExecute
	public boolean canExecute(){
		// TODO only allow in seller tab/ for seller user
		return true;
	}
	
}