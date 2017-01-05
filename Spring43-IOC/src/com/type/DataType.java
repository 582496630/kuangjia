package com.type;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


import lombok.Setter;
@Setter
public class DataType {
	private String specialCharacter1;//特殊字符串1
	private String specialCharacter2;//特殊字符串2
	private User innerBean;
	
	private List<String> list;
	private String[] array;
	private Set<String> set;
	private Map<String, String> map;
	private Properties props;
	private String emptyValue;
	private String nullValue = "init null";

	public void printValue(){
	PrintStream out = System.out;
		
		out.println("特殊字符1："+this.specialCharacter1);
		out.println("特殊字符2："+this.specialCharacter2);
		out.println("内部bean:"+this.innerBean);
		out.println("list属性："+this.list);
		out.println("数组属性："+this.array);
		out.println("set属性:"+this.set);
		out.println("map属性："+this.map);
		out.println("Properties属性:"+this.props);
		out.println("注入空字符串：["+this.emptyValue+"]");
		out.println("注入null值："+this.nullValue);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
