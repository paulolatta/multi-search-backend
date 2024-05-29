package com.multisearch.search.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multisearch.search.entities.Workforce;
import com.multisearch.search.repositories.WorkforceRepository;

@Service
public class WorkforceService {
	@Autowired
	private WorkforceRepository repository;
	
	public List<Workforce> findAll(){
		return repository.findAll();
	}
}
