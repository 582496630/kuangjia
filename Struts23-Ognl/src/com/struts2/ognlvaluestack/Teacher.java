package com.struts2.ognlvaluestack;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Teacher {

	private String name;
	private int salary;
	public Teacher(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//return "Teacher [name=" + name + ", salary=" + salary + "]";
		return this.name+":"+this.salary;
		
	}
	
	

}
