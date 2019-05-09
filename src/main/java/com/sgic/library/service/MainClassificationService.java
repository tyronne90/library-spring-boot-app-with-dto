package com.sgic.library.service;

import java.util.List;

import com.sgic.library.entity.MainClassification;

public interface MainClassificationService {
	MainClassification getMainClassificationById(Long mainClassId);
	MainClassification save(MainClassification mainClass);
	List<MainClassification> getAllMainClass();
}
