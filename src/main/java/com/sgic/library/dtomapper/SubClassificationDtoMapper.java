package com.sgic.library.dtomapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgic.library.dto.SubClassificationDTO;
import com.sgic.library.entity.MainClassification;
import com.sgic.library.entity.SubClassification;
import com.sgic.library.service.MainClassificationService;

public class SubClassificationDTOMapper {
	
	@Autowired
	MainClassificationService mainClassService;
	
	public static SubClassificationDTO SubClassToSubClassDTO(SubClassification subClass) {
		SubClassificationDTO subClassDTO = new SubClassificationDTO();
		subClassDTO.setSubClassId(subClass.getSubClassId());
		subClassDTO.setSubClassName(subClass.getSubClassName());
		subClassDTO.setMainClassId(subClass.getMainClassification().getMainClassId());
		return subClassDTO;
	}
	
	public static SubClassification SubClassDTOToSubClass(SubClassificationDTO subClassDTO) {
		SubClassification subClass = new SubClassification();
		subClass.setSubClassId(subClassDTO.getSubClassId());
		subClass.setSubClassName(subClassDTO.getSubClassName());
		MainClassification mainClass = new MainClassification();
		mainClass.setMainClassId(subClassDTO.getMainClassId());
		subClass.setMainClassification(mainClass);
		return subClass;
	}
}
