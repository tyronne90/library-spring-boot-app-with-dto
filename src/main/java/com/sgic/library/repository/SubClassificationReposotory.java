package com.sgic.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.library.entity.SubClassification;

public interface SubClassificationReposotory  extends JpaRepository<SubClassification, String> {
	SubClassification findSubClassificationBySubClassId(String subClassId);
}
