package com.multisearch.search.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multisearch.search.entities.Workforce;

public interface WorkforceRepository extends JpaRepository<Workforce, Long> {

}
