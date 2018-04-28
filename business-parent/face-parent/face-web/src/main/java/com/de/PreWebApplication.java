package com.de;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

/**  
 *
 * @author jensen 
 * @description    启动类
 * @date 2018/4/28 11:39
 * @param
 * @return 
 */ 
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableAsync
public class PreWebApplication {

	@Autowired  
    private RestTemplateBuilder builder; 
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
        return builder.build();  
    }  
	
	public static void main(String[] args) {
		SpringApplication.run(PreWebApplication.class, args);
	}
}
