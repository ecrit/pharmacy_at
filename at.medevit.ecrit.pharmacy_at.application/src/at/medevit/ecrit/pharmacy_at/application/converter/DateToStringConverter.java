package at.medevit.ecrit.pharmacy_at.application.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.databinding.conversion.IConverter;

public class DateToStringConverter implements IConverter {

	@Override
	public Object getToType() {
		return String.class;
	}

	@Override
	public Object getFromType() {
		return String.class;
	}

	@Override
	public Object convert(Object fromObject) {
		DateFormat dateFormat = new SimpleDateFormat(
				"dd.MM.yyyy HH:mm:ss");
		Date date = (Date) fromObject;
		return dateFormat.format(date.getTime());
	}

}
