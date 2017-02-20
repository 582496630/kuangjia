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
	

}
