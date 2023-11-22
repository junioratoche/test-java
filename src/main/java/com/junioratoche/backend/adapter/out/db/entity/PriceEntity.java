package com.junioratoche.backend.adapter.out.db.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prices")
public class PriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "brand_Id")
	private BrandEntity brand;
	@Column(name = "start_Date")
	private LocalDateTime startDate;
	@Column(name = "end_Date")
	private LocalDateTime endDate;
	@Column(name = "price_List")
	private Integer priceList;
	@Column(name = "product_Id")
	private Integer productId;
	private Integer priority;
	private BigDecimal price;
	private String curr;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
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

	public Integer getPriceList() {
		return priceList;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

}
