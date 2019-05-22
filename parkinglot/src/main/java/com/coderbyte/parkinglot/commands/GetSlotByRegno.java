package com.coderbyte.parkinglot.commands;

import com.coderbyte.parkinglot.ParkingLot;
import com.coderbyte.parkinglot.exceptions.InvalidParameterException;

public class GetSlotByRegno implements Command {


	public void execute(String[] params, ParkingLot parkinglot) {
		// TODO Auto-generated method stub
		
		if(!parkinglot.isReady())
			return;

		String regno = params[1];
		parkinglot.getSlotByRegno(regno);
	}

	public String usage() {
		// TODO Auto-generated method stub
		return "\tusage:slot_number_for_registration_number <registration_no>\n\texample:slot_number_for_registration_number KA-01-HH-3141";
		
		
	}

	public boolean validateParams(String[] args) throws InvalidParameterException {
		// TODO Auto-generated method stub
		if(args.length >=2)
			return true;
		else
			throw new InvalidParameterException(this,"Insufficient Parameters!" );
	}



}
