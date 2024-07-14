package com.hegde.hosalli.TO_DO_FullStack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ToDoFullStackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoFullStackApplication.class, args);
	}
	
	//Add CROSS mapping so that it will all all url of all kind from http://localhost:3000
	
	@Bean
	public WebMvcConfigurer crosConfigure() {
		return new WebMvcConfigurer(){
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").//All url of 
				allowedMethods("*").//all type
				allowedOrigins("http://localhost:3000");//from this origin
			}
		};
	}

}
