package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;
import com.coderbyte.parkinglot.Vehicle;
import com.coderbyte.parkinglot.exceptions.InvalidParameterException;


/**
 * Implements "park" command. Refer to CommandExecutor class & Command Interface for more information on the methods. 
 * @author venkater
 *
 */
public class ParkCommand implements Command{

	public void execute(String[] params, ParkingLot parkinglot) {
		// TODO Auto-generated method stub
		
		if(!parkinglot.isReady())
			return;

		Vehicle v = new Vehicle(params[1],params[2]);
		parkinglot.Park(v);
	}

	public String usage() {
		// TODO Auto-generated method stub
		return "\tusage:park <registration_no> <color>\n\texample:park KA-01-P-333 White";
		
	}

	public boolean validateParams(String[] args) throws InvalidParameterException {
		// TODO Auto-generated method stub
		if( args.length >= 3 )
			return true;
		else
			throw new InvalidParameterException(this, "Insufficient Parameters!");
	}


}
