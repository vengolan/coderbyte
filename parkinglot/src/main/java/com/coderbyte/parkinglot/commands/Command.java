package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;
import com.coderbyte.parkinglot.exceptions.InvalidParameterException;

/**
 * 
 * @author venkater
 * Interface to be implemented by all Command Classes. 
 */

public interface Command {
	
	/**
	 * This Method actually implements the command functionality with help of ParkingLot class. 
	 * @param params - Array of parameters passed as input
	 * @param parkinglot - Instance of ParkingLot which actually implements the core functionality. 
	 */
	public void execute(String[] params, ParkingLot parkinglot);
	
	/**
	 *This method gives the usage information. This will be used if the validateParams method fails.   
	 * @return - Usage informnation for the command
	 */
	public String usage();

	/**
	 * 
	 * @param args - Command with parameters in a String[]
	 * @return - true if validation succeeds. Else, exception is thrown
	 * @throws InvalidParameterException
	 */
	public boolean validateParams(String[] args) throws InvalidParameterException;
}
