package com.multisearch.search.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multisearch.search.entities.Equipment;

@RestController
@RequestMapping(value = "/equipments")
public class EquipmentResource {
	@GetMapping
	public ResponseEntity<Equipment> findAll() {
		Equipment e = new Equipment(1L, "Teste");
		return ResponseEntity.ok().body(e);
	}
}
