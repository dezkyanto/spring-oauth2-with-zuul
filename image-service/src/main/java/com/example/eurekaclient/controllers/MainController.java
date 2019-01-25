package com.example.eurekaclient.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eurekaclient.entities.Image;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class MainController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Environment env;

	@HystrixCommand(fallbackMethod = "fetchImageFallback")
	@RequestMapping("/images")
	public List getImages() throws Exception {
		List images = restTemplate.getForObject("http://image-data-server/imageData/images/", List.class);
		return images;
	}

	//kalo gagal
	public List fetchImageFallback(){
		return new ArrayList();
	}


}
