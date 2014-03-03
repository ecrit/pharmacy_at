package at.medevit.ecrit.pharmacy_at.application.handler.seller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.Messages;
import at.medevit.ecrit.pharmacy_at.application.dialog.PrescriptionDialog;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class AddPrescriptionHandler {
	@Inject
	private EPartService partService;
	
	private List<Article> invoiceArticles;
	
	@Execute
	public void execute(@Optional
	@Named("commandparameter.addAsPrescriptionArticle")
	String allInvoiceArticles, @Named(IServiceConstants.ACTIVE_SHELL)
	Shell shell){
		
		Prescription p = ModelFactory.eINSTANCE.createPrescription();
		PrescriptionDialog dlg = new PrescriptionDialog(shell, invoiceArticles);
		dlg.setPrescription(p);
		
		if (dlg.open() == IDialogConstants.OK_ID) {
			if (p != null) {
				SampleModel.getInvoice().getPrescription().add(p);
				
				List<String> partIds = new ArrayList<String>();
				partIds.add(Messages.getString("ID_PART_PRESCRIPTION"));
				partIds.add(Messages.getString("ID_PART_INVOICE"));
				partIds.add(Messages.getString("ID_PART_INVOICE_DATA"));
				PartUpdater.updatePart(partService, partIds);
			}
		}
	}
	
	@CanExecute
	public boolean canExecute(){
		// get all articles placed on the invoice
		invoiceArticles = SampleModel.getInvoice().getArticle();
		
		if (invoiceArticles != null && !invoiceArticles.isEmpty()) {
			List<Article> notPrescripted = SampleModel.getNotYetPrescriptedArticle();
			if (notPrescripted.isEmpty()) {
				this.invoiceArticles = null;
				return false;
			} else {
				this.invoiceArticles = notPrescripted;
				return true;
			}
		} else {
			this.invoiceArticles = null;
			return false;
		}
	}
}