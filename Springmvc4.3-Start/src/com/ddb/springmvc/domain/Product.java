package com.ddb.springmvc.domain;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

	private Long id;
	
	@NotEmpty(message="{name.not.empty}")
	private String name;
	
	/*这注释的两个不为空的注解 无法对Long型的many使用
	@NotEmpty(message="{name.not.empty}")
	@NotBlank(message="{many.not.empty}")*/
	@NotNull(message="{many.not.empty}")
	private Long many;
	
	@NotEmpty(message="{make.not.empty}")
	private String make;
	
	@NotEmpty(message="{description.not.empty}")
	private String description;
	
	
	/*这注释的两个不为空的注解 无法对Double型的price使用
	//@NotEmpty(message="{price.not.empty}")
	//@NotBlank(message="{price.not.empty}")
	//@Digits(integer=100, fraction=0)  限制整数位与小数为的个数，double只有一个小数位，所以不需要这个注解*/	
	@NotNull(message="{price.not.empty}")
	private Double price;

	
	
}