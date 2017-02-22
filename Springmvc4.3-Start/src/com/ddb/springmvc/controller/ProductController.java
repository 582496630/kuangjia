package com.ddb.springmvc.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ddb.springmvc.domain.Product;
import com.ddb.springmvc.form.ProductForm;
import com.ddb.springmvc.service.ProductService;

@Controller
public class ProductController {

	private static final Logger logger = Logger.getLogger(ProductController.class);

	// 自动注入后端数据库写数据的组件
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product_input")
	public String inputProduct() {
		logger.info("inputProduct 被调用");
		return "ProductForm";
	}

/*	
	//正在改正，获取不到前端页面的内容   验证之后  返回路径不对  
	//思路把saveProduct方法内容放到 验证的post的方法下，验证成功直接转到view页面
	@RequestMapping(value = "/product_save", method = RequestMethod.GET)
//	public String saveProduct(ProductForm productForm, RedirectAttributes redirectAttributes) {
		public String saveProduct( ProductForm productForm, RedirectAttributes redirectAttributes) {
		logger.info("saveProduct 被调用");
		
		@RequestParam Product product 
		Product product = new Product();
		String name = productForm.getName();
		product.setName(productForm.getName());
		product.setMake(productForm.getMake());
		product.setMany(productForm.getMany());
		product.setDescription(productForm.getDescription());

		try {
			product.setPrice(Double.parseDouble(productForm.getPrice()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// add product
		
		Product saveProduct = productService.add(product);
		// 使用下面的对象可以给重定向传值
		redirectAttributes.addFlashAttribute("message", "The product was successfully added!");
		return "redirect:/product_view/" + saveProduct.getId() + ".action";
	}*/

	//跳转到jsp页面，并把数据通过model传到前端
	@RequestMapping(value = "/product_view/{id}" ) // {}内的id为路径变量
	public String viewProduct(@PathVariable Long id, Model model) {
		Product product = productService.get(id);

		model.addAttribute("product", product);
		return "ProductView";
	}

	@RequestMapping(value = "/product_retieve")
	public String sendProduct(@RequestParam Long id, Model model) {
		// 使用@RequestParam获取URL路径上？后面的值 而servlet是用Request 对象的getParameter()方法
		Product product = productService.get(id);
		model.addAttribute("product", product);
		return "ProductView";
	}

	// all product 重点 不会，记住
	@RequestMapping(value = "/product_map")
	public String allProduct(Product product, Model model) {
		Map<Long, Product> mapProduct = productService.allProduct();
		model.addAttribute("allProductList", mapProduct);
		return "ProductMap";
	}

	// 根据id删除对应的数据
	@RequestMapping(value = "/delete_product?*")
	public String deletePrduct(@RequestParam Long id, Model model) {
		logger.info("deletePrduct 被调用");
		Map<Long, Product> mapProduct = productService.deleteProduct(id);
		model.addAttribute("allProductList", mapProduct);
		return "ProductMap";
	}

	// 跳转到修改的jsp页面
	@RequestMapping(value = "/update_product1?*")
	public String updatePrduct1(@RequestParam Long id, Model model) {
		logger.info("deletePrduct 被调用");
		model.addAttribute("productUpdateId", id);
		return "ProductUpdate";

	}
	
	
	//验证Update页面添加的内容要符合要求
	@RequestMapping(value="/update_product1?*", method = {RequestMethod.GET})
	public String testUpdate(Model model){
		
		if(!model.containsAttribute("contentUpdate")){
			model.addAttribute("contentUpdate", new Product());
		}
		return "ProductUpdate";
	}
	
	@RequestMapping(value="/update_product1?*", method = {RequestMethod.POST})
	public String test(@RequestParam Long id,Model model,
			@Valid @ModelAttribute("contentUpdate") Product product, BindingResult result,
			RedirectAttributes redirectAttributes,ProductForm productForm) 
					throws NoSuchAlgorithmException{
		
		//如果有验证错误 返回到form页面
        if(result.hasErrors())
            return "ProductUpdate";;
        
	// 把修改后的值存入map中在传到JSP页面
		logger.info("updatePrduct2 被调用");

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
		// add product
		Map<Long, Product> mapProduct = productService.updateProduct(id, product);
		model.addAttribute("allProductList", mapProduct);
		return "ProductMap";
	}

	
	
	//验证Form页面添加的内容要符合要求
	@RequestMapping(value="/product_input", method = {RequestMethod.GET})
	public String test(Model model){
		
		if(!model.containsAttribute("contentModel")){
			model.addAttribute("contentModel", new Product());
		}
		return "ProductForm";
	}
	
	@RequestMapping(value="/product_input", method = {RequestMethod.POST})
	public String test(Model model, @Valid @ModelAttribute("contentModel") Product product, BindingResult result,RedirectAttributes redirectAttributes,ProductForm productForm) throws NoSuchAlgorithmException{
		
		//如果有验证错误 返回到form页面
        if(result.hasErrors())
            return "ProductForm";;
    	//return "redirect:/product_save/"+product+".action";
            
            
            //当验证通过时，执行下面的调用service 中的add方法   向map中添加数据
        		logger.info("saveProduct 被调用");
        		
        		product.setName(productForm.getName());
        		product.setMake(productForm.getMake());
        		product.setMany(productForm.getMany());
        		product.setDescription(productForm.getDescription());
        		try {
        			product.setPrice(Double.parseDouble(productForm.getPrice()));
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        		
        		Product saveProduct = productService.add(product);
        		// 使用下面的对象可以给重定向传值
        		redirectAttributes.addFlashAttribute("message", "The product was successfully added!");
        		return "redirect:/product_view/" + saveProduct.getId() + ".action";
	}

}
