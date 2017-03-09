package com.ddb.book;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Book {
	
	private String bookName;
	private String bookSize;
	private String bookPrice;
	private String bookPages;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", bookSize=" + bookSize + ", bookPrive=" + bookPrice + ", bookPages="
				+ bookPages + "]";
	}
	
	
	

}
