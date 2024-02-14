package com.blueyonder.bookapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookAppExceptionHandler {

	@ExceptionHandler(CustomerNotFoundExceptions.class)
	public ResponseEntity<String> handleCustomerNotFoundException() {
		return new ResponseEntity<String>("customer doesn't exist",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotfoundException.class)
	public String handleUserNotFoundException() {
		return "Username not exist";
	}
	@ExceptionHandler(PasswordMismatchException.class)
	public String handlePasswordMismatchException() {
		return "Password doesn't exist";
	}
	
	
}
