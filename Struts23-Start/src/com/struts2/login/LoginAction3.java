package com.struts2.login;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LoginAction3 {
	private String username;
	private String password;
	
	public String execute() throws Exception{
		if (this.getUsername().equals("root")&&this.getPassword().equals("123")) {
			return "success";
		}return "error";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
