package com.Suresh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FirstController {

	Logger logger = LoggerFactory.getLogger(FirstController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/microservice1")
	public String getMessage() {
		logger.info("I am inside the method...");
		logger.trace("I am inside the method...");
		logger.warn("I am inside the method...");
		logger.debug("I am inside the method...");
		logger.info("I am inside the method...");
		
		String baseUrl = "http://localhost:2222/microservice2";
		String response = restTemplate.getForObject(baseUrl, String.class);//restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		logger.info("The response recieved by Method -1 is  " +response);
		return "Good Morning";
	}
}
