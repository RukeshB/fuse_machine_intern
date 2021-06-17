package com.springdataproject.librarymanagementsystem.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements ConstraintValidator<ContactNumber, Long>{

	@Override
    public void initialize(ContactNumber contactNumber) {
    }

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		String contactField = String.valueOf(value);
		return contactField != null && (contactField.length() == 10);
	}

}
