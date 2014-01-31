package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.application.ApplicationFactory;
import at.medevit.ecrit.pharmacy_at.application.SampleApplication;
import at.medevit.ecrit.pharmacy_at.application.User;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.application.Users;

public class UserDataPart {
	static ApplicationFactory factory = ApplicationFactory.eINSTANCE;

	private CheckboxTableViewer tableViewer;
	private DataBindingContext m_bindingContext;

	// represents the original data of the currently managed user without
	// unsaved entries from form fields
	protected IObservableValue selUser = new WritableValue(null, User.class);
	Users users;
	final User emptyUser = factory.createUser();

	private Text txtUsername;
	private Text txtPassword;

	@Inject
	private ESelectionService selectionService;

	@Inject
	public UserDataPart() {
		// TODO Your code here
	}

	@PostConstruct
	public void postConstruct(final Composite parent) {
		users = SampleApplication.getUsers();

		emptyUser.setName("");
		emptyUser.setPassword("");
		emptyUser.getRole().add(null);

		// intialize selUser for first usage if admin wants to create a new user
		// without pressing the "new user" button
		selUser.setValue(emptyUser);

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		composite.setLayout(new GridLayout(2, false));

		Label lblUserpart = new Label(composite, SWT.NONE);
		lblUserpart.setText("User Data");
		new Label(composite, SWT.NONE);

		// username
		Label lblUsername = new Label(composite, SWT.NONE);
		lblUsername.setText("Username: ");
		GridData gd_lblUsername = new GridData(SWT.LEFT, SWT.TOP, false, false,
				1, 1);

		txtUsername = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gd_txtUsername = new GridData(SWT.FILL, SWT.TOP, true, false,
				1, 1);
		txtUsername.setLayoutData(gd_txtUsername);
		// txtUsername.setEnabled(false);

		// password
		Label lblPassword = new Label(composite, SWT.NONE);
		GridData gd_lblPassword = new GridData(SWT.LEFT, SWT.TOP, false, false,
				1, 1);
		lblPassword.setLayoutData(gd_lblPassword);
		lblPassword.setText("Password: ");
		txtPassword = new Text(composite, SWT.SINGLE | SWT.BORDER
				| SWT.PASSWORD);
		// txtPassword = new InputDialog(null, "", "Enter 5-8 characters",
		// "initial value", new LengthValidator());
		GridData gd_txtPassword = new GridData(SWT.FILL, SWT.TOP, true, false,
				1, 1);
		txtPassword.setLayoutData(gd_txtPassword);

		// Roles with CheckboxTableViewer
		Label lblRoles = new Label(composite, SWT.NONE);
		GridData gd_lblRles = new GridData(SWT.LEFT, SWT.TOP, false, false, 1,
				1);
		lblRoles.setLayoutData(gd_lblRles);
		lblRoles.setText("Roles: ");

		initTableViewer(composite);

		// indent
		new Label(composite, SWT.NONE);

		// Buttons
		Composite buttonComposite = new Composite(composite, SWT.NONE);
		buttonComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 1, 1));
		buttonComposite.setLayout(new GridLayout(2, false));

		// save button
		Button btnSave = new Button(buttonComposite, SWT.PUSH);
		btnSave.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		btnSave.setText("Save");
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// empty User Name
				if (txtUsername.getText().equals("")) {
					MessageDialog.openInformation(parent.getShell(),
							"Error: Empty User Name",
							"User name must not be empty");
				} else {
					// user name exists
					Boolean exists = false;
					for (User u : users.getUsers()) {
						if (u.getName().equals(txtUsername.getText())) {
							exists = true;
						}
					}
					// check for existing user names only for new user entries
					// (selUser empty)
					if ((((User) selUser.getValue()).getName().equals(emptyUser
							.getName())) && (exists == true)) {
						MessageDialog.openInformation(parent.getShell(),
								"Error: User Name Exists",
								"User name must not be identical to an already exiting user name");
					}
					// everything alright: save data
					else {
						saveUser();
						MessageDialog.openInformation(parent.getShell(),
								"Save User Data", "User data saved");
					}
				}

			}
		});

		// cancel button
		Button btnCancel = new Button(buttonComposite, SWT.PUSH);
		btnCancel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		btnCancel.setText("Cancel");
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (MessageDialog.openConfirm(parent.getShell(),
						"Discard Changes", "All changes will be lost!")) {
					resetFields();
				}
			}
		});

		m_bindingContext = initDataBinding();
		if (selUser.getValue() != null)
			setCheckedRoles();
	}

	private void initTableViewer(Composite composite) {
		tableViewer = CheckboxTableViewer.newCheckList(composite, SWT.SINGLE
				| SWT.BORDER | SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(false);
		table.setLinesVisible(false);
		table.setEnabled(true);

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());

		IObservableList input = Properties.selfList(User.class).observe(
				new ArrayList<UserRole>(Arrays.asList(UserRole.values())));
		tableViewer.setInput(input);

	}

	// set check boxes for role fields
	private void setCheckedRoles() {
		for (TableItem item : tableViewer.getTable().getItems()) {
			if (((User) selUser.getValue()).getRole().contains(
					(UserRole) item.getData())) {
				item.setChecked(true);
			} else
				item.setChecked(false);
		}
	}

	// Save user data to data store
	public void saveUser() {
		System.out.println("saveUser: " + selUser);
		// save new user (add new user to Users List)
		if ((selUser == null)
				|| (((User) selUser.getValue()).getName().equals(emptyUser
						.getName()))) {
			User newUser = factory.createUser();
			newUser.setName(txtUsername.getText());
			newUser.setPassword(txtPassword.getText());
			for (TableItem item : tableViewer.getTable().getItems()) {
				if (item.getChecked()) {
					newUser.getRole().add((UserRole) item.getData());
				}
			}
			users.getUsers().add(newUser);
			selUser.setValue(newUser);

			// test
			for (User u : users.getUsers()) {
				System.out.println("---------Current user: " + u);
			}

		}
		// save existing user (overwrite user's data)
		else {
			((User) selUser.getValue()).setName(txtUsername.getText());
			((User) selUser.getValue()).setPassword(txtPassword.getText());
			for (TableItem item : tableViewer.getTable().getItems()) {
				if (!(((User) selUser.getValue()).getRole()
						.contains((UserRole) item.getData()))
						&& item.getChecked()) {
					((User) selUser.getValue()).getRole().add(
							(UserRole) item.getData());
				}
				if (((User) selUser.getValue()).getRole().contains(
						(UserRole) item.getData())
						&& !item.getChecked()) {
					((User) selUser.getValue()).getRole().remove(
							(UserRole) item.getData());
				}

			}
		}

		selectionService.setSelection(selUser);

	}

	// set back form fields to original data (last save or new user)
	public void resetFields() {
		txtUsername.setText(((User) selUser.getValue()).getName());
		txtPassword.setText(((User) selUser.getValue()).getPassword());
		setCheckedRoles();
	}

	// inject selected user from UserPart: selection from user list
	@Inject
	void setSelection(
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) User user) {
		// no user selected: no data displayed
		if (user != null) {
			if (user.getName().equals(emptyUser.getName())) {
				selUser.setValue(user);
				txtUsername.setText("");
				txtPassword.setText("");
				for (TableItem item : tableViewer.getTable().getItems()) {
					item.setChecked(false);
				}
			}
			// display data of selected user
			else {
				selUser.setValue(user);
				txtUsername.setText(((User) selUser.getValue()).getName());
				txtPassword.setText(((User) selUser.getValue()).getPassword());
				setCheckedRoles();
			}
		}
	}

	protected DataBindingContext initDataBinding() {
		DataBindingContext bindingContext = new DataBindingContext();

		// // Bind username to txtUsername
		// IObservableValue usernameObserveValue = EMFObservables
		// .observeDetailValue(Realm.getDefault(), selUser,
		// ApplicationPackage.Literals.USER__NAME);
		// IObservableValue textTxtUsernameObserveValue = WidgetProperties.text(
		// SWT.Modify).observe(txtUsername);
		// bindingContext.bindValue(textTxtUsernameObserveValue,
		// usernameObserveValue);
		//
		// // Bind password to txtPassword
		// IObservableValue passwordObserveValue = EMFObservables
		// .observeDetailValue(Realm.getDefault(), selUser,
		// ApplicationPackage.Literals.USER__PASSWORD);
		// IObservableValue textTxtPasswordObserveValue = WidgetProperties.text(
		// SWT.Modify).observe(txtPassword);
		// bindingContext.bindValue(textTxtPasswordObserveValue,
		// passwordObserveValue);

		return bindingContext;
	}

}
