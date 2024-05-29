package com.multisearch.search.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multisearch.search.entities.Equipment;
import com.multisearch.search.repositories.EquipmentRepository;

@Service
public class EquipmentService {
	@Autowired
	private EquipmentRepository repository;
	
	public List<Equipment> findAll(){
		return repository.findAll();
	}

}
