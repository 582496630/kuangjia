package com.ddb.springmvc.domain;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

	private Long id;
	
	@NotEmpty(message="{name.not.empty}")
	private String name;
	//@NotEmpty(message="{name.not.empty}")
	private Long many;
	@NotEmpty(message="{name.not.empty}")
	private String make;
	@NotEmpty(message="{name.not.empty}")
	private String description;
	
	//@NotEmpty(message="{name.not.empty}")
	private Double price;

	public Product() {
		super();
	}

	public Product(Long id, String name, Long many, String make, String description, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.many = many;
		this.make = make;
		this.description = description;
		this.price = price;
	}
}
