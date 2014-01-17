package at.medevit.ecrit.pharmacy_at.application.converter;

import org.eclipse.core.commands.AbstractParameterValueConverter;
import org.eclipse.core.commands.ParameterValueConversionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.EDataTypeImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import at.medevit.ecrit.pharmacy_at.application.SampleModel;
import at.medevit.ecrit.pharmacy_at.model.ModelFactory;
import at.medevit.ecrit.pharmacy_at.model.ModelPackage;
import at.medevit.ecrit.pharmacy_at.model.StockArticle;
import at.medevit.ecrit.pharmacy_at.model.impl.StockArticleImpl;

public class StockArticleConverter extends AbstractParameterValueConverter {

	protected IEclipseContext context;
	
	public StockArticleConverter() {
		super();
		context = EclipseContextFactory.create();
	}

	@Override
	public Object convertToObject(String parameterValue)
			throws ParameterValueConversionException {

		return context.get(parameterValue);
	}

	@Override
	public String convertToString(Object parameterValue)
			throws ParameterValueConversionException {
		String result = String.valueOf(parameterValue.hashCode());
		context.set(result, parameterValue);
		return result;
	}

}
