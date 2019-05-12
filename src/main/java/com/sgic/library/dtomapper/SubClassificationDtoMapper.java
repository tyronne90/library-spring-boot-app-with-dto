package com.sgic.library.dtomapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.library.dto.SubClassificationDTO;
import com.sgic.library.entity.SubClassification;
import com.sgic.library.service.SubClassificationServiceImplement;

@Service
public class SubClassificationDTOMapper {
	
	@Autowired
	SubClassificationServiceImplement subClassServiceImpl;
	
//-----------------Without using ModelMapper ----------------	
	
//	public static SubClassificationDTO SubClassToSubClassDTO(SubClassification subClass) {
//		SubClassificationDTO subClassDTO = new SubClassificationDTO();
//		subClassDTO.setSubClassId(subClass.getSubClassId());
//		subClassDTO.setSubClassName(subClass.getSubClassName());
//		subClassDTO.setMainClassId(subClass.getMainClassification().getMainClassId());
//		return subClassDTO;
//	}
//	
//	public static SubClassification SubClassDTOToSubClass(SubClassificationDTO subClassDTO) {
//		SubClassification subClass = new SubClassification();
//		subClass.setSubClassId(subClassDTO.getSubClassId());
//		subClass.setSubClassName(subClassDTO.getSubClassName());
//		MainClassification mainClass = new MainClassification();
//		mainClass.setMainClassId(subClassDTO.getMainClassId());
//		subClass.setMainClassification(mainClass);
//		return subClass;
//	}
	
	
	ModelMapper modelMapper = new ModelMapper();
	
	private SubClassificationDTO EntityToDTO(SubClassification subClass) {
		SubClassificationDTO subClassDTO = modelMapper.map(subClass, SubClassificationDTO.class);
		return subClassDTO;
	}
	
	public List<SubClassificationDTO> getAllSubClass(){
		List<SubClassification> subClass = subClassServiceImpl.getAllSubClass();
		java.lang.reflect.Type listType = new TypeToken<List<SubClassificationDTO>>() {}.getType();
		List<SubClassificationDTO> returnValue = new ModelMapper().map(subClass, listType);
		return returnValue;
	}
	
	public SubClassificationDTO getSubClassById(String subClassId) {
		return EntityToDTO(subClassServiceImpl.getSubClassificationBySubClassId(subClassId));
	}
	
	public SubClassification saveSubClass(SubClassificationDTO subClassDTO) {
		SubClassification subClass = modelMapper.map(subClassDTO, SubClassification.class);
		return subClassServiceImpl.save(subClass);
	}
	
	public SubClassificationDTO deleteSubClassification(String subClassId) {
		subClassServiceImpl.deleteSubClassificationById(subClassId);
		return null;
	}
	
	public void updateSubClassification(SubClassificationDTO subClassDTO) {
		SubClassification subClass = modelMapper.map(subClassDTO, SubClassification.class);
		EntityToDTO(subClassServiceImpl.save(subClass));
	}
	
}
