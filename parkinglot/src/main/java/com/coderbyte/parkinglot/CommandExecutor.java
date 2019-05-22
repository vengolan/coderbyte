package com.coderbyte.parkinglot;

import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import com.coderbyte.parkinglot.commands.Command;
import com.coderbyte.parkinglot.exceptions.InvalidParameterException;

/**
 * 
 * @author venkater
 * This class calls the appropriate Command object.
 * it stores the Command object for each command in a HashMap, and calls the appropriate command based on user input parameter. 
 */
public class CommandExecutor {
	

	HashMap<String,Command> commands = new HashMap<String,Command>();
	ParkingLot parkinglot;
	
	/**
	 * Constructor instantiates an empty ParkingLot object and stores command to Command Object mapping in a HashMap.
	 * This HashMap is built as per the mapping defined in command.properties file, which maps each command to a Class that implements the Command Interface. 
	 * All these classes are dynamically loaded and added to the HashMap.
	 * @param props - This is loaded from /resources/command.properties. This maps the command String to the appropriate Command Implementation. 
	 */
	public CommandExecutor(Properties props) {
		
		try {
			parkinglot = new ParkingLot();
			
			// TODO Auto-generated constructor 
			Set<String> keys = props.stringPropertyNames();
		    for (String key : keys) {
		      //System.out.println(key + " : " + props.getProperty(key));
		      Class cls = Class.forName(props.getProperty(key));
		      Command myCmdObj= (Command) cls.newInstance();
		      commands.put(key, myCmdObj);
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * This method obtains the appropriate command object from the command name in args[0] and calls its execute method.
	 * Calls the validateParameter(args) method of the command object to perform parameter validation. 
	 * If validation fails and the command object throws an InvalidParameterException, it calls usage() method of the command object to display the correct usage3 information of the command.  
	 * @param - This is the command input by the user split into a String[]  
	 */
	public void execute(String[] args) {
			try {
				Command cmd = (Command)commands.get(args[0]);
				if(cmd != null) {
					if(cmd.validateParams(args))
						cmd.execute(args,parkinglot);
				}
				else
					System.out.println("\"" + args[0] + "\" is not a valid command. Please enter a valid command");

			}catch(InvalidParameterException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCommand().usage());
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
