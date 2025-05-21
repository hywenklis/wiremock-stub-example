package com.example.fipe.wiremock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoFipeWiremockApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoFipeWiremockApplication.class, args);
	}

}
