package com.hegde.hosalli.TO_DO_FullStack.ToDoExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TodoIlligalArgumentException extends Exception {

	public TodoIlligalArgumentException(String msg) {
		super(msg);
	}
}
