package com.dbb.struts2.annotation;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;


//http://struts.apache.org/docs/convention-pligin.html
@Getter@Setter
public class UserAction extends ActionSupport{
	private static final long serialVersionUID=503913478785271976L;
	private String username;
	private String password;
	
	@Action(value ="/users",results={@Result(name="success",location="/success.jsp")})
	public String execute(){
		return SUCCESS;
	}
	
	
	
	
	
	
	

}
