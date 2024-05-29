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

@Entity
public class PurchaseOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("PurchaseOrderID")
	private String id;
	
    @JsonDeserialize(using = CustomDateDeserializer.class)
	@JsonProperty("DeliveryDate")
	private Instant deliveryDate;
	@JsonProperty("Supplier")
	private String supplier;
	
	@JsonProperty("MaterialID")
	private String materialId;
	@JsonProperty("MaterialName")
	private String materialName;
	
	@JsonProperty("Quantity")
	private Integer quantity;
	@JsonProperty("TotalCost")
	private Double totalValue;
	
	public PurchaseOrder() {
	}

	public PurchaseOrder(String id, Instant deliveryDate, String supplier, String materialId, String materialName,
			Integer quantity, Double totalValue) {
		super();
		this.id = id;
		this.deliveryDate = deliveryDate;
		this.supplier = supplier;
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

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		PurchaseOrder other = (PurchaseOrder) obj;
		return Objects.equals(id, other.id);
	}	
}
