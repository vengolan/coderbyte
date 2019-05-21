package com.coderbyte.parkinglot;

public class Vehicle {

	private String registration;
	private String colour;
	
	public Vehicle(String registration, String colour) {
		super();
		this.registration = registration;
		this.colour = colour;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	@Override
	public String toString() {
		return "Vehicle [registration=" + registration + ", colour=" + colour + "]";
	}
	
	
	
}
