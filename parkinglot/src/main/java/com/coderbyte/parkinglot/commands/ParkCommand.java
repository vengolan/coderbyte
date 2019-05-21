package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;
import com.coderbyte.parkinglot.Vehicle;

public class ParkCommand implements Command{

	public void execute(String[] params, ParkingLot parkinglot) {
		// TODO Auto-generated method stub
		Vehicle v = new Vehicle(params[1],params[2]);
		parkinglot.Park(v);
	}


}
