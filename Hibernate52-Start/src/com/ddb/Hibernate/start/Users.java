package com.ddb.Hibernate.start;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Users {

	private String shisu;
	private Long id;
	private String name;
	private String pass;
	
	public Users(){
	}

	public Users(Long id, String name, String pass) {
		
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
	
	
}
