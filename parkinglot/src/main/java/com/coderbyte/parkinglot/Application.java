package com.coderbyte.parkinglot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Application {

	static BufferedReader reader; 
	static CommandExecutor commandExecutor;
	
	public static void main(String[] args) {
		
		try {
			
			//Initialize CommandExecutor
			Properties props = new Properties();
			InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("commands.properties");
			if(inputStream != null) {
				props.load(inputStream);
			}
			commandExecutor= new CommandExecutor(props);
			
			//wait for commands or pick commands from a file... 
			if(args.length == 0 ) {
				reader = new BufferedReader(new InputStreamReader(System.in));
			}else { 

				//exit if file does not exist...
				File f = new File(args[0]);
				if(!f.exists()) {
					System.out.println(args[0] + " Not Found! Please give a valid flie. \nExiting...");
					System.exit(-1);
				}
					
					
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
	
	public static void process(String cmd) {
			String[] args = cmd.split("\\s+");
			commandExecutor.execute(args);
	}
	
}
