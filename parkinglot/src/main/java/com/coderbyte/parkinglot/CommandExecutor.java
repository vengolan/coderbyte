package com.coderbyte.parkinglot;

import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import com.coderbyte.parkinglot.commands.Command;
import com.coderbyte.parkinglot.exceptions.InvalidParameterException;

public class CommandExecutor {
	
	HashMap<String,Command> commands = new HashMap<String,Command>();
	ParkingLot parkinglot;
	
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
