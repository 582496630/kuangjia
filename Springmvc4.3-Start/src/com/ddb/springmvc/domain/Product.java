package com.ddb.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Product {
	
	private Long id;
	private String name;
	private Long many;
	private String make;
	private String description;
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
