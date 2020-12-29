package com.mycom.myapp.spring;

public class DuplicateMemberException extends RuntimeException{
	public DuplicateMemberException(String message) {
		super(message);
	}
}
