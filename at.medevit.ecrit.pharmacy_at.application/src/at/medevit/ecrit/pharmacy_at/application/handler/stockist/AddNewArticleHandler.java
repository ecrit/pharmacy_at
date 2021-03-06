package at.medevit.ecrit.pharmacy_at.application.handler.stockist;

import java.util.Collections;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.application.dialog.StockArticleDialog;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;

public class AddNewArticleHandler {
	@Inject
	private EPartService partService;
	
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		
		StockArticleDialog dlg = new StockArticleDialog(shell, null);
		dlg.open();
		
		PartUpdater.updatePart(partService,
			Collections.singletonList(AppModelId.PART_PART_ARTICLELIST));
	}
	
	@CanExecute
	public boolean canExecute(){
		if (SampleModel.getPharmacy().getCurrentUser().getRole().contains(UserRole.STOCKIST)) {
			return true;
		}
		return false;
	}
	
}