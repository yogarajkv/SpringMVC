package com.sapient.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.domain.Player;
import com.sapient.domain.Reservation;
import com.sapient.domain.SportType;
import com.sapient.exception.ReservationException;
import com.sapient.service.ReservationService;

@Controller
@RequestMapping("/reservationQuery")
public class ReservationController {

	private ReservationService service;

	@Autowired
	public ReservationController(ReservationService service) {
		this.service = service;
	}
	
	@ModelAttribute("sportTypes")
	public List<SportType> getAllSportType()
	{
		return service.getAllSportTypes();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String setUpForm(@RequestParam(required=false ,value= "username") String userName, Model model) {
		Reservation reservation = new Reservation();
		//reservation.setPlayer(new Player(userName,null));
		reservation.setPlayer(new Player());
		model.addAttribute("reservation", reservation);
		return "addReservation";
	}

	@RequestMapping(method = RequestMethod.GET)
	public void setUpForm() {

	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@RequestParam("courtName") String courtName, Model model) {
		List<Reservation> result = Collections.emptyList();
		if (courtName != null)
			result = service.query(courtName);
		if (result.isEmpty())
			throw new ReservationException("The searching content is not avialable " + courtName);
		model.addAttribute("reservations", result);
		return "reservationQuery";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addReservation(@ModelAttribute("reservation") Reservation reservation, BindingResult result ) {
		if (reservation.getCourtName()==null)
			throw new ReservationException("Reservation object not populated properly");
		System.out.println(reservation.getPlayer()+ ":"+ reservation.getSport());
		
		if (result.hasErrors())
		{
		List<ObjectError>errorsList = result.getAllErrors();
		for(ObjectError oe : errorsList)
		{
			System.out.println(oe.getDefaultMessage()+oe.getObjectName());
		}
		}
		
		
		
		service.addReservation(reservation);
		return "redirect:reservationSuccess";
	}
	@RequestMapping("/reservationSuccess")
	public String reservationSuccess()
	{
		return "reservationSuccess";
	}

	public ReservationService getService() {
		return service;
	}

	public void setService(ReservationService service) {
		this.service = service;
	}

}
