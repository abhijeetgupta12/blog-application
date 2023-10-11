package com.abhi.project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}

	
	//Since this is a configuration file we can declare beans here for autowiring
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();	
		
	}
}
