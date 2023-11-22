package com.junioratoche.backend.adapter.in.http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import com.junioratoche.backend.adapter.out.db.dto.PriceResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HttpInputAdapterTest {    

    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    @Test
    void Test1() {
    	
        String applicationDateString = "2020-06-14-10.00.00";
        int productId = 35455;
        int brandId = 1;
        
        PriceResponse response = performHttpGet(applicationDateString, productId, brandId);
        
        assertEquals(1L, response.getBrandId());
        assertEquals(35455L, response.getProductId());
        assertEquals(35.5, response.getPrice());
        assertEquals(1, response.getPriceList());
    }
    
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    @Test
    void Test2() {
    	
        String applicationDateString = "2020-06-14-16.00.00";
        int productId = 35455;
        int brandId = 1;
        
        PriceResponse response = performHttpGet(applicationDateString, productId, brandId);
        
        assertEquals(1L, response.getBrandId());
        assertEquals(35455L, response.getProductId());
        assertEquals(25.45, response.getPrice());
        assertEquals(2, response.getPriceList());
    }
    
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    @Test
    void Test3() {
    	
        String applicationDateString = "2020-06-14-21.00.00";
        int productId = 35455;
        int brandId = 1;
        
        PriceResponse response = performHttpGet(applicationDateString, productId, brandId);
        
        assertEquals(1L, response.getBrandId());
        assertEquals(35455L, response.getProductId());
        assertEquals(35.5, response.getPrice());
        assertEquals(1, response.getPriceList());
    }
    
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
    @Test
    void Test4() {
    	
        String applicationDateString = "2020-06-15-10.00.00";
        int productId = 35455;
        int brandId = 1;
        
        PriceResponse response = performHttpGet(applicationDateString, productId, brandId);
        
        assertEquals(1L, response.getBrandId());
        assertEquals(35455L, response.getProductId());
        assertEquals(30.5, response.getPrice());
        assertEquals(3, response.getPriceList());
    }
    
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
    @Test
    void Test5() {
    	
        String applicationDateString = "2020-06-16-21.00.00";
        int productId = 35455;
        int brandId = 1;
        
        PriceResponse response = performHttpGet(applicationDateString, productId, brandId);
        
        assertEquals(1L, response.getBrandId());
        assertEquals(35455L, response.getProductId());
        assertEquals(38.95, response.getPrice());
        assertEquals(4, response.getPriceList());
    }


    private PriceResponse performHttpGet(String applicationDateString, int productId, int brandId) {
    	
    	String UrlqueryParams = String.format("http://localhost:8081/price/getByBrandAndProduct?applicationDate=%s&productId=%d&brandId=%d", 
    			applicationDateString, productId, brandId);
    	
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(UrlqueryParams, PriceResponse.class);
    }
}
