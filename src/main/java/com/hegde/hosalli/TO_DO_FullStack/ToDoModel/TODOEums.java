package com.hegde.hosalli.TO_DO_FullStack.ToDoModel;

public enum TODOEums {
	
	CREATED(0,"CREATED"),
	ERROR_IN_CREATE(1,"ERROR IN CREATION"),
	
	UPDATED(1000,"UPDATED"),
	ERROR_IN_UPDATE(1001,"ERROR IN UPDATE"),
	
	DELETED(2000,"DELETED"),
	ERROR_IN_DELETE(2001,"ERROR IN DELETE"),
	
	LOGIN_SUCCESS(0,"LOGIN_SUCCESS");
	
	int status;
	String msg;
	
	public int getStatus() {
		return status;
	}

	public String getMsg() {
		return msg;
	}

	TODOEums(int status,String message){
		this.msg=message;
		this.status=status;
	}

}
