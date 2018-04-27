package com.de;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class DEConfigurerApplication {
	public static void main(String[] args) {
		SpringApplication.run(DEConfigurerApplication.class, args);
	}
}
