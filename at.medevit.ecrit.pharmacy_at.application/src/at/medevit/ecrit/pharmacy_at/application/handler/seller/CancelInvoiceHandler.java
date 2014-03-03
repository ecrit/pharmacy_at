package at.medevit.ecrit.pharmacy_at.application.handler.seller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import at.medevit.ecrit.pharmacy_at.application.Messages;
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
		partIds.add(Messages.getString("ID_PART_PRESCRIPTION"));
		partIds.add(Messages.getString("ID_PART_INVOICE_DATA"));
		partIds.add(Messages.getString("ID_PART_INVOICE"));
		PartUpdater.updatePart(partService, partIds);
		((InvoicePart) PartUpdater.findPart(Messages.getString("ID_PART_INVOICE"))).updateBinding();
	}
	
	@CanExecute
	public boolean canExecute(){
		return true;
	}
	
}