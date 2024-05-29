package com.multisearch.search.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_purchaseOrder")
public class PurchaseOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant deliveryDate;
	private String supplier;
	
	@ManyToOne
	@JoinColumn(name = "material_id")
	private Material material;
	private Integer quantity;
	private Double totalValue;
	
	public PurchaseOrder() {
	}

	public PurchaseOrder(Long id, Instant deliveryDate, String supplier, Material material, Integer quantity,
			Double totalValue) {
		super();
		this.id = id;
		this.deliveryDate = deliveryDate;
		this.supplier = supplier;
		this.material = material;
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

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
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
		PurchaseOrder other = (PurchaseOrder) obj;
		return Objects.equals(id, other.id);
	}
}
