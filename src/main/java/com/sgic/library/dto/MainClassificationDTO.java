package com.sgic.library.dto;

public class MainClassificationDTO {
	private Long mainClassId;
	private String mainClassName;

	
	
	public MainClassificationDTO() {
		super();
	}

	public MainClassificationDTO(Long mainClassId, String mainClassName) {
		super();
		this.mainClassId = mainClassId;
		this.mainClassName = mainClassName;
	}
	
	public MainClassificationDTO(String mainClassName) {
		super();
		this.mainClassName = mainClassName;
	}



	public Long getMainClassId() {
		return mainClassId;
	}

	public void setMainClassId(Long mainClassId) {
		this.mainClassId = mainClassId;
	}

	public String getMainClassName() {
		return mainClassName;
	}

	public void setMainClassName(String mainClassName) {
		this.mainClassName = mainClassName;
	}

}
