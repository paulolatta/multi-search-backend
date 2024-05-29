package com.multisearch.search.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multisearch.search.entities.Workforce;

@RestController
@RequestMapping(value = "/workforce")
public class WorkforceResource {
	@GetMapping
	public ResponseEntity<Workforce> findAll() {
		Workforce w = new Workforce(1L, "Teste workforce", "Turno A");
		return ResponseEntity.ok().body(w);
	}
}
