package com.sapient.service;

import java.util.List;

import com.sapient.domain.Reservation;

public interface ReservationService {
	
	
	List<Reservation> query(String courtName);

}
