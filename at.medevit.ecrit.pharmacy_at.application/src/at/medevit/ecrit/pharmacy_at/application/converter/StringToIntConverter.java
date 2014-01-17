package at.medevit.ecrit.pharmacy_at.application.converter;

import org.eclipse.core.databinding.conversion.IConverter;

public class StringToIntConverter implements IConverter {

	@Override
	public Object getToType() {
		return int.class;
	}

	@Override
	public Object getFromType() {
		return String.class;
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject instanceof String) {
			String string = (String) fromObject;
			return Integer.parseInt(string);
		}
		return fromObject;
	}
}
