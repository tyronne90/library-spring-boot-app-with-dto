package com.sgic.library.dto;

public class SubClassificationDTO {
	private String subClassId;
	private String subClassName;
	private Long mainClassId;
	
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
	public Long getMainClassId() {
		return mainClassId;
	}
	public void setMainClassId(Long mainClassId) {
		this.mainClassId = mainClassId;
	}

	
}
