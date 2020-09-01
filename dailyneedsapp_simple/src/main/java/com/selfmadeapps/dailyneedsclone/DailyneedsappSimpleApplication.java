package com.selfmadeapps.dailyneedsclone;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DailyneedsappSimpleApplication {

	@Bean
	public ModelMapper mMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DailyneedsappSimpleApplication.class, args);
	}

}
