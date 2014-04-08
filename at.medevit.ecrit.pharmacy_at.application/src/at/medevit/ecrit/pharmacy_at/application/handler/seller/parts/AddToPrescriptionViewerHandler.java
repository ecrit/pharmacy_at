package at.medevit.ecrit.pharmacy_at.application.handler.seller.parts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.dialog.PrescriptionSelectionDialog;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.Prescription;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class AddToPrescriptionViewerHandler {
	@Inject
	private ESelectionService selectionService;
	@Inject
	private EPartService partService;

	// ArtilceList TableViewer selection
	private StockArticle selection;
	private boolean prescriptionSelected = false;

	@Execute
	public void execute(
			@Named("commandparameter.addToPrescription") String stockArticle,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {

		if (prescriptionSelected) {
			Object sel = selectionService.getSelection(AppModelId.PART_PART_PRESCRIPTION);
			if (sel != null && sel instanceof Prescription) {
				addArticleAndUpdate((Prescription) sel);
			}
		} else {
			List<Prescription> prescriptions = new ArrayList<Prescription>();
			prescriptions.addAll(SampleModel.getInvoice().getPrescription());

			Prescription selectedPrescription;
			PrescriptionSelectionDialog dlg = new PrescriptionSelectionDialog(
					shell, prescriptions);
			if (dlg.open() == IDialogConstants.OK_ID) {
				if (!prescriptions.isEmpty()) {
					selectedPrescription = prescriptions.get(0);
					addArticleAndUpdate(selectedPrescription);
				}
			}
		}

		List<String> partIds = new ArrayList<String>();
		partIds.add(AppModelId.PART_PART_PRESCRIPTION);
		partIds.add(AppModelId.PART_PART_INVOICEDATA);
		partIds.add(AppModelId.PART_PART_INVOICE);
		PartUpdater.updatePart(partService, partIds);

		prescriptionSelected = false;
	}

	@CanExecute
	public boolean canExecute() {
		selection = CommandUtil.getSelectionOfType(StockArticle.class,
				selectionService.getSelection(AppModelId.PART_PART_ARTICLELIST));

		if (selection == null || !prescriptionsExist()) {
			return false;
		}
		return true;

	}

	private boolean prescriptionsExist() {
		List<Prescription> prescriptionList = SampleModel.getInvoice()
				.getPrescription();

		if (prescriptionList == null || prescriptionList.isEmpty()) {
			return false;
		}
		return true;

	}

	private void addArticleAndUpdate(Prescription p) {
		Article article = SampleModel.getValidArticleCopy(selection
				.getArticle());
		SampleModel.getInvoice().getArticle().add(article);
		p.getArticle().add(article);

		selection.setNumberOnStock(selection.getNumberOnStock() - 1);
	}

	public void setPrescriptionSelected(boolean b) {
		prescriptionSelected = b;
	}

}