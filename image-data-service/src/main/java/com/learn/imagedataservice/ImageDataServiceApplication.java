package com.learn.imagedataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ImageDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageDataServiceApplication.class, args);
	}

}

