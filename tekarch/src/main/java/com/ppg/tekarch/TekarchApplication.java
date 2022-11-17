package com.ppg.tekarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ppg.tekarch.Controller", "com.ppg.tekarch.Service", "com.ppg.tekarch.TekarchApplication"})
public class TekarchApplication {

	public static void main(String[] args) {
		SpringApplication.run(TekarchApplication.class, args);
	}

}
