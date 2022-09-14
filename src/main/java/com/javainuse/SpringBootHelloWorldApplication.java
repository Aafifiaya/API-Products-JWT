package com.javainuse;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javainuse.service.ProductService;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) {
		new File(ProductService.uploadDirectory).mkdir();
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}
}