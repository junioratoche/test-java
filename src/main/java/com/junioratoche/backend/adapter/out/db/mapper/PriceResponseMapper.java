package com.junioratoche.backend.adapter.out.db.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;
import com.junioratoche.backend.adapter.out.db.dto.PriceResponse;
import com.junioratoche.backend.domain.Price;

@Mapper(componentModel = "spring")
@Component
public interface PriceResponseMapper {

	@Mappings({ @Mapping(source = "product.productId", target = "productId"),
			@Mapping(source = "brand.brandId", target = "brandId"),
			@Mapping(source = "priceList", target = "priceList"), @Mapping(source = "startDate", target = "startDate"),
			@Mapping(source = "endDate", target = "endDate"), @Mapping(source = "price", target = "price"),
			@Mapping(source = "currency", target = "currency") })
	PriceResponse priceToPriceResponse(Price findById);

	List<PriceResponse> priceListToPriceResponseList(List<Price> priceList);

	@InheritInverseConfiguration
	Price priceResponseToPrice(PriceResponse source);
}
