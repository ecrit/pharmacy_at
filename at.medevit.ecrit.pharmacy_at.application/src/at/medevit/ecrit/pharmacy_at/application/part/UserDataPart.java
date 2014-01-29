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

import at.medevit.ecrit.pharmacy_at.application.SampleApplication;
import at.medevit.ecrit.pharmacy_at.application.User;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.application.Users;

public class UserDataPart {
	private CheckboxTableViewer tableViewer;
	private DataBindingContext m_bindingContext;
	protected IObservableValue selUser = new WritableValue(null, User.class);
	Users users;

	// InputDialog txtPassword;

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
				saveUser();
				MessageDialog.openInformation(parent.getShell(),
						"Save User Data", "User data saved");

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

	private void setCheckedRoles() {
		// System.out.println("setCheckedRoles: "
		// + tableViewer.getTable().getItems());
		for (TableItem item : tableViewer.getTable().getItems()) {
			// System.out.println("----Item: " + item);

			if (((User) selUser.getValue()).getRole().contains(
					(UserRole) item.getData())) {
				item.setChecked(true);
			} else
				item.setChecked(false);
		}
	}

	public void saveUser() {
		((User) selUser.getValue()).setName(txtUsername.getText());
		((User) selUser.getValue()).setPassword(txtPassword.getText());
		for (TableItem item : tableViewer.getTable().getItems()) {
			System.out.println("----Item: " + item);

			// if (!(((User) selUser.getValue()).getRole()
			// .contains((UserRole) item.getData())) && item.getChecked()) {
			// ((User) selUser.getValue()).getRole().add(
			// (UserRole) item.getData());
			// }
			// if (((User) selUser.getValue()).getRole().contains(
			// (UserRole) item.getData())
			// && !item.getChecked()) {
			// ((User) selUser.getValue()).getRole().remove(
			// (UserRole) item.getData());
			// }

		}
		Users myUsers = (Users) users;
		if (users != null) {
			for (User u : myUsers.getUsers()) {
				System.out.println("############Current user: " + u);
			}
		}

		selectionService.setSelection(myUsers);

	}

	public void resetFields() {
		txtUsername.setText(((User) selUser.getValue()).getName());
		txtPassword.setText(((User) selUser.getValue()).getPassword());
		setCheckedRoles();
	}

	@Inject
	void setSelection(
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) User user) {
		System.out.println("User in setSelection (User Data): " + user);
		if (user == null) {
			selUser.setValue(null);
		} else {
			selUser.setValue(user);
			txtUsername.setText(((User) selUser.getValue()).getName());
			txtPassword.setText(((User) selUser.getValue()).getPassword());
			setCheckedRoles();
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
