package com.auto;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
/*
@Autowired 注入属性，可以放在属性或者Setter方法上面   byType自动注入
@Resource    注入属性，可以放在属性或者Setter方法上面
                                       属性name解析bean的名字，type解析bean类型，byname自动注入
             @Resource(name="usaGirlFriend") @Resource(type=UsaGirlFriend.class)

下面四个注解都可以把类放到容器bean中，，根据这个类是什么功能处于什么层面，来使用哪个注解，不清楚就@Component
@Component("boyAnnotation") 给组件去个名字
@Repository   dao层bean(持久化层)
@Service      Service层bean(服务层)
@Controller    mvc控制层bean(表现层)


@Scope("session") bean的作用域
singleton   单例，共享bean
prototype   注入新的bean
request    http request 有效(一个请求一个新的bean)
session    http session 有效(一个请求一个新的bean)
global  session  portlet web 有效全局session

@author win
  */
@Component("boyAnnotation")
public class BoyAnnotation {
	private static Logger logger = Logger.getLogger(BoyAnnotation.class);
	@Autowired  //自动导入
	private UsaGirlFriend usaGirlFriend;
	private static ApplicationContext ctx;
	
	
	public UsaGirlFriend getUsaGirlFriend(){
		return usaGirlFriend;
	}
/*	@Resource(name="usaGirlFriend")
	public void setUsaGirlFriend(UsaGirlFriend usaGirlFriend){
		this.usaGirlFriend=usaGirlFriend;
	}
	因为有了@Autowired  所以不用setter 也可以设置属性值；
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ctx = new ClassPathXmlApplicationContext("applicationContext-auto.xml");
		BoyAnnotation boy = (BoyAnnotation) ctx.getBean("boyAnnotation");
		logger.info(boy.usaGirlFriend.speak());
		
		
		
	}

}
