package com.ddb.mybatis.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class UserInfo {
	
	
	private Integer id;
	private String username;
	private String password;
	
	
	@Override
	public String toString() {
		
		return "[id = ".concat(this.id + ",username = ").concat(this.username + 
				",password = ").concat(this.password +"]");
		//return "UserInfo [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
