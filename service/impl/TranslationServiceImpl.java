package com.translationservice.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.translationservice.application.entity.TranslationsEntity;
import com.translationservice.application.exception.ResourceNotFoundException;
import com.translationservice.application.repository.TranslationsRepository;
import com.translationservice.application.service.TranslationService;

@Service
public class TranslationServiceImpl implements TranslationService {

	@Autowired
	TranslationsRepository repository;

	@Override
	public TranslationsEntity create(TranslationsEntity translation) {
		return repository.save(translation);
	}

	@Override
	public TranslationsEntity update(Long id, TranslationsEntity translation) {
		TranslationsEntity existing = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Translation not found"));
		existing.setKeyy(translation.getKeyy());
		existing.setLocale(translation.getLocale());
		existing.setValue(translation.getValue());
		existing.setTag(translation.getTag());
		existing.setContext(translation.getContext());
		return repository.save(existing);
	}

	@Override
	public List<TranslationsEntity> getAll() {
		return repository.findAll();
	}

	@Override
	public List<TranslationsEntity> search(String query) {
		return repository.findByKeyyContainingOrValueContaining(query, query);
	}

	@Override
	public List<TranslationsEntity> exportJson(String locale) {
		return repository.findByLocale(locale);
	}

}
