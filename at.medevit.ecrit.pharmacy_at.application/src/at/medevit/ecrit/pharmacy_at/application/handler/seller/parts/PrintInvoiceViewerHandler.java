package at.medevit.ecrit.pharmacy_at.application.handler.seller.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.application.part.InvoicePart;
import at.medevit.ecrit.pharmacy_at.application.part.InvoicePrescriptionOverviewPart;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
import at.medevit.ecrit.pharmacy_at.application.util.PrintInvoicePDF;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;

public class PrintInvoiceViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	private HashMap<String, Integer> amountMap;
	
	@Execute
	public void execute(@Named("commandparameter.printInvoice")
	String articleAmountMap, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		new PrintInvoicePDF(shell, amountMap, assureNoDuplicates());
		
		SampleModel.addInvoice(SampleModel.getInvoice());
		List<String> partIds = new ArrayList<String>();
		partIds.add(AppModelId.PART_PART_PRESCRIPTION);
		partIds.add(AppModelId.PART_PART_INVOICEDATA);
		partIds.add(AppModelId.PART_PART_INVOICE);
		PartUpdater.updatePart(partService, partIds);
		((InvoicePart) PartUpdater.findPart(AppModelId.PART_PART_INVOICE)).updateBinding();
		
		InvoicePrescriptionOverviewPart.updateInput();
	}
	
	@CanExecute
	public boolean canExecute(){
		if (SampleModel.getPharmacy().getCurrentUser().getRole().contains(UserRole.SELLER)) {
			amountMap =
				CommandUtil.getSelectionOfType(HashMap.class,
					selectionService.getSelection(AppModelId.PART_PART_INVOICEDATA));
			if (amountMap != null) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	private List<Article> assureNoDuplicates(){
		List<Article> listWithNoDuplicates = new ArrayList<Article>();
		boolean match = false;
		for (Article a : SampleModel.getInvoice().getArticle()) {
			for (Article article : listWithNoDuplicates) {
				if (article.getName().equals(a.getName())) {
					match = true;
				}
			}
			
			if (match == false) {
				listWithNoDuplicates.add(a);
			}
			match = false;
		}
		return listWithNoDuplicates;
	}
}