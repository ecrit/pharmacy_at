package at.medevit.ecrit.pharmacy_at.application.handler.clerk.parts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.application.dialog.ReportDialog;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.Report;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class CheckInventoryViewerHandler {
	
	@Inject
	private ESelectionService selectionService;
	
	private List<Object> checked;
	private List<StockArticle> inconsitentArticle;
	
	@Execute
	public void execute(@Named("commandparameter.checkInventory")
	String checkedArticles, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		List<StockArticle> stockArticles = SampleModel.getStock().getArticles();
		
		if (Arrays.equals(checked.toArray(), stockArticles.toArray())) {
			MessageDialog.openInformation(shell, "Congrats", "The inventory has no inconsitency!");
		} else {
			inconsitentArticle = new ArrayList<StockArticle>();
			for (StockArticle sa : stockArticles) {
				if (!checked.contains(sa)) {
					inconsitentArticle.add(sa);
				}
			}
			
			boolean agreed =
				MessageDialog.openQuestion(shell, "Report",
					"Would you like to report the inconsistency in the inventory?");
			
			if (agreed) {
				openReportDialog(shell);
			}
		}
	}
	
	private void openReportDialog(Shell shell){
		Report report = ModelFactory.eINSTANCE.createReport();
		ReportDialog dlg = new ReportDialog(shell, report);
		report.setTitle("Inventory inconsistency");
		
		StringBuilder sb = new StringBuilder();
		for (StockArticle sa : inconsitentArticle) {
			sb.append(sa.getArticle().getName());
			sb.append("\n");
		}
		report.setText(sb.toString());
		
		if (dlg.open() == IDialogConstants.OK_ID) {
			SampleModel.addReport(report);
		}
	}
	
	@CanExecute
	public boolean canExecute(){
		if (SampleModel.getPharmacy().getCurrentUser().getRole().contains(UserRole.CLERK)) {
			Object selection = selectionService.getSelection(AppModelId.PART_PART_INVENTORY);
			if (selection != null && selection instanceof Object[]) {
				this.checked = Arrays.asList((Object[]) selection);
				return true;
			} else {
				this.checked = null;
				return false;
			}
		}
		this.checked = null;
		return false;
	}
	
}