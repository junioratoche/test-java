package com.junioratoche.backend.adapter.out.db.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "PriceResponse", description = "Model representing the price consulted")
public class PriceResponse {

	@Schema(name = "productId", example = "35455", description = "Identifier product code")
	private Long productId;
	@Schema(name = "brandId", example = "1", description = "Brand identifier")
	private Long brandId;
	@Schema(name = "priceList", example = "1", description = "Applicable price rate identifier")
	private Integer priceList;
	@Schema(name = "startDate", example = "2020-06-14-00.00.00", description = "Start date of the date range to which the price rate applies")
	private LocalDateTime startDate;
	@Schema(name = "endDate", example = "2020-12-31-23.59.59", description = "End date of the date range in which the price rate applies")
	private LocalDateTime endDate;
	@Schema(name = "price", example = "35.50", description = "Final sales price")
	private Double price;
	@Schema(name = "currency", example = "EUR", description = "ISO of the currency")
	private String currency;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Integer getPriceList() {
		return priceList;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
