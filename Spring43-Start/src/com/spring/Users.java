package com.spring;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Users {

	private String  name;
	private String  address;
	private String  memo;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Users [name=" + name + ", address=" + address + ", memo=" + memo + "]";
	}

	
	public static void main(String[] args) {
		
		
		

	}

}
