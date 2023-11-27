package com.junioratoche.backend.adapter.in.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.junioratoche.backend.adapter.out.db.dto.PriceRequest;
import com.junioratoche.backend.adapter.out.db.dto.PriceResponse;
import com.junioratoche.backend.adapter.out.db.mapper.PriceResponseMapper;
import com.junioratoche.backend.domain.Price;
import com.junioratoche.backend.domain.exceptions.InvalidRequestParametersException;
import com.junioratoche.backend.port.in.http.PriceInputPort;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping(value = "price")
public class HttpInputAdapter {

	@Autowired
	PriceInputPort priceInputPort;

	@Autowired
	PriceResponseMapper priceResponseMapper;

	@Operation(description = "Return all prices")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "500", description = "Internal error") })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PriceResponse> getAll() {
		List<Price> priceList = priceInputPort.getAll();
		return priceResponseMapper.priceListToPriceResponseList(priceList);
	}

	@Operation(description = "Returns the price filtered by product, brand and date of application")
	@GetMapping(value = "/getByBrandAndProduct", produces = MediaType.APPLICATION_JSON_VALUE)
	public PriceResponse getPriceByBrandAndProductInApplicationDate(@RequestParam @NotNull String applicationDate,
			@RequestParam @NotNull Integer productId, @RequestParam @NotNull Integer brandId) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
		LocalDateTime parsedApplicationDate = LocalDateTime.parse(applicationDate, formatter);
		Price findByParam = priceInputPort.getPriceByBrandAndProductInApplicationDate(parsedApplicationDate, productId,
				brandId);
		return priceResponseMapper.priceToPriceResponse(findByParam);
	}

}