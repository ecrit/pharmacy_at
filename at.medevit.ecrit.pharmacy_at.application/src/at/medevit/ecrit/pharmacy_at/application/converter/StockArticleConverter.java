package at.medevit.ecrit.pharmacy_at.application.converter;

import org.eclipse.core.commands.AbstractParameterValueConverter;
import org.eclipse.core.commands.ParameterValueConversionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

public class StockArticleConverter extends AbstractParameterValueConverter {
	
	protected IEclipseContext context;
	private static StockArticleConverter instance = null;
	
	public static StockArticleConverter getInstance(){
		if (instance == null) {
			instance = new StockArticleConverter();
		}
		return instance;
	}
	
	protected StockArticleConverter(){
		super();
		if (context == null) {
			context = EclipseContextFactory.create();
		}
	}
	
	@Override
	public Object convertToObject(String parameterValue) throws ParameterValueConversionException{
		return context.get(parameterValue);
	}
	
	@Override
	public String convertToString(Object parameterValue) throws ParameterValueConversionException{
		if (parameterValue == null || parameterValue == "") {
			return "";
		}
// String result =
// context.set(result, parameterValue);
		return String.valueOf(parameterValue.hashCode());
	}
	
}
