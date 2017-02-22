package com.ddb.springmvc.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ddb.springmvc.domain.Product;
import com.ddb.springmvc.service.ProductService;

@Service   //一般都标注在接口的实现类上
public class ProductServiceImpl implements ProductService {
	private Map<Long, Product> products = new HashMap<Long, Product>();// 模数据库的数据保存与获取
	private AtomicLong generator = new AtomicLong();

	public ProductServiceImpl() {
		Product product = new Product();
		product.setName("MiBook");
		product.setDescription("MiBook write code is very cool!");
		product.setPrice(4999.0d);
		add(product);
	}

	@Override
	public Product add(Product product) {
		long newid = generator.incrementAndGet();
		product.setId(newid);
		// 保存到数据库中 此步模拟数据保存到数据库中
		products.put(newid, product);
		return product;
	}

	@Override
	public Product get(long id) {
		return products.get(id);
	}

	// 返回map，显示所有产品内容
	@Override
	public Map<Long, Product> allProduct() {
		return products;
	}

	@Override
	public Map<Long, Product> deleteProduct(Long id) {
		products.remove(id);
		return products;
	}

	@Override
	public Map<Long, Product> updateProduct(Long id, Product product) {

		// 保存到数据库中 此步模拟数据保存到数据库中
		Long ids = id;
		products.put(id, product);
		Long idss = id;
		return products;
	}

}
