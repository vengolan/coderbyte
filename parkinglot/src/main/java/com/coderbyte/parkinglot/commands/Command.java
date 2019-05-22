package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;
import com.coderbyte.parkinglot.exceptions.InvalidParameterException;

public interface Command {
	
	public void execute(String[] params, ParkingLot parkinglot);
	
	public String usage();
	
	public boolean validateParams(String[] args) throws InvalidParameterException;
}
