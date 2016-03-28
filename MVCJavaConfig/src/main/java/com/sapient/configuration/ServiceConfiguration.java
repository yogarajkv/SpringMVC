package com.sapient.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sapient.service.ReservationService;
import com.sapient.serviceImpl.ReservationServiceImpl;

@Configuration
public class ServiceConfiguration {

	
	@Bean
	public ReservationService reservationService()
	{
		return new ReservationServiceImpl();
	}
}
