package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"coderbyte.basicwebapp"})
public class BasicwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicwebappApplication.class, args);
	}

}
