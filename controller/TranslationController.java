package com.translationservice.application.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.translationservice.application.entity.TranslationsEntity;
import com.translationservice.application.service.TranslationService;
import com.translationservice.application.util.Routes;

@RestController
//@RequestMapping("/translations")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TranslationController {

	@Autowired
	TranslationService service;

	@PostMapping(value = Routes.CREATE, consumes = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=UTF-8", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	public ResponseEntity<TranslationsEntity> create(@RequestBody TranslationsEntity translation) {
		return ResponseEntity.ok(service.create(translation));
	}

	@PutMapping(value = Routes.UPDATE + "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=UTF-8", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	public ResponseEntity<TranslationsEntity> update(@PathVariable Long id,
			@RequestBody TranslationsEntity translation) {
		return ResponseEntity.ok(service.update(id, translation));
	}

	@GetMapping(value = Routes.VIEW, consumes = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=UTF-8", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	public ResponseEntity<List<TranslationsEntity>> getAll(@RequestParam(required = false) String query) {
		return ResponseEntity.ok(query == null ? service.getAll() : service.search(query));
	}

	@GetMapping(value = Routes.EXPORT + "/{locale}", consumes = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=UTF-8", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	public ResponseEntity<Map<String, String>> export(@PathVariable String locale) {
		List<TranslationsEntity> list = service.exportJson(locale);
		Map<String, String> map = new HashMap<>();
		for (TranslationsEntity t : list) {
			map.put(t.getKeyy(), t.getValue());
		}
		return ResponseEntity.ok(map);
	}

}
