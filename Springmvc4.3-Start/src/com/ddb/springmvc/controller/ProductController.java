package com.ddb.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ddb.springmvc.domain.Product;
import com.ddb.springmvc.form.ProductForm;
import com.ddb.springmvc.service.ProductService;

import sun.util.logging.resources.logging;
@Controller
public class ProductController {
	
	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	//自动注入后端数据库写数据的组件
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/product_input")
	public String inputProduct(){
		logger.info("inputProduct 被调用");
		return "ProductForm";
	}
	
	@RequestMapping(value = "/product_save",method = RequestMethod.POST)
	public String saveProduct(ProductForm productForm , RedirectAttributes redirectAttributes){
		logger.info("saveProduct 被调用");
		
		Product product =new Product();
		String name =productForm.getName();
		product.setName(productForm.getName());
		product.setMake(productForm.getMake());
		product.setMany(productForm.getMany());
		product.setDescription(productForm.getDescription());
		
		try {
			product.setPrice(Double.parseDouble(productForm.getPrice()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//add product
		Product saveProduct = productService.add(product);
		//使用下面的对象可以给重定向传值
		redirectAttributes.addFlashAttribute("message", "The product was successfully added!");
		return "redirect:/product_view/"+saveProduct.getId()+".action";
	}

	
	@RequestMapping(value="/product_view/{id}")//{}内的id为路径变量
	public String viewProduct(@PathVariable Long id , Model model){
		Product product =productService.get(id);
		
		model.addAttribute("product",product);
		return "ProductView";
	}

	@RequestMapping(value="/product_retieve")
	public String sendProduct(@RequestParam Long id , Model model){
		//使用@RequestParam获取URL路径上？后面的值     而servlet是用Request 对象的getParameter()方法
		Product product =productService.get(id);
		model.addAttribute("product",product);
		return "ProductView";
	}
	
	
	
	//all product
	@RequestMapping(value="/product_map")
	public String allProduct(Product product,Model model){
		Map<Long,Product> mapProduct = productService.allProduct();
	    model.addAttribute("allProductList",mapProduct);
		return "ProductMap";
	}
	
//根据id删除对应的数据
	@RequestMapping(value = "/delete_product?*")
	public String deletePrduct(@RequestParam Long id ,Model model){
         logger.info("deletePrduct 被调用");
		Map<Long,Product> mapProduct = productService.deleteProduct(id);
		model.addAttribute("allProductList",mapProduct);
		return "ProductMap";
	}
	
	
	
	
	
	
	
	//跳转到修改的jsp页面
	@RequestMapping(value = "/update_product1?*")
	public String updatePrduct1(@RequestParam Long id ,Model model){
		logger.info("deletePrduct 被调用");
		model.addAttribute("productUpdateId", id);
		return "ProductUpdate";
		
	}
	

	//把修改后的值存入map中在传到JSP页面
	@RequestMapping(value = "/update_product2?*")
	public String updatePrduct2(ProductForm productForm , @RequestParam Long id ,Model model){
		logger.info("updatePrduct2 被调用");
		
		
		Product product =new Product();
		
		String name = productForm.getName();
		product.setId(id);
		product.setName(productForm.getName());
		product.setMake(productForm.getMake());
		product.setMany(productForm.getMany());
		product.setDescription(productForm.getDescription());
		
		try {
			product.setPrice(Double.parseDouble(productForm.getPrice()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//add product
		Map<Long,Product> mapProduct = productService.updateProduct(id,product);
		Long ids = id;
		model.addAttribute("allProductList",mapProduct);
		return "ProductMap";
	}
	

}
