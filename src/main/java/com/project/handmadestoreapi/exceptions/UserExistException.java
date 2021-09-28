package com.project.handmadestoreapi.exceptions;

/**
 * The {@code UserExistException} class is a custom exception, which indicates that we already have user with these credentials.
 */
public class UserExistException extends RuntimeException{

	public UserExistException(String errorMessage) {
		super(errorMessage);
	}
}
