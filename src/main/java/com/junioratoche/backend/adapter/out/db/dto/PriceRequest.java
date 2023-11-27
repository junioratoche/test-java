package com.junioratoche.backend.adapter.out.db.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PriceRequest {
	
	//Use in case input data is sent by body

	@NotNull(message = "The application date cannot be null and void.")
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}-\\d{2}\\.\\d{2}\\.\\d{2}", message = "Invalid date format. Use yyyy-MM-dd-HH.mm.ss format.")
	private String applicationDate;

	@NotNull(message = "The product ID cannot be null.")
	private Integer productId;

	@NotNull(message = "The brand ID cannot be null.")
	private Integer brandId;

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

}
