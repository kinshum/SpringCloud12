package com.de;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class BaseServiceApplication {
	
	@Autowired  
    private RestTemplateBuilder builder; 
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {  
        return builder.build();  
    }  
	
	public static void main(String[] args) {
		SpringApplication.run(BaseServiceApplication.class, args);
	}

}
