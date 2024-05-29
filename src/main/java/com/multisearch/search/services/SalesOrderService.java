package com.multisearch.search.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multisearch.search.entities.SalesOrder;
import com.multisearch.search.repositories.SalesOrderRepository;

@Service
public class SalesOrderService {
	@Autowired
	private SalesOrderRepository repository;
	
	public List<SalesOrder> findAll(){
		return repository.findAll();
	}
}
