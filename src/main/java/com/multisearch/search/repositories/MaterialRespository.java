package com.multisearch.search.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multisearch.search.entities.Material;

public interface MaterialRespository extends JpaRepository<Material, String>{

}
