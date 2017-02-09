package com.struts2.ognl;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;


public class OgnlTest2 {

	@SuppressWarnings("rawtypes")//压制原始类型的警告
	public static void main(String[] args) throws OgnlException{
		PrintStream out = System.out;
		OgnlBean bean = new OgnlBean();
		
		OgnlContext context = new OgnlContext();
		context.put("bean", bean);
		
		out.println(Ognl.getValue("'Hello!'",context));
		out.println(Ognl.getValue("'A'",context));
		out.println(Ognl.getValue("88",context));
		out.println(Ognl.getValue("true",context));
		out.println(Ognl.getValue("null",context));
		
		out.println(Ognl.getValue("#name='zhangsan'",context));
		out.println(Ognl.getValue("bean.property",context));
		out.println(Ognl.getValue("bean.method()",context));
		//@包名类名@属性名    获取静态属性的值
		out.println(Ognl.getValue("@com.struts2.ognl.OgnlBean@staticProperty",context));
		out.println(Ognl.getValue("@com.struts2.ognl.OgnlBean@staticMethod()",context));
		
		out.println(Ognl.getValue("(new java.lang.String(\"Instance a new objict!\")).toString()",context));
		//获取Bean中数组的元素
		out.println(Ognl.getValue("bean.getArray()[0]",context));
		
		//out.println(Ognl.getValue("bean.getArray(0)",context));错误的写法
		
		out.println(Ognl.getValue("bean.array[0]",context));
		
		out.println(Ognl.getValue("bean.getList()[0]",context));
		out.println(Ognl.getValue("bean.list[0]",context));
		
		out.println(Ognl.getValue("bean.getMap()['home']",context));
		out.println(Ognl.getValue("bean.map['home']",context));
		out.println(Ognl.getValue("bean.getMap()['office']",context));
		out.println(Ognl.getValue("bean.map.office",context));
		
		int[] array = (int[])Ognl.getValue("new int[]{0,1,2,3,4,5}", context);
		out.println(Arrays.toString(array));
		
		List list =(List)Ognl.getValue("{0,1,2,3,4,5}", context);
		out.println(list);
		
		Map map =(Map)Ognl.getValue("#{'key1':'value2','key2':'value2','key3':'value3'}", context);
		out.println(map);
		
		//放置List
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList.add(new Teacher("Jack1",2000));
		teacherList.add(new Teacher("Jack2",2200));
		teacherList.add(new Teacher("Jack3",2400));
		teacherList.add(new Teacher("Jack4",2600));
		teacherList.add(new Teacher("Jack5",2800));
		teacherList.add(new Teacher("Jack6",3000));
		context.put("teacherList", teacherList);
		
		out.println(Ognl.getValue("teacherList.{name}", context));
		out.println(Ognl.getValue("teacherList.{#this.name.toUpperCase()}", context));
		//三目运算符返回的是salary这个属性值
		out.println(Ognl.getValue("teacherList.{#this.salary>2500?#this.salary:#this.salary+99}", context));
		//?#this.salary>2500 这个是teacherList的一个过滤条件
		out.println(Ognl.getValue("teacherList.{?#this.salary>2500}", context));
		out.println(Ognl.getValue("teacherList.{?#this.salary>2500}[0]", context));
		out.println(Ognl.getValue("teacherList.{^#this.salary>2500}", context));
		out.println(Ognl.getValue("teacherList.{$#this.salary>2500}", context));
		
	}

}
