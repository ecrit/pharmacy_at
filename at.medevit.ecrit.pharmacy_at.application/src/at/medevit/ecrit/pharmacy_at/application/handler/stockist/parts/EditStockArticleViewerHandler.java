package at.medevit.ecrit.pharmacy_at.application.handler.stockist.parts;

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
import at.medevit.ecrit.pharmacy_at.application.dialog.StockArticleDialog;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class EditStockArticleViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	private StockArticle selection;
	
	@Execute
	public void execute(@Named("commandparameter.editStockArticle")
	String stockArticleToEdit, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		System.out.println(selection.getNumberOnStock());
		StockArticleDialog dlg = new StockArticleDialog(shell, selection);
		int retval = dlg.open();
		
		System.out.println(selection.getNumberOnStock());
	}
	
	@CanExecute
	public boolean canExecute(){
		if (SampleModel.getPharmacy().getCurrentUser().getRole().contains(UserRole.STOCKIST)) {
			selection =
				CommandUtil.getSelectionOfType(StockArticle.class,
					selectionService.getSelection(AppModelId.PART_PART_ARTICLELIST));
			if (selection != null) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
}