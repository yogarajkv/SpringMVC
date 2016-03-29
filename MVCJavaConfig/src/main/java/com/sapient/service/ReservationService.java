package com.sapient.service;

import java.util.List;

import com.sapient.domain.Reservation;
import com.sapient.domain.SportType;

public interface ReservationService {
	
	
	List<Reservation> query(String courtName);
	
	void addReservation(Reservation reservation);
	
	List<SportType> getAllSportTypes();
	
	SportType getSportTypeById(String id);
}
