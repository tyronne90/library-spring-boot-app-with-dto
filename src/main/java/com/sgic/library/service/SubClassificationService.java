package com.sgic.library.service;

import java.util.List;

import com.sgic.library.entity.SubClassification;

public interface SubClassificationService {
	void saveSubClassification(SubClassification subClass);
	void updateSubClassification(SubClassification subClass);
	List<SubClassification> getAllSubClass();
	SubClassification getSubClassificationById(String subClassId); 
}
