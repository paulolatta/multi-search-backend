package com.multisearch.search.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multisearch.search.entities.Workforce;
import com.multisearch.search.services.WorkforceService;

@RestController
@RequestMapping(value = "/workforce")
public class WorkforceResource {
	@Autowired
	private WorkforceService service;
	
	
	@GetMapping
	public ResponseEntity<List<Workforce>> findAll() {
		List<Workforce> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
