package com.sgic.library.dto;

public class BookDTO {
	private String bookId;
	private String bookName;
	private String bookDescription;
	private Long mainClassId;
	private String subClassId;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public Long getMainClassId() {
		return mainClassId;
	}
	public void setMainClassId(Long mainClassId) {
		this.mainClassId = mainClassId;
	}
	public String getSubClassId() {
		return subClassId;
	}
	public void setSubClassId(String subClassId) {
		this.subClassId = subClassId;
	}

}
