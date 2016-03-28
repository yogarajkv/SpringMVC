package com.sapient.domain;

import java.util.Date;

public class Reservation {
	
	private String courtName;
	private Date date;
	private int hour;
	private Player player;
	private SportType sport;
	
	
	public Reservation(String courtName, Date date, int hour, Player player, SportType sport)	
	{
		this.courtName = courtName;
		this.date = date;
		this.hour = hour;
		this.player = player;
		this.sport = sport;		
	}
	
	public String getCourtName() {
		return courtName;
	}
	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public SportType getSport() {
		return sport;
	}
	public void setSport(SportType sport) {
		this.sport = sport;
	}
	
	

}
