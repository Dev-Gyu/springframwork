package com.mycom.test5.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mycom.test5.command.LoginCommand;

public class LoginValidator implements Validator{
	private static final String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private Pattern pattern;
	
	public LoginValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(LoginValidator.class);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		LoginCommand loginCommand = (LoginCommand)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "require");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "require");
		Matcher matcher = pattern.matcher(loginCommand.getEmail());
		if(matcher.matches()) {
			return;
		}
		errors.reject("login.validate");
	}
	
}
