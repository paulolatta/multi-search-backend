package com.multisearch.search.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multisearch.search.entities.Material;

@RestController
@RequestMapping(value = "/materials")
public class MaterialResource {
	@GetMapping
	public ResponseEntity<Material> findAll() {
		Material m = new Material(1L, "Material teste");
		return ResponseEntity.ok().body(m);
	}
}
