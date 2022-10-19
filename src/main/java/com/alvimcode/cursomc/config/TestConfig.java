package com.alvimcode.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alvimcode.cursomc.services.DBService;
import com.alvimcode.cursomc.services.EmailService;
import com.alvimcode.cursomc.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateTestDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}

	

	
}
