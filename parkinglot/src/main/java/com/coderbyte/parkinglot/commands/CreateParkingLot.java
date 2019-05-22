package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;
import com.coderbyte.parkinglot.exceptions.InvalidParameterException;

/**
 * Implements create_parking_lot command. Refer TO CommandExecutor class & Command Interface for more information on the methods. 
 * @author venkater
 *
 */

public class CreateParkingLot implements Command {

	public void execute(String[] params, ParkingLot parkinglot) {
		// TODO Auto-generated method stub
		int noOfSlots = Integer.parseInt(params[1]);
		parkinglot.init(noOfSlots);
	}

	public String usage() {
		// TODO Auto-generated method stub
		return "\tusage: create_parking_lot <no_of_slots>\n\tExample:create_parking_lot 6";
		
	}

	public boolean validateParams(String[] args) throws InvalidParameterException {
		// TODO Auto-generated method stub
		if( args.length >= 2 && args[1].matches("\\d+") && !args[1].matches("0+"))
			return true;
		else
			throw new InvalidParameterException(this, "Please enter a vaild integer parameter!");
	}

}
