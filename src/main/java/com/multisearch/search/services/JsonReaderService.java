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

    /**
     * Lê uma lista de objetos Equipment de um arquivo JSON.
     *
     * @param filePath o caminho do arquivo JSON
     * @return uma lista de objetos Equipment
     * @throws IOException se ocorrer um erro de leitura do arquivo
     */
    public List<Equipment> readEquipmentsFromJson(String filePath) throws IOException {
        File file = new File(filePath);
        return objectMapper.readValue(file, new TypeReference<List<Equipment>>() {});
    }

    /**
     * Lê uma lista de objetos Material de um arquivo JSON.
     *
     * @param filePath o caminho do arquivo JSON
     * @return uma lista de objetos Material
     * @throws IOException se ocorrer um erro de leitura do arquivo
     */
    public List<Material> readMaterialFromJson(String filePath) throws IOException {
        File file = new File(filePath);
        return objectMapper.readValue(file, new TypeReference<List<Material>>() {});
    }

    /**
     * Lê uma lista de objetos PurchaseOrder de um arquivo JSON.
     *
     * @param filePath o caminho do arquivo JSON
     * @return uma lista de objetos PurchaseOrder
     * @throws IOException se ocorrer um erro de leitura do arquivo
     */
    public List<PurchaseOrder> readPurchaseFromJson(String filePath) throws IOException {
        File file = new File(filePath);
        return objectMapper.readValue(file, new TypeReference<List<PurchaseOrder>>() {});
    }

    /**
     * Lê uma lista de objetos SalesOrder de um arquivo JSON.
     *
     * @param filePath o caminho do arquivo JSON
     * @return uma lista de objetos SalesOrder
     * @throws IOException se ocorrer um erro de leitura do arquivo
     */
    public List<SalesOrder> readSalesFromJson(String filePath) throws IOException {
        File file = new File(filePath);
        return objectMapper.readValue(file, new TypeReference<List<SalesOrder>>() {});
    }

    /**
     * Lê uma lista de objetos Workforce de um arquivo JSON.
     *
     * @param filePath o caminho do arquivo JSON
     * @return uma lista de objetos Workforce
     * @throws IOException se ocorrer um erro de leitura do arquivo
     */
    public List<Workforce> readWorkforceFromJson(String filePath) throws IOException {
        File file = new File(filePath);
        return objectMapper.readValue(file, new TypeReference<List<Workforce>>() {});
    }

    /**
     * Lê uma lista de objetos de um arquivo JSON, especificando o tipo de entidade.
     *
     * @param <T> o tipo de entidade
     * @param filePath o caminho do arquivo JSON
     * @param entityType a classe do tipo de entidade
     * @return uma lista de objetos do tipo especificado
     * @throws IOException se ocorrer um erro de leitura do arquivo
     */
    public <T> List<T> readFromJson(String filePath, Class<T> entityType) throws IOException {
        File file = new File(filePath);
        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, entityType));
    }

    /**
     * Lê todas as entidades de vários arquivos JSON e realiza a busca com base em uma palavra-chave.
     *
     * @param keyword a palavra-chave para a busca
     * @return um mapa contendo listas de entidades que correspondem à palavra-chave, agrupadas pelo nome da entidade
     * @throws IOException se ocorrer um erro de leitura dos arquivos
     */
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

    /**
     * Adiciona uma lista de entidades ao mapa de resultados se a lista contiver entidades que correspondem à palavra-chave.
     *
     * @param <T> o tipo de entidade
     * @param results o mapa de resultados
     * @param entityName o nome da entidade
     * @param entities a lista de entidades
     * @param keyword a palavra-chave para a busca
     */
    private <T> void addToResults(Map<String, List<Object>> results, String entityName, List<T> entities, String keyword) {
        List<Object> filteredEntities = new ArrayList<>(searchInEntityList(entities, keyword));
        if (!filteredEntities.isEmpty()) {
            results.put(entityName, filteredEntities);
        }
    }

    /**
     * Realiza a busca em uma lista de entidades com base em uma palavra-chave.
     *
     * @param <T> o tipo de entidade
     * @param entityList a lista de entidades
     * @param keyword a palavra-chave para a busca
     * @return uma lista filtrada de entidades que correspondem à palavra-chave
     */
    private <T> List<T> searchInEntityList(List<T> entityList, String keyword) {
        List<T> filteredList = new ArrayList<>();
        for (T entity : entityList) {
            if (matchesKeyword(entity, keyword)) {
                filteredList.add(entity);
            }
        }
        return filteredList;
    }

    /**
     * Verifica se uma entidade corresponde à palavra-chave, normalizando ambas as strings antes da comparação.
     *
     * @param <T> o tipo de entidade
     * @param entity a entidade a ser verificada
     * @param keyword a palavra-chave para a busca
     * @return true se a entidade corresponder à palavra-chave, false caso contrário
     */
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

    /**
     * Normaliza uma string removendo acentos e espaços, e convertendo para minúsculas.
     *
     * @param input a string a ser normalizada
     * @return a string normalizada
     */
    private String normalizeString(String input) {
        // Normaliza para remover marcas diacríticas e converter para minúsculas
        String normalized = Normalizer.normalize(input, Form.NFD);
        Pattern diacriticalPattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        normalized = diacriticalPattern.matcher(normalized).replaceAll("").toLowerCase();

        // Remove todos os espaços
        normalized = normalized.replaceAll("\\s+", "");

        return normalized;
    }
}
