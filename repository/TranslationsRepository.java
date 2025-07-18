package com.translationservice.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.translationservice.application.entity.TranslationsEntity;

@Repository
public interface TranslationsRepository extends JpaRepository<TranslationsEntity, Long> {
	List<TranslationsEntity> findByLocale(String locale);

	List<TranslationsEntity> findByTagContaining(String tag);

	List<TranslationsEntity> findByKeyyContainingOrValueContaining(String key, String value);
}
