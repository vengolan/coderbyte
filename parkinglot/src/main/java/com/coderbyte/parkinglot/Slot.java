package com.coderbyte.parkinglot;

public class Slot {

	private int slotNumber;
	private Vehicle vehicle; 
	
	
	
	public Slot(int slotNumber) {
		super();
		this.slotNumber = slotNumber;
		this.vehicle = null;
	}
	@Override
	public String toString() {
		return "Slot [slotNumber=" + slotNumber + ", vehicle=" + vehicle + "]";
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public boolean isEmpty() {
		return vehicle == null;
	}
	
}
