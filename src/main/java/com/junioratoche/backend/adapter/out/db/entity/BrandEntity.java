package com.junioratoche.backend.adapter.out.db.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "brand")
public class BrandEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "brand")
	private List<PriceEntity> prices;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PriceEntity> getPrices() {
		return prices;
	}

	public void setPrices(List<PriceEntity> prices) {
		this.prices = prices;
	}

}