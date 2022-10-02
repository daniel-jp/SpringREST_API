package com.springRest.api.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	

	@Bean
	public ModelMapper modlMapper() {
		
		return new ModelMapper();
	}
}
