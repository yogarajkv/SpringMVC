package com.sapient.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.domain.Reservation;
import com.sapient.service.ReservationService;

@Controller
@RequestMapping("/reservationQuery")
public class ReservationController {

	private ReservationService service;

	@Autowired
	public ReservationController(ReservationService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setUpForm(Model model) {
		List<Reservation> result = Collections.emptyList();
		model.addAttribute("reservations", result);
		return "reservationQuery";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@RequestParam("courtName") String courtName, Model model) {
		List<Reservation> result = Collections.emptyList();
		if (courtName != null)
			result = service.query(courtName);
		model.addAttribute("reservations", result);
		return "reservationQuery";
	}

	public ReservationService getService() {
		return service;
	}

	public void setService(ReservationService service) {
		this.service = service;
	}

}
