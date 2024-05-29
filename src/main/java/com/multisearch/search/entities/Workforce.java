package com.multisearch.search.entities;

import java.io.Serializable;
import java.util.Objects;

public class Workforce implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String shift;
	
	public Workforce() {
	}

	public Workforce(Long id, String name, String shift) {
		super();
		this.id = id;
		this.name = name;
		this.shift = shift;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
