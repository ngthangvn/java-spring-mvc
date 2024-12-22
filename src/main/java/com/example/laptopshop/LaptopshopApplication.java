package com.example.laptopshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// @SpringBootApplication
// include >< exclude
@SpringBootApplication(exclude =
org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)

public class LaptopshopApplication {

	public static void main(String[] args) {
		// container
	SpringApplication.run(LaptopshopApplication.class, args);

	}

}
