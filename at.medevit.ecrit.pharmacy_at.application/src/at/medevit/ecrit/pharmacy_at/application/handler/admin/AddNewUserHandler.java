package at.medevit.ecrit.pharmacy_at.application.handler.admin;

import java.util.Collections;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.User;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.application.util.PartUpdater;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;

public class AddNewUserHandler {
	@Inject
	private EPartService partService;
	@Inject
	private ESelectionService selectionService;
	
	private User newUser;
	
	@Execute
	public void execute(
		@Named(AppModelId.COMMANDPARAMETER_COMMANDPARAMETER_NEWUSER) String userToAdd,
		@Named(IServiceConstants.ACTIVE_SHELL) Shell shell){
		SampleModel.addStaffMember(EcoreUtil.copy(newUser));
		SampleModel.update();
		
		PartUpdater.updatePart(partService, Collections.singletonList(AppModelId.PART_PART_USER));
		PartUpdater.updatePart(partService,
			Collections.singletonList(AppModelId.PART_PART_USERDATA));
		
		MessageDialog.openInformation(shell, "User added", "The new user [" + newUser.getName()
			+ "] was successfully added to the system.");
	}
	
	@CanExecute
	public boolean canExecute(){
		if (SampleModel.getPharmacy().getCurrentUser().getRole().contains(UserRole.SYSADMIN)) {
			this.newUser =
				CommandUtil.getSelectionOfType(User.class,
					selectionService.getSelection(AppModelId.PART_PART_USERDATA));
			if (newUser != null)
				return true;
		}
		return false;
	}
	
}