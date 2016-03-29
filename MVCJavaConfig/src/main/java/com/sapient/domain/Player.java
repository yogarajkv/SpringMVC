package com.sapient.domain;

public class Player {

	private String name;
	private String phno;
	
	public Player()
	{
		
	}
	/*public Player(String name, String phno)
	{
		this.name = name;
		this.phno = phno;
	}*/
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	
	public String toString()
	{
		return name+":"+ phno;
	}
	
}
