package com.sgic.library.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(schema = "librarysystem", name = "subclassification")
public class SubClassification implements Serializable {
	@Id
	private String subClassId;
	private String subClassName;
	
	@ManyToOne
	@JoinColumn(name="mainClassId", nullable=false)
	private MainClassification mainClassification;

	
	public SubClassification() {
		super();
	}

	public MainClassification getMainClassification() {
		return mainClassification;
	}

	public void setMainClassification(MainClassification mainClassification) {
		this.mainClassification = mainClassification;
	}

	public String getSubClassId() {
		return subClassId;
	}

	public void setSubClassId(String subClassId) {
		this.subClassId = subClassId;
	}

	public String getSubClassName() {
		return subClassName;
	}

	public void setSubClassName(String subClassName) {
		this.subClassName = subClassName;
	}



}
