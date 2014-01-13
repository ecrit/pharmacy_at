package at.medevit.ecrit.pharmacy_at.application.handler.seller;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.SampleModel;
import at.medevit.ecrit.pharmacy_at.application.part.PrescriptionPart;
import at.medevit.ecrit.pharmacy_at.model.Prescription;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class AddToPrescriptionHandler {
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;

	private static final String ID_ARTICLE_PART = "at.medevit.ecrit.pharmacy_at.application.part.articlelist";
	private static final String ID_PRESCRIPTION_PART = "at.medevit.ecrit.pharmacy_at.application.part.prescription";

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		StockArticle a = (StockArticle) selectionService
				.getSelection(ID_ARTICLE_PART);
		a.setNumberOnStock(a.getNumberOnStock() - 1);

		MPart part = partService.findPart(ID_PRESCRIPTION_PART);
		PrescriptionPart presPart = (PrescriptionPart) part.getObject();
		Prescription p = (Prescription) selectionService
				.getSelection(ID_PRESCRIPTION_PART);

		p.getArticle().add(a.getArticle());
		SampleModel.getInvoice().getArticle().add(a.getArticle());

	}

	@CanExecute
	public boolean canExecute() {
		Object selection = selectionService.getSelection(ID_ARTICLE_PART);
		if (selection != null && selection instanceof StockArticle) {
			return true;
		} else {
			return false;
		}
	}
}