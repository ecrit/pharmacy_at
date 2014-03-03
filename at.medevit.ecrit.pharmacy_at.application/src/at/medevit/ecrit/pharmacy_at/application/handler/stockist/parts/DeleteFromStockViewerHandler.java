package at.medevit.ecrit.pharmacy_at.application.handler.stockist.parts;

import java.util.Collections;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class DeleteFromStockViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;
	
	private StockArticle selection;
	
	@Execute
	public void execute(@Named("commandparameter.deleteStockArticle")
	String delStockArticle, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		boolean retVal =
			MessageDialog.openQuestion(shell, "Delete StockArticle",
				"Are you sure you want to delete " + selection.getArticle().getName() + "?");
		
		if (retVal) {
			SampleModel.removeFromStock(selection);
			PartUpdater.updatePart(partService,
				Collections.singletonList(Messages.getString("ID_PART_ARTICLELIST")));
		}
	}
	
	@CanExecute
	public boolean canExecute(){
		// TODO only allow in stockist tab/ for stockist user
		selection =
			CommandUtil.getSelectionOfType(StockArticle.class,
				selectionService.getSelection(Messages.getString("ID_PART_ARTICLELIST")));
		if (selection != null) {
			return true;
		} else {
			return false;
		}
	}
	
}