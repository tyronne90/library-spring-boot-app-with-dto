package com.sgic.library.service;

import java.util.List;

import com.sgic.library.entity.SubClassification;

public interface SubClassificationService {
	SubClassification getSubClassificationBySubClassId(String subClassId);
	SubClassification save(SubClassification subClass);
	List<SubClassification> getAllSubClass();
	SubClassification deleteSubClassificationById(String subClassId);
	void updateMainClassification(SubClassification subClass);

}
