package com.multisearch.search.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multisearch.search.entities.SalesOrder;
import com.multisearch.search.services.SalesOrderService;

@RestController
@RequestMapping(value = "/sales_order")
public class SalesOrderResource {
	@Autowired
	private SalesOrderService service;

	@GetMapping
	public ResponseEntity<List<SalesOrder>> findAll() {
		List<SalesOrder> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
