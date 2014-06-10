package at.medevit.ecrit.pharmacy_at.application.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import at.medevit.ecrit.pharmacy_at.model.Article;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;

public class PropertiesPart implements IPart {
	private DataBindingContext m_bindingContext;
	protected IObservableValue element = new WritableValue(null, Article.class);
	private Text txtDescription;
	
	@Inject
	public PropertiesPart(){}
	
	@PostConstruct
	public void postConstruct(Composite parent){
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite.setLayout(new GridLayout(1, false));
		
		Label lblPropertiespart = new Label(composite, SWT.NONE);
		lblPropertiespart.setText("Article details");
		
		txtDescription = new Text(composite, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		GridData gd_txtDescription = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_txtDescription.heightHint = 100;
		txtDescription.setLayoutData(gd_txtDescription);
		
		m_bindingContext = initDataBinding();
	}
	
	@Inject
	void setSelection(@Optional
	@Named(IServiceConstants.ACTIVE_SELECTION)
	StockArticle article){
		if (article == null) {
			element.setValue(null);
		} else {
			element.setValue(article.getArticle());
		}
	}
	
	protected DataBindingContext initDataBinding(){
		DataBindingContext bindingContext = new DataBindingContext();
		
		// Bind description to txtDescription
		IObservableValue descriptionObserveValue =
			EMFObservables.observeDetailValue(Realm.getDefault(), element,
				ModelPackage.Literals.ARTICLE__DESCRIPTION);
		IObservableValue textTxtDescriptionObserveValue =
			WidgetProperties.text(SWT.Modify).observe(txtDescription);
		bindingContext.bindValue(textTxtDescriptionObserveValue, descriptionObserveValue);
		
		return bindingContext;
	}
	
	@Override
	public void updatePart(){
		// TODO Auto-generated method stub
		
	}
	
}