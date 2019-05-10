package com.sgic.library.dtomapper;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.library.dto.MainClassificationDTO;
import com.sgic.library.entity.MainClassification;
import com.sgic.library.service.MainClassificationServiceImplement;

@Service
public class MainClassificationDtoMapper {

	@Autowired
	private MainClassificationServiceImplement mainClassServiceImpl;
	
// ------------ Mapping that can use without ModelMapper------------

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
// -------------------------------------------------------------------------

	ModelMapper modelMapper = new ModelMapper();

	private MainClassificationDTO EntityToDTO(MainClassification mainClass) {
		MainClassificationDTO mainClassDTO = modelMapper.map(mainClass, MainClassificationDTO.class);
		return mainClassDTO;
	}

//	private MainClassification DTOtoEntity(MainClassificationDTO mainClassDTO) {
//		MainClassification mainClass = modelMapper.map(mainClassDTO, MainClassification.class);
//		return mainClass;
//	}
	

	public MainClassification saveMainClass(MainClassificationDTO mainClassDTO) {
		MainClassification mainClass = modelMapper.map(mainClassDTO, MainClassification.class);
		return mainClassServiceImpl.save(mainClass);
	}

	public MainClassificationDTO getMainClass(Long mainClassId) {
		return EntityToDTO(mainClassServiceImpl.getMainClassificationById(mainClassId));
	}
	
	public List<MainClassificationDTO> getAllMainClass(){
		List<MainClassification> mainClass = mainClassServiceImpl.getAllMainClass();
		java.lang.reflect.Type listType = new TypeToken<List<MainClassificationDTO>>() {}.getType();
		List<MainClassificationDTO> returnValue = new ModelMapper().map(mainClass, listType);
		return returnValue;
	}
	 

}
