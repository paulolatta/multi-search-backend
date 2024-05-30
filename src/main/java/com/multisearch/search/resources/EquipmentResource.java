package com.multisearch.search.resources;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multisearch.search.entities.Equipment;
import com.multisearch.search.services.EquipmentService;

@RestController
@RequestMapping(value = "/equipments")
public class EquipmentResource {
	@Autowired
	private EquipmentService equipmentService;
	
	@GetMapping
    public ResponseEntity<List<Equipment>> findAll() {
        List<Equipment> list;
        try {
            String filePath = "src/main/resources/data/equipments.json";
            list = equipmentService.readEquipmentsFromJson(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().body(list);
    }
}
