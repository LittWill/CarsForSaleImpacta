package com.wnra.carsforsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CarsForSaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsForSaleApplication.class, args);
	}

}
