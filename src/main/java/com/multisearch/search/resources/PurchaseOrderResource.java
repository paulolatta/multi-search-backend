package com.multisearch.search.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multisearch.search.entities.PurchaseOrder;
import com.multisearch.search.services.PurchaseOrderService;

@RestController
@RequestMapping(value = "/purchase_order")
public class PurchaseOrderResource {
	@Autowired
	private PurchaseOrderService service;

	@GetMapping
	public ResponseEntity<List<PurchaseOrder>> findAll() {
		List<PurchaseOrder> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
