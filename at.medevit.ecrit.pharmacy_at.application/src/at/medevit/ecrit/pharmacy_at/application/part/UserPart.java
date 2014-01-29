package at.medevit.ecrit.pharmacy_at.application.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

import at.medevit.ecrit.pharmacy_at.application.ApplicationFactory;
import at.medevit.ecrit.pharmacy_at.application.SampleApplication;
import at.medevit.ecrit.pharmacy_at.application.User;

public class UserPart {
	static ApplicationFactory factory = ApplicationFactory.eINSTANCE;

	private TableViewer tableViewer;
	StructuredSelection userSelection;
	IObservableList users;

	private DataBindingContext m_bindingContext;
	private User selUser = null;

	@Inject
	private ESelectionService selectionService;

	@Inject
	public UserPart() {
		// TODO Your code here
	}

	@PostConstruct
	public void postConstruct(final Composite parent) {
		//
		final User newUser = factory.createUser();
		newUser.setName("");
		newUser.setPassword("");
		newUser.getRole().add(null);

		Composite composite = new Composite(parent, SWT.NONE);
		// composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
		// 1, 1));
		composite.setLayout(new GridLayout(2, false));

		Label lblUserpart = new Label(composite, SWT.NONE);
		lblUserpart.setText("User Management");
		new Label(composite, SWT.NONE);

		// indent
		new Label(composite, SWT.NONE);

		// New User button
		Composite newBComposite = new Composite(composite, SWT.NONE);
		newBComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 1, 1));
		newBComposite.setLayout(new GridLayout(1, false));

		Button btnNew = new Button(newBComposite, SWT.PUSH);
		btnNew.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		btnNew.setText("   New User   ");
		btnNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectionService.setSelection(newUser);
			}
		});

		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		// Users
		Label lblUsers = new Label(composite, SWT.NONE);
		GridData gd_lblUsers = new GridData(SWT.FILL, SWT.TOP, true, false, 1,
				1);
		lblUsers.setLayoutData(gd_lblUsers);
		lblUsers.setText("Choose User: ");

		initTableViewer(composite);

		// new Label(composite, SWT.NONE);

		// indent
		new Label(composite, SWT.NONE);

		// Delete User button
		Composite delBComposite = new Composite(composite, SWT.NONE);
		delBComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 1, 1));
		delBComposite.setLayout(new GridLayout(1, false));

		Button btnDelete = new Button(delBComposite, SWT.PUSH);
		btnDelete.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		btnDelete.setText("  Delete User  ");

		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (selUser == null) {
					System.out.println("No user selected");

				} else {
					if (MessageDialog.openConfirm(
							parent.getShell(),
							"Delete User",
							"Are you sure you want to delete the selected user?\n"
									+ selUser.getName()
									+ "\n The correponding user data will be lost!")) {
						SampleApplication.deleteUser(selUser);
						selectionService.setSelection(newUser);

						updateTable();
					}
				}
			}
		});

		// m_bindingContext = initDataBinding();
	}

	private void initTableViewer(Composite composite) {
		tableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.V_SCROLL);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(false);
		table.setLinesVisible(false);

		initColumns(tableViewer);

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {

					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						userSelection = (StructuredSelection) event
								.getSelection();
						selUser = (User) userSelection.getFirstElement();
						selectionService.setSelection(selUser);
					}
				});

		// set model
		users = Properties.selfList(User.class).observe(
				SampleApplication.getUsers().getUsers());
		tableViewer.setInput(users);

	}

	private void initColumns(TableViewer tv) {
		TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
		tvc.getColumn().setWidth(100);

		// bind the feature and setup a table column
		// IObservableMap map = EMFProperties.value(path).observeDetail(
		// cp.getKnownElements());
		// tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));

		tvc.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				User user = (User) element;
				return user.getName();
			}
		});
	}

	public void updateTable() {
		if (tableViewer != null) {
			// SampleApplication.getUsers().getUsers() not required, because
			// users is observable
			tableViewer.refresh();
			tableViewer.getTable().getParent().pack();
		}
	}

	// protected DataBindingContext initDataBinding() {
	// DataBindingContext bindingContext = new DataBindingContext();
	//
	// // Bind description to txtDescription
	// IObservableValue descriptionObserveValue = EMFObservables
	// .observeDetailValue(Realm.getDefault(), element,
	// ModelPackage.Literals.ARTICLE__DESCRIPTION);
	// IObservableValue textTxtDescriptionObserveValue = WidgetProperties
	// .text(SWT.Modify).observe(txtDescription);
	// bindingContext.bindValue(textTxtDescriptionObserveValue,
	// descriptionObserveValue);
	//
	// return bindingContext;
	// }

}