package com.junioratoche.backend.port.in.http;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.junioratoche.backend.domain.Price;

@Component
public interface PriceInputPort {

	List<Price> getAll();

	Price getPriceByBrandAndProductInApplicationDate(LocalDateTime applicationDate, int productId, int brandId);

}
