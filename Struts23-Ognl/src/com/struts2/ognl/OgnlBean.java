package com.struts2.ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class OgnlBean {

	public static final String staticProperty = "This is a static property!";
	
	private String property = "This is a common property!";
	
	private String[] array = {"Jack","Rose","Tom"};
	
	private List<String> list = new ArrayList<String>();
	private Map<String, String> map = new HashMap<String, String>();
	
	
	public OgnlBean(){
		list.add("hefei");
		list.add("beijing");
		list.add("shanghai");
		map.put("home","11111111");
		map.put("office","22222222");
		map.put("other","33333333");
	}
	public String method(){
		return "This is a common method!";
	}
	public static String staticMethod(){
		return "This is a static method!";
	}
}
