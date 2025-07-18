package com.translationservice.application.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.translationservice.application.entity.TranslationsEntity;
import com.translationservice.application.repository.TranslationsRepository;

@Configuration
public class TranslationSeeder {

	@Bean
	CommandLineRunner seed(TranslationsRepository repository) {
		return args -> {
			if (repository.count() == 0) {
				List<TranslationsEntity> translations = new ArrayList<>();
				for (int i = 0; i < 100000; i++) {
					translations.add(TranslationsEntity.builder().keyy("key_" + i).locale("en").value("value_" + i)
							.tag("web").context("mobile").build());
				}
				repository.saveAll(translations);
			}
		};
	}
}
