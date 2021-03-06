package at.medevit.ecrit.pharmacy_at.application.converter;

import org.eclipse.core.databinding.conversion.IConverter;

public class IntToStringConverter implements IConverter {

	@Override
	public Object getToType() {
		return String.class;
	}

	@Override
	public Object getFromType() {
		return int.class;
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject instanceof Integer) {
			int value = (int) fromObject;
			return Integer.toString(value);
		}
		return fromObject;
	}
}
