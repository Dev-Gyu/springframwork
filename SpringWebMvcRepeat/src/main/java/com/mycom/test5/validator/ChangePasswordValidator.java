package com.mycom.test5.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ChangePasswordValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ChangePasswordValidator.class);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword", "require");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "require");
	}
}
