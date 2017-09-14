package net.ycod3r.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.ycod3r.custom.annotations.Telephone;

public class ContactNumberValidator implements ConstraintValidator<Telephone, String> {

	@Override
	public void initialize(Telephone telephone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
		// TODO Auto-generated method stub
		return contactField == null || contactField.length()> 8 && contactField.matches("[0-9]+");
	}


}
