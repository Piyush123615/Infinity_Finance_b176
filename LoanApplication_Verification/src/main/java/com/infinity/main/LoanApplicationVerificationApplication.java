package com.infinity.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanApplicationVerificationApplication {

	public static void main(String[] args) {
		System.out.println("This is  Customer Loan Application");
		SpringApplication.run(LoanApplicationVerificationApplication.class, args);
	}

}
