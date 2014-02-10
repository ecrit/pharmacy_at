package at.medevit.ecrit.pharmacy_at.application.handler.stockist;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.dialog.StockArticleDialog;
import at.medevit.ecrit.pharmacy_at.application.part.ArticleListPart;

public class AddNewArticleHandler {
	@Inject
	private IEclipseContext context;
	@Inject
	private EPartService partService;
	
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		
		StockArticleDialog dlg = new StockArticleDialog(shell, null);
		dlg.open();
		
		MPart part = partService.findPart(Messages.getString("ID_PART_ARTICLELIST"));
		ArticleListPart alPart = (ArticleListPart) part.getObject();
		alPart.updatePart();
	}
	
	@CanExecute
	public boolean canExecute(){
		return true;
	}
	
}