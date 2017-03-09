package com.ddb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddb.book.Book;
@Controller
public class AjaxSendControllers {
	
//	String str=requst["materielNo"].tostring();
	/*@RequestMapping(value="/ajaxsendmodel", method = {RequestMethod.GET})
    public String fangfa(@RequestParam ){
		
		System.out.println("fangfa被调用");
		System.out.println(book);
		return "ajaxSend";
		
	}*/
	@RequestMapping(value="/ajaxsendmodel", method = {RequestMethod.GET})
    public String requestBodyBind(){
		
		//model.addAttribute("accountmodel", new Book());
		System.out.println("requestBodyBind被调用");
		
        return "ajaxSend";
    }
	
	@RequestMapping(value="/ajaxsendmodel", method = {RequestMethod.POST})
    public @ResponseBody Book requestBodyBind(@RequestBody Book book){
			/*List<Book> books = new ArrayList<Book>();	
			books.add(book);
			for (Book book2 : books) {
				System.out.println(book2.toString());
			}*/
		
		//System.out.println(book);
		System.out.println(book.toString());
		return book;
    }
}
