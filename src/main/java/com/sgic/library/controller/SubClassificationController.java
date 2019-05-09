package com.sgic.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.library.dto.SubClassificationDTO;
import com.sgic.library.dtomapper.SubClassificationDTOMapper;
import com.sgic.library.entity.SubClassification;
import com.sgic.library.service.SubClassificationService;

@RestController
public class SubClassificationController {
	@Autowired
	SubClassificationService subClassService;
	
	@PostMapping("/SaveSubClassification")
	public HttpStatus saveMainClass(@Valid @RequestBody SubClassificationDTO subClassDTO) {
		SubClassification subClass =  SubClassificationDTOMapper.SubClassDTOToSubClass(subClassDTO);
		subClassService.saveSubClassification(subClass);
				
		return HttpStatus.CREATED;
	}
	
	@GetMapping("/GetAllSubClassification")
	public List<SubClassification> getAllSubClass() {
		return subClassService.getAllSubClass();
	}
	
	@GetMapping("/GetSubClassificationById/{subClassId}")
	public ResponseEntity<SubClassification> getSubClassificationBySubClassId(@PathVariable("subClassId") String subClassId) {
		return new ResponseEntity<SubClassification>(subClassService.getSubClassificationBySubClassId(subClassId),
				HttpStatus.OK);
	}

}
