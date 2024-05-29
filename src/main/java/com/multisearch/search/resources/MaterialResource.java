package com.multisearch.search.resources;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multisearch.search.entities.Material;
import com.multisearch.search.services.JsonReaderService;

@RestController
@RequestMapping(value = "/materials")
public class MaterialResource {
	@Autowired
    private JsonReaderService jsonReaderService;

	@GetMapping
    public ResponseEntity<List<Material>> findAll() {
        List<Material> list;
        try {
            String filePath = "src/main/resources/data/materials.json";
            list = jsonReaderService.readMaterialFromJson(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().body(list);
    }
}
