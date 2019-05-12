package com.sgic.library.entity;


public class BookPost {
	private String bookId;
	private String bookName;
	private String bookDescription;
	private SubClassification subClassId;
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
	public SubClassification getSubClassId() {
		return subClassId;
	}
	public void setSubClassId(SubClassification subClassId) {
		this.subClassId = subClassId;
	}
	
	
}
