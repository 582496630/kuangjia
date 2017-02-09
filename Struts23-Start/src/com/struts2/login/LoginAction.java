package com.struts2.login;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LoginAction {
	private String username;
	private String password;
	
	public String execute() throws Exception{
		if (this.getUsername().equals("root") && this.getPassword().equals("123")){
			return "success";
		}
		return "error";
	}
	

}
