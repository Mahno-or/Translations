package com.translationservice.application.service;

import java.util.List;

import com.translationservice.application.entity.TranslationsEntity;

public interface TranslationService {

	TranslationsEntity create(TranslationsEntity translation);

	TranslationsEntity update(Long id, TranslationsEntity translation);

	List<TranslationsEntity> getAll();

	List<TranslationsEntity> search(String query);

	List<TranslationsEntity> exportJson(String locale);

}
