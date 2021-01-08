package com.mycom.test5.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mycom.test5.command.RegisterCommand;

public class RegisterMemberValidator implements Validator{
	private static final String REG_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String REG_NAME = "^[가-힣]*$" ;
	
	Pattern emailPattern;
	Pattern namePattern;
	
	public RegisterMemberValidator() {
		emailPattern = Pattern.compile(REG_EMAIL);
		namePattern = Pattern.compile(REG_NAME);
	}
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(RegisterMemberValidator.class);
	}
	@Override
	public void validate(Object target, Errors errors) {
		RegisterCommand member = (RegisterCommand) target;
		Matcher emailMatcher = emailPattern.matcher(member.getEmail());
		Matcher nameMatcher = namePattern.matcher(member.getName());
		if(!emailMatcher.matches()) {
			errors.rejectValue("email", "email.mismatch");
		}else if(!nameMatcher.matches()) {
			errors.rejectValue("name", "name.mismatch");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "require");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "require");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "require");
	}
	
	
}
