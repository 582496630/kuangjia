package com.type;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class User {
	private String username;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}

}
