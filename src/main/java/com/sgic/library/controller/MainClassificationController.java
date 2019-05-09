package com.sgic.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.library.dto.MainClassificationDTO;
import com.sgic.library.dtomapper.MainClassificationDtoMapper;
import com.sgic.library.entity.MainClassification;
import com.sgic.library.repository.MainClassificationRepository;
import com.sgic.library.service.MainClassificationService;

@RestController
public class MainClassificationController {
	@Autowired
	MainClassificationService mainClassService;
	@Autowired
	MainClassificationRepository mainClassificationRepository;

	@PostMapping("/SaveMainClassification")
	public HttpStatus saveMainClass(@Valid @RequestBody MainClassificationDTO mainClassDTO) {
		MainClassification mainClass = MainClassificationDtoMapper.MainClassDTOToMainClass(mainClassDTO);
		mainClassService.saveMainClassification(mainClass);
				
		return HttpStatus.CREATED;
	}

	@GetMapping("/GetAllMainClassification")
	public List<MainClassification> getAllMainClass() {
		return mainClassService.getAllMainClass();
	}

	@GetMapping("/getMainClassificationById/{mainClassId}")
	public ResponseEntity<MainClassification> getMainClassificationById(@PathVariable("mainClassId") Long mainClassId) {
		return new ResponseEntity<MainClassification>(mainClassService.getMainClassificationById(mainClassId),
				HttpStatus.OK);
	}
}
