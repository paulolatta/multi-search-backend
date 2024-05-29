package com.multisearch.search.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Workforce implements Serializable { 	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("WorkforceID")
	private String id;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Shift")
	private String shift;
	
	public Workforce() {
	}

	public Workforce(String id, String name, String shift) {
		super();
		this.id = id;
		this.name = name;
		this.shift = shift;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
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
		Workforce other = (Workforce) obj;
		return Objects.equals(id, other.id);
	}
}
