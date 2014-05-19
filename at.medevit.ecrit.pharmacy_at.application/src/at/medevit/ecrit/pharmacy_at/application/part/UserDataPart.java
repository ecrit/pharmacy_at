package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.application.AppModelId;
import at.medevit.ecrit.pharmacy_at.application.ApplicationPackage;
import at.medevit.ecrit.pharmacy_at.application.User;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.application.handler.admin.AddNewUserHandler;
import at.medevit.ecrit.pharmacy_at.application.handler.admin.SaveUserHandler;
import at.medevit.ecrit.pharmacy_at.application.util.CommandUtil;
import at.medevit.ecrit.pharmacy_at.core.SampleModel;

public class UserDataPart implements IPart {
	
	private CheckboxTableViewer tableViewer;
	protected IObservableValue element = new WritableValue(null, User.class);
	private DataBindingContext m_bindingContext;
	private User tmpUser;
	private User recentAdded;
	
	private Text txtUsername;
	private Text txtPassword;
	
	@Inject
	private ESelectionService selectionService;
	@Inject
	private IEclipseContext context;
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;
	
	@Inject
	public UserDataPart(){}
	
	@PostConstruct
	public void postConstruct(final Composite parent){
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		Group udGroup = new Group(composite, SWT.NONE);
		udGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout gl_userData = new GridLayout(2, false);
		gl_userData.marginLeft = 10;
		gl_userData.marginRight = 10;
		udGroup.setLayout(gl_userData);
		udGroup.setText("User Data");
		
		// username
		Label lblUsername = new Label(udGroup, SWT.NONE);
		GridData gd_lblUsername = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		lblUsername.setLayoutData(gd_lblUsername);
		lblUsername.setText("Username: ");
		
		txtUsername = new Text(udGroup, SWT.SINGLE | SWT.BORDER);
		GridData gd_txtUsername = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		txtUsername.setLayoutData(gd_txtUsername);
		// txtUsername.setEnabled(false);
		
		// password
		Label lblPassword = new Label(udGroup, SWT.NONE);
		GridData gd_lblPassword = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		lblPassword.setLayoutData(gd_lblPassword);
		lblPassword.setText("Password: ");
		
		txtPassword = new Text(udGroup, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
		// txtPassword = new InputDialog(null, "", "Enter 5-8 characters",
		// "initial value", new LengthValidator());
		GridData gd_txtPassword = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		txtPassword.setLayoutData(gd_txtPassword);
		
		// Roles with CheckboxTableViewer
		Label lblRoles = new Label(udGroup, SWT.NONE);
		GridData gd_lblRles = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		lblRoles.setLayoutData(gd_lblRles);
		lblRoles.setText("Roles: ");
		
		initTableViewer(udGroup);
		
		// indent
		new Label(udGroup, SWT.NONE);
		
		// Buttons
		Composite buttonComposite = new Composite(udGroup, SWT.NONE);
		buttonComposite.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false, 2, 1));
		buttonComposite.setLayout(new GridLayout(2, false));
		
		// save button
		Button btnSave = new Button(buttonComposite, SWT.PUSH);
		GridData gd_btnSave = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnSave.widthHint = 80;
		btnSave.setLayoutData(gd_btnSave);
		btnSave.setText("Save");
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				// empty User Name
				if (txtUsername.getText().isEmpty()) {
					MessageDialog.openInformation(parent.getShell(), "Error: Empty User Name",
						"User name must not be empty");
				} else {
					// check if username exists in case it's a new user
					boolean exists = false;
					if (tmpUser.getName().isEmpty()) {
						for (User u : SampleModel.getPharmacy().getStaff()) {
							if (u.getName().equals(txtUsername.getText())) {
								exists = true;
							}
						}
						if (exists) {
							MessageDialog.openInformation(parent.getShell(),
								"Error: User Name Exists",
								"User name must not be identical to an already exiting user name");
							return;
						}
						
					}
					callSaveUserCommand();
				}
			}
		});
		
		// cancel button
		Button btnCancel = new Button(buttonComposite, SWT.PUSH);
		GridData gd_btnCancel = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnCancel.widthHint = 80;
		btnCancel.setLayoutData(gd_btnCancel);
		btnCancel.setText("Cancel");
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				if (MessageDialog.openConfirm(parent.getShell(), "Discard Changes",
					"All changes will be lost!")) {
					resetFields();
				}
			}
		});
		m_bindingContext = initDataBinding();
	}
	
	private void initTableViewer(Composite composite){
		tableViewer =
			CheckboxTableViewer.newCheckList(composite, SWT.SINGLE | SWT.BORDER
				| SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(false);
		table.setLinesVisible(false);
		table.setEnabled(true);
		
		tableViewer.setContentProvider(new ArrayContentProvider());
		// create a column for the first name
		TableViewerColumn colUserRole = new TableViewerColumn(tableViewer, SWT.NONE);
		colUserRole.getColumn().setWidth(100);
		colUserRole.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element){
				UserRole role = (UserRole) element;
				return role.getName();
			}
		});
		
		tableViewer.setInput(UserRole.values());
	}
	
	// calls appropriate save command (either add new user or save user)
	public void callSaveUserCommand(){
		// save new user (add new user to Users List)
		if (tmpUser.getName().isEmpty()) {
			User newUser = (User) element.getValue();
			newUser.getRole().clear();
			for (TableItem item : tableViewer.getTable().getItems()) {
				if (item.getChecked()) {
					newUser.getRole().add((UserRole) item.getData());
				}
			}
			
			selectionService.setSelection(newUser);
			CommandUtil.setContextAndServices(context, commandService, handlerService);
			CommandUtil.manuallyCallCommand(AppModelId.COMMAND_COMMAND_ADDNEWUSER,
				AppModelId.COMMANDPARAMETER_COMMANDPARAMETER_NEWUSER, "new user",
				new AddNewUserHandler());
			recentAdded = newUser;
		} else {
			// save existing user (overwrite user's data)
			List<UserRole> usersRoles = new ArrayList<UserRole>();
			for (TableItem item : tableViewer.getTable().getItems()) {
				if (item.getChecked()) {
					usersRoles.add((UserRole) item.getData());
				}
			}
			((User) element.getValue()).getRole().clear();
			((User) element.getValue()).getRole().addAll(usersRoles);
			
			CommandUtil.setContextAndServices(context, commandService, handlerService);
			CommandUtil.manuallyCallCommand(AppModelId.COMMAND_COMMAND_SAVEUSER,
				"commandparameter.saveUser", "user to save", new SaveUserHandler());
		}
	}
	
	// set back form fields to original data (last save or new user)
	public void resetFields(){
		txtUsername.setText(tmpUser.getName());
		txtPassword.setText(tmpUser.getPassword());
		((User) element.getValue()).getRole().clear();
		((User) element.getValue()).getRole().addAll(tmpUser.getRole());
	}
	
	@Inject
	void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) User user){
		if (tableViewer != null && !tableViewer.getTable().isDisposed()) {
			if (recentAdded != null && user != null && recentAdded.getName().equals(user.getName())) {
				return;
			}
			if (user == null) {
				element.setValue(null);
			} else {
				tmpUser = EcoreUtil.copy(user);
				element.setValue(user);
				setCheckedRoles();
			}
		}
	}
	
	// set check boxes for role fields
	private void setCheckedRoles(){
		for (TableItem item : tableViewer.getTable().getItems()) {
			if (element.getValue() != null) {
				List<UserRole> usersRoles = ((User) element.getValue()).getRole();
				item.setChecked(usersRoles.contains((UserRole) item.getData()));
			}
		}
	}
	
	protected DataBindingContext initDataBinding(){
		DataBindingContext bindingContext = new DataBindingContext();
		
		// Bind username to txtUsername
		IObservableValue usernameObserveValue =
			EMFObservables.observeDetailValue(Realm.getDefault(), element,
				ApplicationPackage.Literals.USER__NAME);
		IObservableValue txtUsernameObserveValue =
			WidgetProperties.text(SWT.Modify).observe(txtUsername);
		bindingContext.bindValue(txtUsernameObserveValue, usernameObserveValue);
		
		IObservableValue passwordObserveValue =
			EMFObservables.observeDetailValue(Realm.getDefault(), element,
				ApplicationPackage.Literals.USER__PASSWORD);
		IObservableValue txtPasswordObserveValue =
			WidgetProperties.text(SWT.Modify).observe(txtPassword);
		bindingContext.bindValue(txtPasswordObserveValue, passwordObserveValue);
		
		return bindingContext;
	}
	
	@Override
	public void updatePart(){}
	
}
