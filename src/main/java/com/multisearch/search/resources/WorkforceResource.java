package com.multisearch.search.resources;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multisearch.search.entities.Workforce;
import com.multisearch.search.services.WorkforceService;

@RestController
@RequestMapping(value = "/workforce")
public class WorkforceResource {
	@Autowired
    private WorkforceService workforceService;
	
	@GetMapping
    public ResponseEntity<List<Workforce>> findAll() {
        List<Workforce> list;
        try {
            String filePath = "src/main/resources/data/workforce.json";
            list = workforceService.readWorkforceFromJson(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().body(list);
    }
}
