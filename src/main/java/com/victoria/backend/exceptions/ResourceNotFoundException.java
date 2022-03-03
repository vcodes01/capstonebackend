package com.victoria.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Exceptions are a way to handle errors and communicate with users on what kind of error that they're getting

//The Runtime Exception is the parent class in all exceptions of the Java programming language that are expected to crash or break down the program or application when they occur. 

// https://javahungry.blogspot.com/2018/10/what-is-serialversionuid-and-why-need-it.html

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
			public ResourceNotFoundException(String message) {
		super(message);
	}
}
