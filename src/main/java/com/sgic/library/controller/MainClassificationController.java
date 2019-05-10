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

import com.sgic.library.dto.MainClassificationDTO;
import com.sgic.library.dtomapper.MainClassificationDtoMapper;

@RestController
public class MainClassificationController {
	@Autowired
	MainClassificationDtoMapper mainClassDTOMapper;

	@PostMapping("/SaveMainClassification")
	public HttpStatus saveMainClass(@Valid @RequestBody MainClassificationDTO mainClassDTO) {
		mainClassDTOMapper.saveMainClass(mainClassDTO);
				
		return HttpStatus.CREATED;
	}

	@GetMapping("/GetAllMainClassification")
	public List<MainClassificationDTO> getAllMainClass() {
		return mainClassDTOMapper.getAllMainClass();
	}
	
	@GetMapping("/getMainClassificationById/{mainClassId}")
	public ResponseEntity<MainClassificationDTO> getMainClassificationById(@PathVariable("mainClassId") Long mainClassId) {
		return new ResponseEntity<MainClassificationDTO>(mainClassDTOMapper.getMainClass(mainClassId),
				HttpStatus.OK);
	}
}
