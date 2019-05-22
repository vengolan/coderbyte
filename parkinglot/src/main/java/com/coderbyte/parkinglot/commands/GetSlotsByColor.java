package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;
import com.coderbyte.parkinglot.exceptions.InvalidParameterException;

public class GetSlotsByColor implements Command{


	public void execute(String[] params, ParkingLot parkinglot) {
		// TODO Auto-generated method stub
		
		if(!parkinglot.isReady())
			return;

		String color = params[1];
		parkinglot.getSlotsByColor(color);
	}

	public String usage() {
		// TODO Auto-generated method stub
		return "\tusage:slot_numbers_for_cars_with_colour <color>\n\texample:slot_numbers_for_cars_with_colour White";
		
	}

	public boolean validateParams(String[] args) throws InvalidParameterException {
		// TODO Auto-generated method stub
		if(args.length >=2)
			return true;
		else
			throw new InvalidParameterException(this,"Insufficient Parameters!" );
	}

}
