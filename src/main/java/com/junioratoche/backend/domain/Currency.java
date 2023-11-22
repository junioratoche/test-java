package com.junioratoche.backend.domain;

public enum Currency {

	USD("USD"), EUR("EUR");

	private final String description;

	Currency(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
