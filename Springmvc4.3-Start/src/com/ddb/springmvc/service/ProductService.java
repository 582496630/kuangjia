package com.ddb.springmvc.service;

import java.util.Map;

import com.ddb.springmvc.domain.Product;

public interface ProductService {

	Product add(Product product);

	Product get(long id);

	public Map<Long, Product> allProduct();

	Map<Long, Product> deleteProduct(Long id);

	public Map<Long, Product> updateProduct(Long id, Product product);

}
