package ru.microservice.currrencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CurrrencyExchangeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CurrrencyExchangeServiceApplication.class, args);
	}
}
