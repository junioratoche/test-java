package com.junioratoche.backend.adapter.in.http.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GlobalExceptionHandlerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @Test
    void handleDateTimeParseException() throws Exception {
        mockMvc.perform(get("/price/getByBrandAndProduct")
                .param("applicationDate", "2021*06*14*10.00.00")
                .param("productId", "35455")
                .param("brandId", "1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.details", is("Invalid date format. Use yyyy-MM-dd-HH.mm.ss format")));
    }

    @Test
    void handleInvalidRequestParametersException() throws Exception {
        mockMvc.perform(get("/price/getByBrandAndProduct"))
               .andExpect(status().isBadRequest())
               .andExpect(jsonPath("$.details", is("Request binding error")));
    }

    @Test
    void handleServletRequestBindingException() throws Exception {
        mockMvc.perform(get("/price/getByBrandAndProduct")
                    .param("applicationDate", "2021-06-14-10.00.00")
                    .param("productoId", "35455")
                    .param("brandId", "1"))
               .andExpect(status().isBadRequest())
               .andExpect(jsonPath("$.message", is("Required request parameter 'productId' for method parameter type Integer is not present")));
    }

}