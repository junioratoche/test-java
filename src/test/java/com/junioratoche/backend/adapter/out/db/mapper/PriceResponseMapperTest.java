package com.junioratoche.backend.adapter.out.db.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.junioratoche.backend.adapter.out.db.dto.PriceResponse;
import com.junioratoche.backend.domain.Brand;
import com.junioratoche.backend.domain.Currency;
import com.junioratoche.backend.domain.Price;
import com.junioratoche.backend.domain.Product;

public class PriceResponseMapperTest {

	private PriceResponseMapper mapper;

	@BeforeEach
	public void setUp() {
		mapper = Mappers.getMapper(PriceResponseMapper.class);
	}

	@Test
	public void shouldMapPriceToPriceResponse() {
		Price price = new Price();
		price.setProduct(new Product());
		price.getProduct().setProductId(35455);
		price.setBrand(new Brand());
		price.getBrand().setBrandId(1);
		price.setPriceList(1);
		price.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
		price.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		price.setPriceValue(35.50);
		price.setCurrency(Currency.EUR);

		PriceResponse priceResponse = mapper.priceToPriceResponse(price);

		assertEquals(35455, priceResponse.getProductId());
		assertEquals(1, priceResponse.getBrandId());
		assertEquals(1, priceResponse.getPriceList());
		assertEquals(LocalDateTime.of(2020, 6, 14, 0, 0), priceResponse.getStartDate());
		assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), priceResponse.getEndDate());
		assertEquals(35.50, priceResponse.getPrice());
		assertEquals("EUR", priceResponse.getCurrency());
	}

	@Test
	public void shouldMapPriceListToPriceResponseList() {
		Price price = new Price();
		price.setPriceList(1);
		price.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
		price.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		price.setPriceValue(35.50);
		price.setCurrency(Currency.EUR);

		Product product = new Product();
		product.setProductId(35455);
		price.setProduct(product);

		Brand brand = new Brand();
		brand.setBrandId(1);
		price.setBrand(brand);

		List<Price> prices = Arrays.asList(price);

		List<PriceResponse> priceResponses = mapper.priceListToPriceResponseList(prices);
		assertNotNull(priceResponses);
		assertFalse(priceResponses.isEmpty());

		PriceResponse firstResponse = priceResponses.get(0);
		assertEquals(35455, firstResponse.getProductId().intValue());
		assertEquals(1, firstResponse.getBrandId().intValue());
		assertEquals(1, firstResponse.getPriceList().intValue());
		assertEquals(LocalDateTime.of(2020, 6, 14, 0, 0), firstResponse.getStartDate());
		assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), firstResponse.getEndDate());
		assertEquals(35.50, firstResponse.getPrice());
		assertEquals("EUR", firstResponse.getCurrency());
	}

	@Test
	public void shouldMapPriceResponseToPrice() {
		PriceResponse priceResponse = new PriceResponse();
		priceResponse.setProductId(35455L);
		priceResponse.setBrandId(1L);
		priceResponse.setPriceList(1);
		priceResponse.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
		priceResponse.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		priceResponse.setPrice(35.50);
		priceResponse.setCurrency("EUR");

		Price price = mapper.priceResponseToPrice(priceResponse);

		assertEquals(35455, price.getProduct().getProductId());
		assertEquals(1, price.getBrand().getBrandId());
		assertEquals(1, price.getPriceList());
		assertEquals(LocalDateTime.of(2020, 6, 14, 0, 0), price.getStartDate());
		assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), price.getEndDate());
		assertEquals(35.50, price.getPriceValue());
		assertEquals(Currency.EUR, price.getCurrency());
	}

	@Test
	public void shouldReturnNullWhenPriceListIsNull() {
		List<Price> priceList = null;

		List<PriceResponse> priceResponses = mapper.priceListToPriceResponseList(priceList);
		assertNull(priceResponses, "The mapping of a null price list should result in a null response list.");
	}

	@Test
	public void shouldReturnNullWhenPriceResponseIsNull() {
		PriceResponse priceResponse = null;

		Price price = mapper.priceResponseToPrice(priceResponse);
		assertNull(price, "The mapping of a null PriceResponse should result in a null Price object.");
	}

}
