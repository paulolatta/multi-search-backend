package com.multisearch.search.services;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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

    public <T> List<T> readFromJson(String filePath, Class<T> entityType) throws IOException {
        File file = new File(filePath);
        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, entityType));
    }

    public Map<String, List<Object>> readAllEntities(String keyword) throws IOException {
        Map<String, List<Object>> results = new HashMap<>();

        String[] filePaths = {
            "src/main/resources/data/equipments.json",
            "src/main/resources/data/materials.json",
            "src/main/resources/data/purchase_orders.json",
            "src/main/resources/data/sales_orders.json",
            "src/main/resources/data/workforce.json"
        };

        for (String filePath : filePaths) {
            if (filePath.contains("equipments")) {
                List<Equipment> equipments = readFromJson(filePath, Equipment.class);
                addToResults(results, "Equipment", equipments, keyword);
            } else if (filePath.contains("materials")) {
                List<Material> materials = readFromJson(filePath, Material.class);
                addToResults(results, "Material", materials, keyword);
            } else if (filePath.contains("purchase_orders")) {
                List<PurchaseOrder> purchaseOrders = readFromJson(filePath, PurchaseOrder.class);
                addToResults(results, "PurchaseOrder", purchaseOrders, keyword);
            } else if (filePath.contains("sales_orders")) {
                List<SalesOrder> salesOrders = readFromJson(filePath, SalesOrder.class);
                addToResults(results, "SalesOrder", salesOrders, keyword);
            } else if (filePath.contains("workforce")) {
                List<Workforce> workforces = readFromJson(filePath, Workforce.class);
                addToResults(results, "Workforce", workforces, keyword);
            }
        }

        return results;
    }

    private <T> void addToResults(Map<String, List<Object>> results, String entityName, List<T> entities, String keyword) {
        List<Object> filteredEntities = new ArrayList<>(searchInEntityList(entities, keyword));
        if (!filteredEntities.isEmpty()) {
            results.put(entityName, filteredEntities);
        }
    }

    private <T> List<T> searchInEntityList(List<T> entityList, String keyword) {
        List<T> filteredList = new ArrayList<>();
        for (T entity : entityList) {
            if (matchesKeyword(entity, keyword)) {
                filteredList.add(entity);
            }
        }
        return filteredList;
    }

    private <T> boolean matchesKeyword(T entity, String keyword) {
        String normalizedKeyword = normalizeString(keyword);
        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(entity);
                if (value instanceof String) {
                    String normalizedValue = normalizeString((String) value);
                    if (normalizedValue.contains(normalizedKeyword)) {
                        return true;
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private String normalizeString(String input) {
        String normalized = Normalizer.normalize(input, Form.NFD);
        Pattern diacriticalPattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        normalized = diacriticalPattern.matcher(normalized).replaceAll("").toLowerCase();
        normalized = normalized.replaceAll("\\s+", "");

        return normalized;
    }
}
