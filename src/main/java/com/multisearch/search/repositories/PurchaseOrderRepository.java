package com.multisearch.search.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multisearch.search.entities.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, String>{

}
