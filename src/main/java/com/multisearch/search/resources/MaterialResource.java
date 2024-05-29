package com.multisearch.search.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multisearch.search.entities.Material;
import com.multisearch.search.services.MaterialService;

@RestController
@RequestMapping(value = "/materials")
public class MaterialResource {
	@Autowired
	private MaterialService service;

	@GetMapping
	public ResponseEntity<List<Material>> findAll() {
		List<Material> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
