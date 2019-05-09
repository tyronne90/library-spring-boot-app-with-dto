package com.sgic.library.dtomapper;

import com.sgic.library.dto.MainClassificationDTO;
import com.sgic.library.entity.MainClassification;

public class MainClassificationDtoMapper {
	
	public static MainClassificationDTO MainClassToMainClassDTO(MainClassification mainClass) {
		MainClassificationDTO mainClassDTO = new MainClassificationDTO();
		mainClassDTO.setMainClassName(mainClass.getMainClassName());
		return mainClassDTO;
	}
	
	public static MainClassification MainClassDTOToMainClass(MainClassificationDTO mainClassDTO) {
//		MainClassification mainClass = new MainClassification();
//		mainClass.setMainClassName(mainClassDTO.getMainClassName());
		return null;
	}
	
	
}
