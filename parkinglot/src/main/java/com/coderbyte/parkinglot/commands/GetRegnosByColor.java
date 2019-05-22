package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;
import com.coderbyte.parkinglot.exceptions.InvalidParameterException;


/**
 * Implements "registration_numbers_for_cars_with_colour" command. Refer TO CommandExecutor class & Command Interface for more information on the methods. 
 * @author venkater
 *
 */
public class GetRegnosByColor implements Command {


	public void execute(String[] params, ParkingLot parkinglot) {
		// TODO Auto-generated method stub
		
		if(!parkinglot.isReady())
			return;
		
		String color = params[1];
		parkinglot.getRegnosByColor(color);
		
	}

	public String usage() {
		// TODO Autnr
		return "\tusage:registration_numbers_for_cars_with_colour <color>\n\texample:registration_numbers_for_cars_with_colour White";
		
	}

	public boolean validateParams(String[] args) throws InvalidParameterException {
		// TODO Auto-generated method stubur
		if(args.length >=2)
			return true;
		else
			throw new InvalidParameterException(this,"Insufficient Parameters!" );
	}

}
