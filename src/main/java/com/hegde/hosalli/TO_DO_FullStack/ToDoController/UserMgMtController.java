package com.hegde.hosalli.TO_DO_FullStack.ToDoController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hegde.hosalli.TO_DO_FullStack.ToDoModel.LoginInfo;
import com.hegde.hosalli.TO_DO_FullStack.ToDoModel.TODOEums;

@RestController
public class UserMgMtController {

	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@GetMapping(path = "/login")
	public LoginInfo basicAuth() {
		System.out.println("Login");
		return new LoginInfo(TODOEums.LOGIN_SUCCESS.getMsg(), TODOEums.LOGIN_SUCCESS.getStatus());
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@PostMapping(path = "/register")
	public void registerUser() {
		System.out.println("Register");
	}

}
