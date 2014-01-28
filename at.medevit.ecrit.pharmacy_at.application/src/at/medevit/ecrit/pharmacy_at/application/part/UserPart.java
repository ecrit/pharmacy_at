package at.medevit.ecrit.pharmacy_at.application.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
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
import at.medevit.ecrit.pharmacy_at.model.Article;

public class UserPart {
	static ApplicationFactory factory = ApplicationFactory.eINSTANCE;

	private TableViewer tableViewer;
	StructuredSelection userSelection;

	private DataBindingContext m_bindingContext;
	protected IObservableValue element = new WritableValue(null, Article.class);

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

		// New user button
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

		// final List userList = new List(composite, SWT.BORDER | SWT.MULTI
		// | SWT.V_SCROLL);
		// // composite.setSize(300, 20);
		//
		// for (User user : SampleApplication.getUsers().getUsers()) {
		// System.out.println("User: " + user);
		// userList.add(user.getName());
		// }
		//
		// userList.addSelectionListener(new SelectionListener() {
		//
		// public void widgetSelected(SelectionEvent event) {
		// int[] selections = userList.getSelectionIndices();
		// String outText = "";
		// for (int loopIndex = 0; loopIndex < selections.length; loopIndex++)
		// outText += selections[loopIndex] + " ";
		// System.out.println("You selected: " + outText);
		// }
		//
		// public void widgetDefaultSelected(SelectionEvent event) {
		// int[] selections = userList.getSelectionIndices();
		// String outText = "";
		// for (int loopIndex = 0; loopIndex < selections.length; loopIndex++)
		// outText += selections[loopIndex] + " ";
		// System.out.println("You selected: " + outText);
		// }
		// });

		initTableViewer(composite);

		// new Label(composite, SWT.NONE);

		// indent
		new Label(composite, SWT.NONE);

		// New user button
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
				selectionService.setSelection(newUser);
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
						User user = (User) userSelection.getFirstElement();
						selectionService.setSelection(user);
					}
				});

		// set model
		IObservableList input = Properties.selfList(User.class).observe(
				SampleApplication.getUsers().getUsers());
		tableViewer.setInput(input);

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
				User u = (User) element;
				return u.getName();
			}
		});
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