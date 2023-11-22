package com.junioratoche.backend.port.out.db;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.junioratoche.backend.domain.Price;

@Component
public interface EntityRepositoryOutputPort {

	public List<Price> getAll();

	public Price getPriceByBrandAndProductInApplicationDate(LocalDateTime applicationDate, int productId, int brandId);
}
