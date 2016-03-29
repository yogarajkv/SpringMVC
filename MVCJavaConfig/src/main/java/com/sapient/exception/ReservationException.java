package com.sapient.exception;

import java.util.Date;

public class ReservationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	private long timeStamp;
	
	
	public ReservationException(String message) {
		super(message);
		this.errorMessage = message;
		this.timeStamp = new Date().getTime();
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public Long getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
