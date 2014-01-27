package at.medevit.ecrit.pharmacy_at.application.part;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.databinding.EMFObservables;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.application.User;
import at.medevit.ecrit.pharmacy_at.application.UserRole;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class UserDataPart {
	private CheckboxTableViewer tableViewer;
	private DataBindingContext m_bindingContext;
	protected IObservableValue element = new WritableValue(null, Article.class);

	// InputDialog txtPassword;

	private Text txtPassword;

	@Inject
	public UserDataPart() {
		// TODO Your code here
	}

	@PostConstruct
	public void postConstruct(final Composite parent) {
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

		Label txtUsername = new Label(composite, SWT.NONE);
		txtUsername.setText("User1");
		GridData gd_txtUsername = new GridData(SWT.FILL, SWT.TOP, true, false,
				1, 1);
		txtUsername.setLayoutData(gd_txtUsername);

		// password
		Label lblPassword = new Label(composite, SWT.NONE);
		GridData gd_lblPassword = new GridData(SWT.LEFT, SWT.TOP, false, false,
				1, 1);
		lblPassword.setLayoutData(gd_lblPassword);
		lblPassword.setText("Password: ");
		txtPassword = new Text(composite, SWT.BORDER);
		// txtPassword = new InputDialog(null, "", "Enter 5-8 characters",
		// "initial value", new LengthValidator());
		GridData gd_txtPassword = new GridData(SWT.FILL, SWT.TOP, true, false,
				1, 1);
		// gd_txtPassword.horizontalSpan = 5;
		// gd_txtPassword.heightHint = 50;
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
				MessageDialog.openInformation(parent.getShell(),
						"Save User Data", "User data saved... TODO ");
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
					// SampleModel.revertInvoice(invoice);
					// invoice = SampleModel.getInvoice();
					// updateTable();
					// updateConnectedParts();
				}
			}
		});

		m_bindingContext = initDataBinding();
	}

	private void initTableViewer(Composite composite) {

		tableViewer = CheckboxTableViewer.newCheckList(composite, SWT.SINGLE
				| SWT.BORDER | SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(false);
		table.setLinesVisible(false);

		initColumns(tableViewer);

		// xxxxxxxxxxx
		// TableColumnLayout rolesColumnLayout = new TableColumnLayout();
		// composite.setLayout(rolesColumnLayout);
		// TableColumn tc = new TableColumn(table, SWT.NONE);
		//
		// rolesColumnLayout.setColumnData(tc, new ColumnWeightData(1));

		// xxxxxxxxxxx

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());

		// set model

		IObservableList input = Properties.selfList(User.class).observe(
				new ArrayList<UserRole>(Arrays.asList(UserRole.values())));
		tableViewer.setInput(input);

	}

	private void initColumns(CheckboxTableViewer tv) {
		TableViewerColumn tvc = new TableViewerColumn(tv, SWT.NONE);
		tvc.getColumn().setWidth(100);

		// bind the feature and setup a table column
		// IObservableMap map = EMFProperties.value(path).observeDetail(
		// cp.getKnownElements());
		// tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));

		tvc.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				UserRole ur = (UserRole) element;
				return ur.getLiteral();
			}
		});
	}

	@Inject
	void setSelection(
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) StockArticle article) {
		if (article == null) {
			element.setValue(null);
		} else {
			element.setValue(article.getArticle());
		}
	}

	protected DataBindingContext initDataBinding() {
		DataBindingContext bindingContext = new DataBindingContext();

		// Bind description to txtDescription
		IObservableValue descriptionObserveValue = EMFObservables
				.observeDetailValue(Realm.getDefault(), element,
						ModelPackage.Literals.ARTICLE__DESCRIPTION);
		IObservableValue textTxtDescriptionObserveValue = WidgetProperties
				.text(SWT.Modify).observe(txtPassword);
		bindingContext.bindValue(textTxtDescriptionObserveValue,
				descriptionObserveValue);

		return bindingContext;
	}

}
