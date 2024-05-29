package com.multisearch.search.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String text) {
		super("Resource not found. Text: " + text);
	}
}
