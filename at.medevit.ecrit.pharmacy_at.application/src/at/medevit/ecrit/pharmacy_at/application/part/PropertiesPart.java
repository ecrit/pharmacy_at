package at.medevit.ecrit.pharmacy_at.application.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;

public class PropertiesPart {
	private DataBindingContext m_bindingContext;
	private Article article = ModelFactory.eINSTANCE.createArticle();;
	private Text txtDescription;

	@Inject
	public PropertiesPart() {
	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		composite.setLayout(new GridLayout(2, false));

		Label lblPropertiespart = new Label(composite, SWT.NONE);
		lblPropertiespart.setText("Properties");
		new Label(composite, SWT.NONE);

		// description
		Label lblDescription = new Label(composite, SWT.NONE);
		GridData gd_lblDescription = new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 1);
		lblDescription.setLayoutData(gd_lblDescription);
		lblDescription.setText("Further description: ");

		txtDescription = new Text(composite, SWT.BORDER);
		GridData gd_txtDescription = new GridData(SWT.FILL, SWT.TOP, true,
				false, 1, 1);
		gd_txtDescription.heightHint = 100;
		txtDescription.setLayoutData(gd_txtDescription);

		m_bindingContext = initDataBinding();
	}

	public void setArticle(Article article) {
		if (m_bindingContext != null) {
			m_bindingContext.dispose();
		}
		this.article = article;
		m_bindingContext = initDataBinding();
	}

	protected DataBindingContext initDataBinding() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue descriptionObserveValue = EMFProperties.value(
				ModelPackage.Literals.ARTICLE__DESCRIPTION).observe(article);
		IObservableValue textTxtDescriptionObserveValue = WidgetProperties
				.text(SWT.Modify).observe(txtDescription);
		bindingContext.bindValue(textTxtDescriptionObserveValue,
				descriptionObserveValue);

		return bindingContext;
	}
}