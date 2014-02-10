package at.medevit.ecrit.pharmacy_at.application.part.handler;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.dialog.StockArticleDialog;
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
		Object selection = selectionService.getSelection(Messages.getString("ID_PART_ARTICLELIST"));
		if (selection != null && selection instanceof StockArticle) {
			this.selection = (StockArticle) selection;
			return true;
		} else {
			this.selection = null;
			return false;
		}
	}
	
}