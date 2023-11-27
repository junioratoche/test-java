package com.junioratoche.backend.adapter.in.http;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.junioratoche.backend.domain.Brand;
import com.junioratoche.backend.domain.Currency;
import com.junioratoche.backend.domain.Price;
import com.junioratoche.backend.domain.Product;
import com.junioratoche.backend.port.in.http.PriceInputPort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.hasSize;


@SpringBootTest
@AutoConfigureMockMvc
class HttpInputAdapterTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceInputPort priceInputPort;

    private List<Price> prices;

    @BeforeEach
    void setUp() {
    	
        prices = new ArrayList<>();
        prices.add(createPrice(1, "2020-06-14-00.00.00", "2020-12-31-23.59.59", 1, 35455, 0, 35.50, Currency.EUR));
        prices.add(createPrice(2, "2020-06-14-15.00.00", "2020-06-14-18.30.00", 1, 35455, 1, 25.45, Currency.EUR));
        prices.add(createPrice(3, "2020-06-15-00.00.00", "2020-06-15-11.00.00", 1, 35455, 1, 30.50, Currency.EUR));
        prices.add(createPrice(4, "2020-06-15-16.00.00", "2020-12-31-23.59.59", 1, 35455, 1, 38.95, Currency.EUR));
    }

    private Price createPrice(int priceList, String startDateStr, String endDateStr, int brandId, int productId, int priority, double priceValue, Currency currency) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime startDate = LocalDateTime.parse(startDateStr, formatter);
        LocalDateTime endDate = LocalDateTime.parse(endDateStr, formatter);

        Price price = new Price();
        price.setPriceList(priceList);
        price.setStartDate(startDate);
        price.setEndDate(endDate);
        price.setPriority(priority);
        price.setPriceValue(priceValue);
        price.setCurrency(currency);

        Brand brand = new Brand();
        brand.setBrandId(brandId);
        price.setBrand(brand);

        Product product = new Product();
        product.setProductId(productId);
        price.setProduct(product);

        return price;
    }

    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    @Test
    void testRequestAtTenOn14thForProduct35455AndBrand1() throws Exception {
        Mockito.when(priceInputPort.getPriceByBrandAndProductInApplicationDate(Mockito.any(), Mockito.eq(35455), Mockito.eq(1)))
               .thenReturn(prices.get(0));

        mockMvc.perform(get("/price/getByBrandAndProduct")
                .param("applicationDate", "2020-06-14-10.00.00")
                .param("productId", "35455")
                .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.price", is(35.50)))
                .andExpect(jsonPath("$.priceList", is(1)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }


 // Test 2
    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void testRequestAtSixteenOn14thForProduct35455AndBrand1() throws Exception {
        Mockito.when(priceInputPort.getPriceByBrandAndProductInApplicationDate(Mockito.any(), Mockito.eq(35455), Mockito.eq(1)))
               .thenReturn(prices.get(1));

        mockMvc.perform(get("/price/getByBrandAndProduct")
                .param("applicationDate", "2020-06-14-16.00.00")
                .param("productId", "35455")
                .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.price", is(25.45)))
                .andExpect(jsonPath("$.priceList", is(2)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }

    // Test 3
    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void testRequestAtTwentyOneOn14thForProduct35455AndBrand1() throws Exception {
        Mockito.when(priceInputPort.getPriceByBrandAndProductInApplicationDate(Mockito.any(), Mockito.eq(35455), Mockito.eq(1)))
               .thenReturn(prices.get(0));

        mockMvc.perform(get("/price/getByBrandAndProduct")
                .param("applicationDate", "2020-06-14-21.00.00")
                .param("productId", "35455")
                .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.price", is(35.50)))
                .andExpect(jsonPath("$.priceList", is(1)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }

    // Test 4
    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    void testRequestAtTenOn15thForProduct35455AndBrand1() throws Exception {
        Mockito.when(priceInputPort.getPriceByBrandAndProductInApplicationDate(Mockito.any(), Mockito.eq(35455), Mockito.eq(1)))
               .thenReturn(prices.get(2));

        mockMvc.perform(get("/price/getByBrandAndProduct")
                .param("applicationDate", "2020-06-15-10.00.00")
                .param("productId", "35455")
                .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.price", is(30.50)))
                .andExpect(jsonPath("$.priceList", is(3)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }

    // Test 5
    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    void testRequestAtTwentyOneOn16thForProduct35455AndBrand1() throws Exception {
        Mockito.when(priceInputPort.getPriceByBrandAndProductInApplicationDate(Mockito.any(), Mockito.eq(35455), Mockito.eq(1)))
               .thenReturn(prices.get(3));

        mockMvc.perform(get("/price/getByBrandAndProduct")
                .param("applicationDate", "2020-06-16-21.00.00")
                .param("productId", "35455")
                .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.price", is(38.95)))
                .andExpect(jsonPath("$.priceList", is(4)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }
    
    @DisplayName("Test: Obtener todos los precios")
    @Test
    void getAllPricesTest() throws Exception {
        Mockito.when(priceInputPort.getAll()).thenReturn(prices);

        mockMvc.perform(get("/price"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$", hasSize(prices.size())))
               .andExpect(jsonPath("$[0].brandId", is(prices.get(0).getBrand().getBrandId())))
               .andExpect(jsonPath("$[0].productId", is(prices.get(0).getProduct().getProductId())))
               .andExpect(jsonPath("$[0].price", is(prices.get(0).getPriceValue())))
               .andExpect(jsonPath("$[0].priceList", is(prices.get(0).getPriceList())))
               .andExpect(jsonPath("$[0].currency", is(prices.get(0).getCurrency().toString())))
               ;
    }


}
