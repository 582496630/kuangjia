package com.set;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoyConstructor {

	private static Logger logger = Logger.getLogger(BoyConstructor.class);
	
	private GirlFriend girlFriend;
	private static ApplicationContext ctx;
//	声明无参有参两个构造函数
	public BoyConstructor(){
		
	}
	public BoyConstructor(GirlFriend girlFriend) {
		// super();
		this.girlFriend = girlFriend;//在构造方法中直接赋值，所以没有setter方法也可以有值，自动声明时就会有
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ctx = new ClassPathXmlApplicationContext("applicationContext-set.xml");
		BoyConstructor boy = (BoyConstructor) ctx.getBean("boyConstructor");
		logger.info(boy.girlFriend.speak());
	}

}
