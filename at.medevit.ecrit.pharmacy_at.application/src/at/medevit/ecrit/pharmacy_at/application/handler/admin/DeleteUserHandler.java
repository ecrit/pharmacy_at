package at.medevit.ecrit.pharmacy_at.application.handler.admin;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.User;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;

public class DeleteUserHandler {
	
	@Inject
	private ESelectionService selectionService;
	private User selection;
	
	@Execute
	public void execute(@Named("commandparameter.deleteUser") String userToDelete,
		@Named(IServiceConstants.ACTIVE_SHELL) Shell shell){
// User user = (User) selectionService.getSelection(AppModelId.PART_PART_USER);
		User currentUser = SampleModel.getPharmacy().getCurrentUser();
		boolean wasLoggedIn = false;
		
		if (selection.equals(currentUser)) {
			wasLoggedIn = true;
			boolean retVal =
				MessageDialog
					.openQuestion(
						shell,
						"You are deleting your user!",
						"The user you selected is the one you're currently logged in with.\n"
							+ "Are you sure you'd like to remove your account?\n\n"
							+ "When confirming this dialog your user gets deleted and the application will be closed!");
			
			if (retVal == false)
				return;
		}
		
		SampleModel.getPharmacy().getStaff().remove(selection);
		selectionService.setSelection(SampleModel.getPlainNewUser());
		
		if (wasLoggedIn)
			System.exit(-1);
	}
	
	@CanExecute
	public boolean canExecute(){
		if (SampleModel.getPharmacy().getCurrentUser().getRole().contains(UserRole.SYSADMIN)) {
			this.selection =
				CommandUtil.getSelectionOfType(User.class,
					selectionService.getSelection(AppModelId.PART_PART_USER));
			if (selection != null)
				return true;
		}
		return false;
	}
}