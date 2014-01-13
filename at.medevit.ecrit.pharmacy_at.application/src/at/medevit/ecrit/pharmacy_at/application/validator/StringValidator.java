package at.medevit.ecrit.pharmacy_at.application.validator;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class StringValidator implements IValidator {

	@Override
	public IStatus validate(Object value) {
		if (value instanceof String) {
			return ValidationStatus.ok();
		}
		return ValidationStatus.error(value.toString() + " is not a string");
	}

}
