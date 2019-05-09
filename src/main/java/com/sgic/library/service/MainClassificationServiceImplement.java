package com.sgic.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.library.entity.MainClassification;
import com.sgic.library.repository.MainClassificationRepository;

@Service
public class MainClassificationServiceImplement implements MainClassificationService {
	
	@Autowired
	MainClassificationRepository mainClassificationRepository;

	@Override
	public MainClassification save(MainClassification mainClass) {
		return mainClassificationRepository.save(mainClass);
	}

	@Override
	public List<MainClassification> getAllMainClass() {
		return mainClassificationRepository.findAll();
	}

	@Override
	public MainClassification getMainClassificationById(Long mainClassId) {
		return mainClassificationRepository.findMainClassificationByMainClassId(mainClassId);
}
}
