package com.struts2.struts2ognl;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.struts2.ognlvaluestack.Student;
import com.struts2.ognlvaluestack.Teacher;

import lombok.Getter;
import lombok.Setter;
import ognl.OgnlException;

@Getter@Setter
public class OgnlAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String greeting;
	private List<Person> persons = new ArrayList<Person>();
	
	private void initData(){
		Address address1= new Address("�й�","�Ϸ�","������11��");
		Address address2= new Address("�й�","�Ϻ�","�ֶ���22��");
		Address address3= new Address("�й�","����","������111��");
		
		String[] alias1 ={"xiaozhang","����"};
		String[] alias2 ={"laosi","�Ķ�"};
		String[] alias3 ={"������","�����"};
		
		List<String> email1 = new ArrayList<String>();
		email1.add("zhangsan@163.com");
		email1.add("zhangsan@qq.com");
		List<String> email2 = new ArrayList<String>();
		email2.add("lisi@163.com");
		email2.add("lisi@qq.com");
		List<String> email3 = new ArrayList<String>();
		email3.add("wuye@163.com");
		email3.add("wuye@qq.com");
		
		Map<String, String> phone1 = new HashMap<String,String>();
		phone1.put("home", "3333331");
		phone1.put("office", "3333332");
		Map<String, String> phone2 = new HashMap<String,String>();
		phone2.put("home", "44444441");
		phone2.put("office", "44444442");
		Map<String, String> phone3 = new HashMap<String,String>();
		phone3.put("home", "5555551");
		phone3.put("office", "55555552");
		
		Person person1 = new Person("����",33,3333,address1,alias1,email1,phone1);
		Person person2 = new Person("����",44,4444,address2,alias2,email2,phone2);
		Person person3 = new Person("����",55,5555,address3,alias3,email3,phone3);
		
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
	}
	@SuppressWarnings({"unchecked","rawtypes"})
	@Override
	public String execute()throws Exception{
		initData();
        valueStack();
        ActionContext actionContext = ActionContext.getContext();
        Map request = actionContext.getContextMap();
        Map session = actionContext.getSession();
        Map application = actionContext.getApplication();
        request.put("personName", persons.get(0).getName());
        session.put("personName", persons.get(1).getName());
        application.put("personName", persons.get(2).getName());
        
        return SUCCESS;
	} 
	public void valueStack() throws OgnlException{
		Student stu = new Student("Jack",20);
		Teacher tea = new Teacher("Scott",40);
		
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.push(stu);
		PrintStream out = System.out;
		
		out.println(valueStack.findValue("name"));
		valueStack.push(tea);
		out.println(valueStack.findValue("name"));
		
		out.println("================================");
		out.println(valueStack.findValue("score"));
		out.println(valueStack.findValue("salary"));
		
		out.println("================================");
		valueStack.setValue("name", "Rose");
		out.println(valueStack.findValue("name"));
		valueStack.setValue("score", "80");
		out.println(valueStack.findValue("score"));
		out.println("================================");
	}
	
}