package com.set;

import lombok.Getter;
import lombok.Setter;

public class UsaGirlFriend  implements GirlFriend {
	@Setter@Getter
private String language;


	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return language;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
