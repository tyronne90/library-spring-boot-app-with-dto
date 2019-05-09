package com.sgic.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.library.dto.MainClassificationDTO;
import com.sgic.library.entity.MainClassification;

public interface MainClassificationRepository extends JpaRepository<MainClassification, Long> {
	MainClassification findMainClassificationByMainClassId(Long mainClassId);
	MainClassification save(MainClassificationDTO mainClassDTO);
}
