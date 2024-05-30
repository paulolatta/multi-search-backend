package com.multisearch.search.resources;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multisearch.search.entities.SalesOrder;
import com.multisearch.search.services.SalesOrderService;

@RestController
@RequestMapping(value = "/sales_order")
public class SalesOrderResource {
	@Autowired
    private SalesOrderService salesOrderService;

	@GetMapping
    public ResponseEntity<List<SalesOrder>> findAll() {
        List<SalesOrder> list;
        try {
            String filePath = "src/main/resources/data/sales_orders.json";
            list = salesOrderService.readSalesFromJson(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().body(list);
    }

}
