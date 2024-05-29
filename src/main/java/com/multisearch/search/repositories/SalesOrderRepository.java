package com.multisearch.search.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multisearch.search.entities.SalesOrder;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

}
