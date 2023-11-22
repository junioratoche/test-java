package com.junioratoche.backend.application;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.junioratoche.backend.domain.Price;
import com.junioratoche.backend.port.in.http.PriceInputPort;
import com.junioratoche.backend.port.out.db.EntityRepositoryOutputPort;

@Component
public class GetPriceUseCase implements PriceInputPort {

	@Autowired
	EntityRepositoryOutputPort entityRepositoryOutputPort;

	@Override
	public List<Price> getAll() {
		List<Price> priceList = entityRepositoryOutputPort.getAll();
		return priceList;
	}

	@Override
	public Price getPriceByBrandAndProductInApplicationDate(LocalDateTime applicationDate, int productId, int brandId) {
		Price price = entityRepositoryOutputPort.getPriceByBrandAndProductInApplicationDate(applicationDate, productId,
				brandId);
		return price;
	}

}
