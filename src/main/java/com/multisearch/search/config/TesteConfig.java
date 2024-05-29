package com.multisearch.search.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.multisearch.search.entities.Equipment;
import com.multisearch.search.entities.Material;
import com.multisearch.search.entities.PurchaseOrder;
import com.multisearch.search.entities.SalesOrder;
import com.multisearch.search.entities.Workforce;
import com.multisearch.search.repositories.EquipmentRepository;
import com.multisearch.search.repositories.MaterialRespository;
import com.multisearch.search.repositories.SalesOrderRepository;
import com.multisearch.search.repositories.PurchaseOrderRepository;
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
	@Autowired
	private SalesOrderRepository salesOrderRepository;
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Override
	public void run(String... args) throws Exception {
		// Equipment e1 = new Equipment("1", "Equi 1");
		// Material m1 = new Material(null, "material 1");
		// Workforce w1 = new Workforce(null, "Workforce 1", "1");
		// SalesOrder sl1 = new SalesOrder(null, Instant.parse("2024-05-28T15:21:22Z"), "Customer 1", m1, 3, 22.00);
		// PurchaseOrder po1 = new PurchaseOrder(null, Instant.parse("2024-05-28T15:21:22Z"), "suppier 1", m1, 3, 22.00);

		// equipmentRepository.saveAll(Arrays.asList(e1));
		// materialRespository.saveAll(Arrays.asList(m1));
		// workforceRepository.saveAll(Arrays.asList(w1));
		// salesOrderRepository.saveAll(Arrays.asList(sl1));
		// purchaseOrderRepository.saveAll(Arrays.asList(po1));
	}
	
}
