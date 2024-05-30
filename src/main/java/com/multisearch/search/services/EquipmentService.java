package com.multisearch.search.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multisearch.search.entities.Equipment;

@Service
public class EquipmentService {
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
}
