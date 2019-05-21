package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;

public class CreateParkingLot implements Command {

	public void execute(String[] params, ParkingLot parkinglot) {
		// TODO Auto-generated method stub
		int noOfSlots = Integer.parseInt(params[1]);
		parkinglot.init(noOfSlots);
	}

}
