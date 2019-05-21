package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;

public class GetRegnosByColor implements Command {


	public void execute(String[] params, ParkingLot parkinglot) {
		// TODO Auto-generated method stub
		String color = params[1];
		parkinglot.getRegnosByColor(color);
		
	}

}
