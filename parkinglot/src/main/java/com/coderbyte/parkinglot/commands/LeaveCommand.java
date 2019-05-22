package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;
import com.coderbyte.parkinglot.exceptions.InvalidParameterException;


/**
 * Implements "leave" command. Refer to CommandExecutor class & Command Interface for more information on the methods. 
 * @author venkater
 *
 */
public class LeaveCommand implements Command{

	public void execute(String[] params, ParkingLot parkinglot) {
		// TODO Auto-generated method stub
		
		if(!parkinglot.isReady())
			return;

		int slot = Integer.parseInt(params[1]);
		parkinglot.Leave(slot);
	}

	public String usage() {
		// TODO Auto-generated method stub
		return "\tusage:leave <slot_no>\n\texample:leave 4";
		
	}

	public boolean validateParams(String[] args) throws InvalidParameterException {
		// TODO Auto-generated method stub
		if( args.length >= 2 && args[1].matches("\\d+") && !args[1].matches("0+"))
			return true;
		else
			throw new InvalidParameterException(this, "Please enter a vaild integer parameter!");
	}
}
