package com.sgic.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.library.dto.SubClassificationDTO;
import com.sgic.library.dtomapper.SubClassificationDTOMapper;

@RestController
public class SubClassificationController {
	@Autowired
	SubClassificationDTOMapper subClassMapper;
	
	@PostMapping("/SaveSubClassification")
	public HttpStatus saveMainClass(@Valid @RequestBody SubClassificationDTO subClassDTO) {
//		SubClassification subClass =  SubClassificationDTOMapper.SubClassDTOToSubClass(subClassDTO);
//		subClassService.saveSubClassification(subClass);
		
		subClassMapper.saveSubClass(subClassDTO);
		return HttpStatus.CREATED;
	}
	
	@GetMapping("/GetAllSubClassification")
	public List<SubClassificationDTO> getAllSubClass() {
		return subClassMapper.getAllSubClass();
	}
	
	@GetMapping("/GetSubClassificationById/{subClassId}")
	public ResponseEntity<SubClassificationDTO> getSubClassificationBySubClassId(@PathVariable("subClassId") String subClassId) {
		return new ResponseEntity<SubClassificationDTO>(subClassMapper.getSubClassById(subClassId),
				HttpStatus.OK);
	}
	
	@PutMapping("UpdateSubClassification")
	public ResponseEntity<SubClassificationDTO> updateSubClassification(@Valid @RequestBody SubClassificationDTO subClassDTO) {
		subClassMapper.updateSubClassification(subClassDTO);
		return new ResponseEntity<SubClassificationDTO>(subClassDTO, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/DeleteSubClassById/{subClassId}")
	public ResponseEntity<SubClassificationDTO> deleteMainClassificationById(
			@PathVariable("subClassId") String subClassId) {
		return new ResponseEntity<SubClassificationDTO>(subClassMapper.deleteSubClassification(subClassId),
				HttpStatus.OK);
	}

}
