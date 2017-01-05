package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.User;
import service.UserService;

public class Test {

	private static ApplicationContext ctx;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) ctx.getBean("service");
		
		
		User user = new User();
		user.setName("zhouyou");
		user.setId(1);
		user.setPassword("123456");
		user.setEamil("1223456@qq.com");
		userService.addNewUser(user);
		
	}

}
