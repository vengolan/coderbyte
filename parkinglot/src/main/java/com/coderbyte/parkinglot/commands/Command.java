package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;

public interface Command {
	
	public void execute(String[] params, ParkingLot parkinglot);

}
