package com.sgic.library.dtomapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.library.dto.MainClassificationDTO;
import com.sgic.library.entity.MainClassification;
import com.sgic.library.service.MainClassificationServiceImplement;

@Service
public class MainClassificationDtoMapper {

	@Autowired
	private MainClassificationServiceImplement mainClassServiceImpl;

//	public static MainClassificationDTO MainClassToMainClassDTO(MainClassification mainClass) {
//		MainClassificationDTO mainClassDTO = new MainClassificationDTO();
//		mainClassDTO.setMainClassName(mainClass.getMainClassName());
//		return mainClassDTO;
//	}
//	
//	public static MainClassification MainClassDTOToMainClass(MainClassificationDTO mainClassDTO) {
//		MainClassification mainClass = new MainClassification();
//		mainClass.setMainClassName(mainClassDTO.getMainClassName());
//		return null;
//	}
//	

	ModelMapper modelMapper = new ModelMapper();

	private MainClassificationDTO MainClassToMainClassDTO(MainClassification mainClass) {
		MainClassificationDTO mainClassDTO = modelMapper.map(mainClass, MainClassificationDTO.class);
		return mainClassDTO;
	}

//	private MainClassification DTOtoEntity(MainClassification mainClassification) {
//		MainClassification mainClass = modelMapper.map(mainClassification, MainClassification.class);
//		return mainClass;
//	}

	public MainClassification saveMainClass(MainClassification mainClassification) {
		MainClassification mainClass = modelMapper.map(mainClassification, MainClassification.class);
		return mainClassServiceImpl.save(mainClass);
	}

	public MainClassificationDTO getMainClass(Long mainClassId) {
		return MainClassToMainClassDTO(mainClassServiceImpl.getMainClassificationById(mainClassId));
	}

}
