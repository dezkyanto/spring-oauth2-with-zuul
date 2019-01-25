package com.example.eurekaclient;

import com.example.eurekaclient.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@RibbonClient(name = "image-service", configuration = RibbonConfiguration.class)
public class ImagesService {

	public static void main(String[] args) {
		SpringApplication.run(ImagesService.class, args);
	}

}

@Configuration
class RestTemplateConfig{
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){return new RestTemplate(); }
}