package com.hegde.hosalli.TO_DO_FullStack.ToDoModel;

public class LoginInfo {
	
	private String loginMessage;
	private int loginStatus;
	
	public LoginInfo(String loginMessage, int loginStatus) {
		super();
		this.loginMessage = loginMessage;
		this.loginStatus = loginStatus;
	}

	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	
	
	

}
