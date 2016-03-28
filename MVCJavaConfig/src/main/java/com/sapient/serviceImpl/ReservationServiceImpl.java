package com.sapient.serviceImpl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.sapient.domain.Player;
import com.sapient.domain.Reservation;
import com.sapient.domain.SportType;
import com.sapient.service.ReservationService;

public class ReservationServiceImpl implements ReservationService {

	private static final SportType TENNIS = new SportType(1, "TENNIS");
	private static final SportType CRICKET = new SportType(2, "CRICKET");

	private List<Reservation> reservationList;

	public ReservationServiceImpl() {
		reservationList = new ArrayList<Reservation>();
		reservationList.add(new Reservation("Tennis #1", new GregorianCalendar(2008, 0, 14).getTime(), 16,
				new Player("Roger", "N/A"), TENNIS));
		reservationList.add(new Reservation("Tennis #2", new GregorianCalendar(2008, 0, 14).getTime(), 20,
				new Player("James", "N/A"), TENNIS));
		reservationList.add(new Reservation("Cricket #1", new GregorianCalendar(2008, 0, 14).getTime(), 16,
				new Player("Yogaraj", "N/A"), CRICKET));
		reservationList.add(new Reservation("Cricket #2", new GregorianCalendar(2008, 0, 14).getTime(), 20,
				new Player("Maniraj", "N/A"), CRICKET));

	}

	public List<Reservation> query(String courtName) {

		List<Reservation> result = new ArrayList<Reservation>();
		for (Reservation res : reservationList) {
			if (res.getCourtName().contains(courtName))
				result.add(res);
		}
		return result;
	}

}
