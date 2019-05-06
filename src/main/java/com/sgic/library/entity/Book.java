package com.sgic.library.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(schema = "librarysystem", name = "books")
public class Book implements Serializable {

	@Id
	private String bookId;
	private String bookName;
	private String bookDescription;
	@OneToOne
	@JoinColumn(name = "mainClassId", nullable = false)
	private MainClassification mainClassId;
	@OneToOne
	@JoinColumn(name = "subClassId", nullable = false)
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
	public MainClassification getMainClassId() {
		return mainClassId;
	}
	public void setMainClassId(MainClassification mainClassId) {
		this.mainClassId = mainClassId;
	}
	public SubClassification getSubClassId() {
		return subClassId;
	}
	public void setSubClassId(SubClassification subClassId) {
		this.subClassId = subClassId;
	}
}
