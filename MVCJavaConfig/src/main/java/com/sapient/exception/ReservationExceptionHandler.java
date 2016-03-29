package com.sapient.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ReservationExceptionHandler {
	
	@ExceptionHandler(ReservationException.class)
	public ModelAndView handleReservationException(ReservationException e)
	{
		ModelAndView mv = new ModelAndView("reservationException");
		mv.addObject("exception", e);
		return mv;
	}

}
