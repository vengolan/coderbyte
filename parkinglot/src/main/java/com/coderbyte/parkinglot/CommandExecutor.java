package com.coderbyte.parkinglot;

import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import com.coderbyte.parkinglot.commands.Command;

public class CommandExecutor {
	
	HashMap<String,Command> commands = new HashMap<String,Command>();
	ParkingLot parkinglot;
	
	public CommandExecutor(Properties props) {
		
		try {
			parkinglot = new ParkingLot();
			
			// TODO Auto-generated constructor 
			Set<String> keys = props.stringPropertyNames();
		    for (String key : keys) {
		      System.out.println(key + " : " + props.getProperty(key));
		      Class cls = Class.forName(props.getProperty(key));
		      Command myCmdObj= (Command) cls.newInstance();
		      commands.put(key, myCmdObj);
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public void execute(String[] args) {
		Command cmd = (Command)commands.get(args[0]);
		cmd.execute(args,parkinglot);
	}

}
