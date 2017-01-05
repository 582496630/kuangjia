package com.set;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Getter;
import lombok.Setter;

public class BoySetter {

	private static Logger logger = Logger.getLogger(BoySetter.class);
	
	@Setter@Getter
	private GirlFriend girlFriend;
	private static ApplicationContext ctx;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ctx = new ClassPathXmlApplicationContext("applicationContext-set.xml");
		BoySetter boy = (BoySetter) ctx.getBean("boySetter");
		logger.info(boy.girlFriend.speak());
	}

}
