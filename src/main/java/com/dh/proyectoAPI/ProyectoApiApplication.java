package com.dh.proyectoAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Booking Hotels API",
				version = "4.0",
				description = "API for managing hotels, reservations, and reviews"
		)
)
@SpringBootApplication
public class ProyectoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApiApplication.class, args);
	}

}
