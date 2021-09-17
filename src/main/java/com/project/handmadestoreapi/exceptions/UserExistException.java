package com.project.handmadestoreapi.exceptions;

public class UserExistException extends RuntimeException{

	public UserExistException(String errorMessage) {
		super(errorMessage);
	}
}
