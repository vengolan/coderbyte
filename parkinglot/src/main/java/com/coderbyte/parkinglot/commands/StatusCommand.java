package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;
import com.coderbyte.parkinglot.exceptions.InvalidParameterException;

/**
 * Implements "status" command. Refer to CommandExecutor class & Command Interface for more information on the methods. 
 * @author venkater
 *
 */
public class StatusCommand implements Command {

	public void execute(String[] params, ParkingLot parkinglot) {
		// TODO Auto-generated method stub
		
		if(!parkinglot.isReady())
			return;
		
		parkinglot.getStatus();

	}

	public String usage() {
		// TODO Auto-generated method stub
		return "\tusage:status\n\texample:status";
		
	}

	public boolean validateParams(String[] args) throws InvalidParameterException {
		// TODO Auto-generated method stub
		return true;
	}

}
