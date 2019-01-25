package com.example.eurekaclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.eurekaclient.domain.Gallery;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Environment env;
        
        private LoggerFactory logInfo;
        private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home(){
		return "Hello from Gallery Server that running on port ";
	}
        
	@RequestMapping("/test")
	public String testLoadBalancing(){
		logger.info("Getting test from gallery server");
		return "Hello User";
	}

	@HystrixCommand(fallbackMethod = "fetchImageFallback")
	@RequestMapping("/images")
	public List getImages() throws Exception {
		List images = restTemplate.getForObject("http://image-service/images/", List.class);
		return images;
	}

	//kalo gagal
	public List fetchImageFallback(){
		return new ArrayList();
	}

}
