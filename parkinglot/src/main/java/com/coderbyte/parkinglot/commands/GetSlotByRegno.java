package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;

public class GetSlotByRegno implements Command {


	public void execute(String[] params, ParkingLot parkinglot) {
		// TODO Auto-generated method stub
		String regno = params[1];
		parkinglot.getSlotByRegno(regno);
	}



}
