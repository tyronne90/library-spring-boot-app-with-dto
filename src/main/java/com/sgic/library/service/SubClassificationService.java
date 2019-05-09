package com.sgic.library.service;

import java.util.List;

import com.sgic.library.entity.SubClassification;

public interface SubClassificationService {
	SubClassification getSubClassificationBySubClassId(String subClassId);
	void saveSubClassification(SubClassification subClass);
	List<SubClassification> getAllSubClass();
}
