package com.hegde.hosalli.TO_DO_FullStack.ToDoExceptions;

import java.time.LocalDate;

public class ErrorDetails {
	
	private String exceptionMessage;
	private LocalDate time;
	
	public ErrorDetails(String exceptionMessage, LocalDate time) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.time = time;
	}
	
	
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public LocalDate getTime() {
		return time;
	}
	public void setTime(LocalDate time) {
		this.time = time;
	}
	

}

