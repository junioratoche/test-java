package com.junioratoche.backend.adapter.out.db.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

import com.junioratoche.backend.adapter.out.db.entity.BrandEntity;
import com.junioratoche.backend.adapter.out.db.entity.PriceEntity;
import com.junioratoche.backend.domain.Brand;
import com.junioratoche.backend.domain.Currency;
import com.junioratoche.backend.domain.Price;
import com.junioratoche.backend.domain.Product;

public class PriceEntityMapperTest {

	private PriceEntityMapper mapper;

	@BeforeEach
	public void setUp() {
		mapper = Mappers.getMapper(PriceEntityMapper.class);
	}

	@Test
	public void shouldMapPriceEntityToPrice() {
		PriceEntity priceEntity = new PriceEntity();
		priceEntity.setProductId(35455);

		BrandEntity brand = new BrandEntity();
		brand.setId(1);
		priceEntity.setBrand(brand);
		priceEntity.setPriceList(1);
		priceEntity.setStartDate(LocalDateTime.of(2020, 06, 14, 0, 0, 0));
		priceEntity.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		priceEntity.setPrice(35.50);
		priceEntity.setCurr("EUR");

		Price price = mapper.priceEntityToPrice(priceEntity);

		assertEquals(35455, price.getProduct().getProductId());
		assertEquals(1, price.getBrand().getBrandId());
		assertEquals(1, price.getPriceList());
		assertEquals(LocalDateTime.of(2020, 06, 14, 0, 0, 0), price.getStartDate());
		assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), price.getEndDate());
		assertEquals(35.50, price.getPriceValue());
		assertEquals(Currency.EUR, price.getCurrency());
	}

	@Test
	public void shouldMapPriceToPriceEntity() {
		Price price = new Price();
		price.setPriceList(1);
		price.setStartDate(LocalDateTime.of(2020, 06, 14, 0, 0, 0));
		price.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		price.setPriceValue(35.50);
		price.setCurrency(Currency.EUR);

		Product product = new Product();
		product.setProductId(35455);
		price.setProduct(product);

		Brand brand = new Brand();
		brand.setBrandId(1);
		price.setBrand(brand);

		PriceEntity priceEntity = mapper.priceToPriceEntity(price);

		assertEquals(35455, priceEntity.getProductId());
		assertEquals(1, priceEntity.getBrand().getId());
		assertEquals(1, priceEntity.getPriceList());
		assertEquals(LocalDateTime.of(2020, 06, 14, 0, 0, 0), priceEntity.getStartDate());
		assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), priceEntity.getEndDate());
		assertEquals(0, priceEntity.getPriority());
		assertEquals(35.50, priceEntity.getPrice());
		assertEquals("EUR", priceEntity.getCurr());
	}

	@Test
	public void shouldReturnNullWhenPriceIsNull() {
		Price price = null;

		PriceEntity priceEntity = mapper.priceToPriceEntity(price);
		assertNull(priceEntity, "The mapping of a null Price object should result in a null PriceEntity.");
	}

	@Test
	public void shouldReturnNullWhenPriceEntityIsNull() {
		PriceEntity priceEntity = null;

		Price price = mapper.priceEntityToPrice(priceEntity);
		assertNull(price, "The mapping of a null PriceEntity should result in a null Price object.");
	}

}
