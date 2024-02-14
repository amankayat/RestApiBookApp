package com.blueyonder.bookapp.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;

public class CustomerNotFoundExceptions extends RuntimeException{

	public CustomerNotFoundExceptions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerNotFoundExceptions(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CustomerNotFoundExceptions(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerNotFoundExceptions(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomerNotFoundExceptions(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerNotFoundExceptions(HttpStatusCode statusCode, HttpHeaders headers)  {
		// TODO Auto-generated constructor stub
	}

	
	
}
