package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	private static ApplicationContext ctx;
	
	private static void print(Object object){
		System.out.println(object);
	}
	
	public static void test1(){
		//一般java类实例化对象与属性的调用
		Users users = new Users();
		users.setName("zhouyou");
		users.setAddress("hefei");
		users.setMemo("This is my first spring project");
		//调用print 方法输出
		print(users);
	}
	public static void test2(){
		//使用ClassPathXmlApplicationContext方法实例化spring的上下文
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过ApplicationContext的getBean方法，根据id来获取Bean的实例
		Users users = (Users) ctx.getBean("users");
		print(users);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
		test2();
		
	}

}
