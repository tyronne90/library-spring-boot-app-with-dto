package com.sgic.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.library.entity.SubClassification;
import com.sgic.library.repository.SubClassificationRepository;

@Service
public class SubClassificationServiceImplement implements SubClassificationService {

	@Autowired
	SubClassificationRepository subClassificationRepository;

	@Override
	public void saveSubClassification(SubClassification subClass) {
		subClassificationRepository.save(subClass);
	}

	@Override
	public List<SubClassification> getAllSubClass() {
		return subClassificationRepository.findAll();
	}

	@Override
	public void updateSubClassification(SubClassification subClass) {
		String subClassId = subClass.getSubClassId();
		boolean isExist = subClassificationRepository.findSubClassificationBySubClassId(subClassId) != null;
		if (isExist) {
			subClassificationRepository.save(subClass);
		}
	}

	@Override
	public SubClassification getSubClassificationById(String subClassId) {
		return subClassificationRepository.findSubClassificationBySubClassId(subClassId);
	}

}
