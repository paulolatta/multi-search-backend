package com.multisearch.search.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multisearch.search.entities.Material;
import com.multisearch.search.repositories.MaterialRespository;

@Service
public class MaterialService {
	@Autowired
	private MaterialRespository repository;
	
	public List<Material> findAll(){
		return repository.findAll();
	}
}
