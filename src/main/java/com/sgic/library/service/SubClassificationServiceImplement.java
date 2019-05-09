package com.sgic.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.library.entity.SubClassification;
import com.sgic.library.repository.SubClassificationReposotory;

@Service
public class SubClassificationServiceImplement implements SubClassificationService {
	
	@Autowired
	SubClassificationReposotory subClassificationRepository;

	@Override
	public SubClassification getSubClassificationBySubClassId(String subClassId) {
		return subClassificationRepository.findSubClassificationBySubClassId(subClassId);
	}

	@Override
	public void saveSubClassification(SubClassification subClass) {
		subClassificationRepository.save(subClass);
	}

	@Override
	public List<SubClassification> getAllSubClass() {
		return subClassificationRepository.findAll();
	}
	
	

}
