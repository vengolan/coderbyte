package com.coderbyte.parkinglot.exceptions;

import com.coderbyte.parkinglot.commands.Command;

public class InvalidParameterException extends Exception {

	private Command cmd;
	
	public InvalidParameterException(Command cmd, String message) {
		super(message);
		this.cmd =cmd;
	}
	
	public Command getCommand() {
		return cmd;
	}
}
