package com.multisearch.search.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multisearch.search.entities.Material;

@Service
public class MaterialService {
    private final ObjectMapper objectMapper = new ObjectMapper();

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
}
