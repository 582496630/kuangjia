package com.ddb.springmvc.form;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductForm {
	
	private Long id;
	private String name;
	private String description;
	private String  price;
	private Long many;
	private String make;
	
	
	public ProductForm() {
		super();
	}
	public ProductForm(Long id, String name, Long many, String make, String description, String price) {
		super();
		this.id = id;
		this.name = name;
		this.many = many;
		this.make = make;
		this.description = description;
		this.price = price;
		
	}

}
