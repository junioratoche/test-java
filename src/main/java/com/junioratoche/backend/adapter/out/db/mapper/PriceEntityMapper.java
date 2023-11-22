package com.junioratoche.backend.adapter.out.db.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import com.junioratoche.backend.adapter.out.db.entity.PriceEntity;
import com.junioratoche.backend.domain.Price;

@Mapper(componentModel = "spring")
@Component
public interface PriceEntityMapper {

	@Mappings({ @Mapping(target = "product.productId", source = "productId"),
			@Mapping(target = "brand.brandId", source = "brand.id"),
			@Mapping(target = "priceList", source = "priceList"), @Mapping(target = "startDate", source = "startDate"),
			@Mapping(target = "endDate", source = "endDate"), @Mapping(target = "price", source = "price"),
			@Mapping(target = "currency", source = "curr") })
	Price priceEntityToPrice(PriceEntity priceEntity);

	@InheritInverseConfiguration
	PriceEntity priceToPriceEntity(Price price);
}
