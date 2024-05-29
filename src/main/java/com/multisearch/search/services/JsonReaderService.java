package com.multisearch.search.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multisearch.search.entities.Equipment;
import com.multisearch.search.entities.Material;
import com.multisearch.search.entities.PurchaseOrder;
import com.multisearch.search.entities.SalesOrder;
import com.multisearch.search.entities.Workforce;

@Service
public class JsonReaderService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Equipment> readEquipmentsFromJson(String filePath) throws IOException {
        File file = new File(filePath);
        return objectMapper.readValue(file, new TypeReference<List<Equipment>>() {});
    }
    
    public List<Material> readMaterialFromJson(String filePath) throws IOException {
        File file = new File(filePath);
        return objectMapper.readValue(file, new TypeReference<List<Material>>() {});
    }
    
    public List<PurchaseOrder> readPurchaseFromJson(String filePath) throws IOException {
    	File file = new File(filePath);
    	return objectMapper.readValue(file, new TypeReference<List<PurchaseOrder>>() {});
    }
    
    public List<SalesOrder> readSalesFromJson(String filePath) throws IOException {
        File file = new File(filePath);
        return objectMapper.readValue(file, new TypeReference<List<SalesOrder>>() {});
    }
    
    public List<Workforce> readWorkforceFromJson(String filePath) throws IOException {
    	File file = new File(filePath);
    	return objectMapper.readValue(file, new TypeReference<List<Workforce>>() {});
    }
}
