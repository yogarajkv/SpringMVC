package com.sapient.converter;

import org.springframework.core.convert.converter.Converter;

import com.sapient.domain.SportType;
import com.sapient.service.ReservationService;

public class SportTypeConverter implements Converter<String,SportType>{
	
	
	ReservationService service;
	
	public SportTypeConverter(ReservationService service)
	{
		this.service = service;
	}

	public SportType convert(String source) {		
		return service.getSportTypeById(source);
	}

}
