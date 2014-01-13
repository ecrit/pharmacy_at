package at.medevit.ecrit.pharmacy_at.application.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.application.converter.IntToStringConverter;
import at.medevit.ecrit.pharmacy_at.application.validator.NumbersOnlyValidator;
import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.Prescription;

public class PrescriptionDialog extends TitleAreaDialog {
	private DataBindingContext m_bindingContext;

	private TableViewer tableViewer;
	private Text txtNumber;
	private Text txtIssuingPractitioner;
	private boolean isSelectable = true;

	// protected IObservableValue element = new WritableValue(null,
	// Prescription.class);
	private Prescription p;
	private IObservableList input;
	private List<Article> articles;
	private List<Article> selArticles;

	public PrescriptionDialog(Shell parentShell, List<Article> articles) {
		super(parentShell);
		this.articles = articles;
		this.selArticles = new ArrayList<Article>();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Prescription Dialog");
		setMessage("Detailed prescription information",
				IMessageProvider.INFORMATION);

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		createPrescriptionNrPart(container);
		createIssuingPractitionerPart(container);
		createArticleSelectionPart(container);

		m_bindingContext = initDataBinding();
		return area;
	}

	private void createPrescriptionNrPart(Composite container) {
		Label lblPrescriptionNr = new Label(container, SWT.NONE);
		lblPrescriptionNr.setText("Prescription Number");

		txtNumber = new Text(container, SWT.BORDER);
		txtNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
	}

	private void createIssuingPractitionerPart(Composite container) {
		Label lblIssuingPractitioner = new Label(container, SWT.NONE);
		lblIssuingPractitioner.setText("Issuing Practitioner");

		txtIssuingPractitioner = new Text(container, SWT.BORDER);
		txtIssuingPractitioner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
	}

	private void createArticleSelectionPart(Composite container) {
		Label lblArticles = new Label(container, SWT.NONE);
		GridData gd_lblArticles = new GridData(SWT.LEFT, SWT.TOP, false, false,
				0, 0);
		lblArticles.setLayoutData(gd_lblArticles);
		lblArticles.setText("Prescription Articles");

		tableViewer = new TableViewer(container, SWT.CHECK | SWT.BORDER);
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setEnabled(isSelectable);
		table.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (event.detail == SWT.CHECK) {
					Article a = (Article) event.item.getData();

					if (selArticles.contains(a)) {
						selArticles.remove(a);
					} else {
						selArticles.add(a);
					}
				}
			}
		});

		TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
		// set the column title & size
		tvc.getColumn().setText("Article Name");
		tvc.getColumn().setWidth(200);
		tvc.getColumn().setResizable(false);

	}

	private void createArticleReviewPart(Composite container) {
		Label lblArticles = new Label(container, SWT.NONE);
		GridData gd_lblArticles = new GridData(SWT.LEFT, SWT.TOP, false, false,
				0, 0);
		lblArticles.setLayoutData(gd_lblArticles);
		lblArticles.setText("Prescription Articles");

		tableViewer = new TableViewer(container, SWT.BORDER);
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.NONE);
		// set the column title & size
		tvc.getColumn().setText("Article Name");
		tvc.getColumn().setWidth(200);
		tvc.getColumn().setResizable(false);
	}

	public void disableSelection() {
		isSelectable = false;
	}

	@Override
	protected void okPressed() {
		p.setNumber(Integer.parseInt(txtNumber.getText()));
		p.setIssuingPractitioner(txtIssuingPractitioner.getText());

		for (Article a : selArticles) {
			p.getArticle().add(a);
		}
		super.okPressed();
	}

	public void setPrescription(Prescription p) {
		this.p = p;
	}

	protected DataBindingContext initDataBinding() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue numberObserveValue = EMFProperties.value(
				ModelPackage.Literals.PRESCRIPTION__NUMBER).observe(p);
		IObservableValue textTxtNumberObserveValue = WidgetProperties.text(
				SWT.Modify).observe(txtNumber);
		UpdateValueStrategy numberStrategy = new UpdateValueStrategy();
		numberStrategy.setAfterConvertValidator(new NumbersOnlyValidator());
		numberStrategy.setConverter(new IntToStringConverter());
		Binding bindValue = bindingContext.bindValue(textTxtNumberObserveValue, numberObserveValue,
				null, numberStrategy);
		ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.LEFT);
		//
		IObservableValue practitionerObserveValue = EMFProperties.value(
				ModelPackage.Literals.PRESCRIPTION__ISSUING_PRACTITIONER)
				.observe(p);
		IObservableValue textTxtIssuingPractitionerObserveValue = WidgetProperties
				.text(SWT.Modify).observe(txtIssuingPractitioner);
		bindingContext.bindValue(textTxtIssuingPractitionerObserveValue,
				practitionerObserveValue);
		//
		ObservableListContentProvider cp = new ObservableListContentProvider();
		tableViewer.setContentProvider(cp);
		IObservableMap map = EMFProperties.value(
				ModelPackage.Literals.ARTICLE__NAME).observeDetail(
				cp.getKnownElements());
		tableViewer.setLabelProvider(new ObservableMapCellLabelProvider(map));
		//
		input = Properties.selfList(Article.class).observe(articles);
		tableViewer.setInput(input);
		//
		return bindingContext;
	}

}
