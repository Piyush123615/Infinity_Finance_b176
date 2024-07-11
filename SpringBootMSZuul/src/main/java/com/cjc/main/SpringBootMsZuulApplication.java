package com.cjc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class SpringBootMsZuulApplication {

	public static void main(String[] args) {
		System.out.println("Zuul proxy server");
		SpringApplication.run(SpringBootMsZuulApplication.class, args);
	}

}
