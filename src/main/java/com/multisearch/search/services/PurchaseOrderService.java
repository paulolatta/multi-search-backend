package com.multisearch.search.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multisearch.search.entities.PurchaseOrder;
import com.multisearch.search.repositories.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {
	@Autowired
	private PurchaseOrderRepository repository;
	
	public List<PurchaseOrder> findAll(){
		return repository.findAll();
	}
}
