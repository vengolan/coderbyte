package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;

public class LeaveCommand implements Command{

	public void execute(String[] params, ParkingLot parkinglot) {
		// TODO Auto-generated method stub
		
		if(!parkinglot.isReady())
			return;

		int slot = Integer.parseInt(params[1]);
		parkinglot.Leave(slot);
	}
}
