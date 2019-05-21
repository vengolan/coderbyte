package com.coderbyte.parkinglot;

import java.io.BufferedReader;
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
				System.out.println("Arguments passed - ");
				for(int i=0; i < args.length; i++) {
					System.out.println(args[i]);
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
			System.out.println(cmd);
			String[] args = cmd.split("\\s+");
			commandExecutor.execute(args);
	}
	
}
