package com.infinity.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class EnquiryApplication {

	public static void main(String[] args) {
		System.out.println("This is enquiry");
		SpringApplication.run(EnquiryApplication.class, args);
	}

}
