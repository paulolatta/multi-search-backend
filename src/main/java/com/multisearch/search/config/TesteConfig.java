package com.multisearch.search.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.multisearch.search.entities.Equipment;
import com.multisearch.search.entities.Material;
import com.multisearch.search.entities.Workforce;
import com.multisearch.search.repositories.EquipmentRepository;
import com.multisearch.search.repositories.MaterialRespository;
import com.multisearch.search.repositories.WorkforceRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	@Autowired
	private EquipmentRepository equipmentRepository;
	@Autowired
	private MaterialRespository materialRespository;
	@Autowired
	private WorkforceRepository workforceRepository;

	@Override
	public void run(String... args) throws Exception {
		Equipment e1 = new Equipment(null, "Equi 1");
		Material m1 = new Material(null, "material 1");
		Workforce w1 = new Workforce(null, "Workforce 1", "1");
		

		equipmentRepository.saveAll(Arrays.asList(e1));
		materialRespository.saveAll(Arrays.asList(m1));
		workforceRepository.saveAll(Arrays.asList(w1));
	}
	
}
