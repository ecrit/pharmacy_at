package at.medevit.ecrit.pharmacy_at.application.validator;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class NumbersOnlyValidator implements IValidator {

	@Override
	public IStatus validate(Object value) {
		if (value instanceof String) {
			String s = (String) value;
			if (s.matches("[0-9]*")) {
				return ValidationStatus.ok();
			}
		}
		return ValidationStatus.error(value.toString() + " is not a valid number");
	}

}
