package at.medevit.ecrit.pharmacy_at.application.part.handler;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.part.ArticleListPart;
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
			SampleModel.deleteFromStock(selection); // TODO check if article has to be deleted
// separately
			MPart part = partService.findPart(Messages.getString("ID_PART_ARTICLELIST"));
			ArticleListPart alPart = (ArticleListPart) part.getObject();
			alPart.updatePart();
		}
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