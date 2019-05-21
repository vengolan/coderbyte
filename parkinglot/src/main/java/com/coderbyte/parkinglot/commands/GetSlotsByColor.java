package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;

public class GetSlotsByColor implements Command{


	public void execute(String[] params, ParkingLot parkinglot) {
		// TODO Auto-generated method stub
		
		if(!parkinglot.isReady())
			return;

		String color = params[1];
		parkinglot.getSlotsByColor(color);
	}

}
