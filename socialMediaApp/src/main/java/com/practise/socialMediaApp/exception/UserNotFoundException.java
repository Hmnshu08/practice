package com.practise.socialMediaApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//returns the not found http status code
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	//constructor which accepts a message and passes it to super class
	public UserNotFoundException(String message) {
		super(message);
	}
}
