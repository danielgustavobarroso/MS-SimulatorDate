package com.retooling.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(servers = {@Server(url = "http://localhost:8011/ms-simulator-date")})
public class SimulatorDateApplication {

	private static final Logger logger = LoggerFactory.getLogger(SimulatorDateApplication.class);
	
	public static void main(String[] args) {
		logger.info("Iniciando SimulatorDateApplication...");
		SpringApplication.run(SimulatorDateApplication.class, args);
	}
	
}
