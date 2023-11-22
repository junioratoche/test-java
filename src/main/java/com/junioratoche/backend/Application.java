package com.junioratoche.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication(scanBasePackages = "com.junioratoche.backend")
@EntityScan("com.junioratoche.backend.adapter.out.db.entity")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components()).info(new Info().title("Pricing API").version("1.0.0"));
	}
}
