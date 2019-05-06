package com.sgic.library.dtomapper;

import com.sgic.library.entity.SubClassification;
import com.sgic.library.model.SubClassificationModel;

public class SubClassificationDtoMapper {

	public SubClassificationDtoMapper(SubClassification subClassification) {
		
		SubClassificationModel subClassificationModel = new SubClassificationModel();
		
		subClassificationModel.setSubClassId(subClassification.getSubClassId());
		subClassificationModel.setSubClassName(subClassification.getSubClassName());
		subClassificationModel.setMainClassId(subClassification.getMainClassification().getMainClassId());
		
		return;
		
	}
}
