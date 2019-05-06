package com.sgic.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.library.entity.MainClassification;
import com.sgic.library.entity.SubClassification;
import com.sgic.library.model.SubClassificationModel;
import com.sgic.library.service.MainClassificationService;
import com.sgic.library.service.SubClassificationService;

@RestController
public class SubClassificationController {
	@Autowired
	SubClassificationService subClassificationService;
	@Autowired
	MainClassificationService mainClassificationService;

	@PostMapping("/SaveSubClassification")
	public HttpStatus saveMainClass(@Valid @RequestBody SubClassificationModel subClassModel) {

		SubClassification subClassification = new SubClassification();
		subClassification.setSubClassId(subClassModel.getSubClassId());
		subClassification.setSubClassName(subClassModel.getSubClassName());

		MainClassification mainClassId = mainClassificationService
				.getMainClassificationById(subClassModel.getMainClassId());
		subClassification.setMainClassification(mainClassId);

		subClassificationService.saveSubClassification(subClassification);
		return HttpStatus.CREATED;
	}

	@GetMapping("/GetAllSubClassification")
	public List<SubClassification> getAllSubClass() {
		return subClassificationService.getAllSubClass();
	}

	@PutMapping("/UpdateSubClassification")
	public ResponseEntity<SubClassification> updateBook(@Valid @RequestBody SubClassificationModel subClassModel) {

		SubClassification subClassification = new SubClassification();
		subClassification.setSubClassId(subClassModel.getSubClassId());
		subClassification.setSubClassName(subClassModel.getSubClassName());

		MainClassification mainClassId = mainClassificationService
				.getMainClassificationById(subClassModel.getMainClassId());
		subClassification.setMainClassification(mainClassId);

		subClassificationService.updateSubClassification(subClassification);
		return new ResponseEntity<SubClassification>(subClassification, HttpStatus.OK);
	}
	

}
