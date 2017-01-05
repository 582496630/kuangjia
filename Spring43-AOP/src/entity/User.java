package entity;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class User {



	private Integer id;
	private String name;
	private String password;
	private String eamil;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", eamil=" + eamil + "]";
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
