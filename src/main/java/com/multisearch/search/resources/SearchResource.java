package com.multisearch.search.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multisearch.search.services.JsonReaderService;

@RestController
@RequestMapping(value = "/search")
public class SearchResource {
	 @Autowired
	    private JsonReaderService jsonReaderService;

	    @GetMapping
	    public ResponseEntity<Map<String, List<Object>>> searchAll(@RequestParam String keyword) {
	        Map<String, List<Object>> results;
	        try {
	            results = jsonReaderService.readAllEntities(keyword);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return ResponseEntity.internalServerError().build();
	        }
	        return ResponseEntity.ok().body(results);
	    }
}
