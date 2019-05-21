package com.coderbyte.parkinglot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Application {

	static BufferedReader reader; 
	static CommandExecutor command;
	
	public static void main(String[] args) {
		
		try {
			
			//Initialize CommandExecutor
			Properties props = new Properties();
			InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("commands.properties");
			if(inputStream != null) {
				props.load(inputStream);
			}
			CommandExecutor cmd = new CommandExecutor(props);
			
			//wait for commands or pick commands from a file... 
			System.out.println("Arguments passed - " + args[0]);
			if(args.length == 0 ) {
				reader = new BufferedReader(new InputStreamReader(System.in));
			}else { 
				reader = new BufferedReader(new FileReader(args[0]));
			}
			
			String line = reader.readLine();
			while(line !=null) {
				process(line);
				line = reader.readLine();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}//main
	
	public static void process(String command) {
			System.out.println(command);
			
	}
	
}
