package com.codeschool.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.codeschool")
@EntityScan("com.codeschool.entities")
@EnableJpaRepositories("com.codeschool.repository")
public class IotApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		SpringApplication.run(IotApplication.class, args);
		
		
	
	}
}
