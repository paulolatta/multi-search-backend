package com.multisearch.search.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.multisearch.search.utils.CustomDateDeserializer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_salesOrder")
public class SalesOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("SalesOrderID")
	private String id;
	
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@JsonProperty("DeliveryDate")
	private Instant deliveryDate;

	@JsonProperty("Customer")
	private String customer;
	@JsonProperty("MaterialID")
	private String materialId;
	@JsonProperty("MaterialName")
	private String materialName;
	@JsonProperty("Quantity")
	private Integer quantity;
	@JsonProperty("TotalValue")
	private Double totalValue;
	
	public SalesOrder() {
	}

	public SalesOrder(String id, Instant deliveryDate, String customer, String materialId, String materialName,
			Integer quantity, Double totalValue) {
		super();
		this.id = id;
		this.deliveryDate = deliveryDate;
		this.customer = customer;
		this.materialId = materialId;
		this.materialName = materialName;
		this.quantity = quantity;
		this.totalValue = totalValue;
	}

	public Instant getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Instant deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesOrder other = (SalesOrder) obj;
		return Objects.equals(id, other.id);
	}
}
