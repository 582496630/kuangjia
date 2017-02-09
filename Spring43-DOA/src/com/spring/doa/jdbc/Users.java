package com.spring.doa.jdbc;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Users {

	private Long id;
	private String name;
	private String pass;
	
	@Override
	public String toString(){
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("[ id = ").append(id).append(",");
		sBuilder.append("name = ").append(name).append(",");
		sBuilder.append("password = ").append(pass).append("]");
		
		return sBuilder.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
