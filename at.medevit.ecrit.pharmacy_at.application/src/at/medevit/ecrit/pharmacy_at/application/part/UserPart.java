package at.medevit.ecrit.pharmacy_at.application.part;

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
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.application.SampleApplication;
import at.medevit.ecrit.pharmacy_at.application.User;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class UserPart {
	private TableViewer tableViewer;

	private DataBindingContext m_bindingContext;
	protected IObservableValue element = new WritableValue(null, Article.class);
	private Text txtDescription;

	@Inject
	public UserPart() {
		// TODO Your code here
	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		// composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
		// 1, 1));
		composite.setLayout(new GridLayout(2, false));

		Label lblUserpart = new Label(composite, SWT.NONE);
		lblUserpart.setText("User Management");
		new Label(composite, SWT.NONE);

		// description
		Label lblDescription = new Label(composite, SWT.NONE);
		GridData gd_lblDescription = new GridData(SWT.FILL, SWT.TOP, true,
				false, 1, 1);
		lblDescription.setLayoutData(gd_lblDescription);
		lblDescription.setText("Choose User: ");

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

		m_bindingContext = initDataBinding();
	}

	private void initTableViewer(Composite composite) {
		tableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.V_SCROLL);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		initColumns(tableViewer);

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());

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
				.text(SWT.Modify).observe(txtDescription);
		bindingContext.bindValue(textTxtDescriptionObserveValue,
				descriptionObserveValue);

		return bindingContext;
	}

}