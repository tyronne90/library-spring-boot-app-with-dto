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
	public SubClassification save(SubClassification subClass) {
		return subClassificationRepository.save(subClass);
	}

	@Override
	public List<SubClassification> getAllSubClass() {
		return subClassificationRepository.findAll();
	}

	@Override
	public SubClassification deleteSubClassificationById(String subClassId) {
		subClassificationRepository.deleteById(subClassId);
		return null;
	}

	@Override
	public void updateMainClassification(SubClassification subClass) {
		String subClassId = subClass.getSubClassId();
		boolean isExist = subClassificationRepository.findSubClassificationBySubClassId(subClassId) != null;
		if (isExist) {
			subClassificationRepository.save(subClass);
		}
	}
	
	

}
