import java.util.*; 
import java.io.*;
import java.util.regex.*;

public class Wildcard {  
  public static boolean WildcardCharacters(String str) { 
  
    // code goes here   
    /* Note: In Java the return type of a function and the 
       parameter types being passed are defined, so this return 
       call must match the return type of the function.
       You are free to modify the return type. */
       String[] splitted = str.split("\\s+");
       String pattern = splitted[0];
       String inputstr = splitted[1];

        String regexpattern = pattern.replaceAll("(\\+)",".");
		regexpattern =  regexpattern.replaceAll("\\*(\\{\\d+\\})","\\.$1");
		regexpattern =  regexpattern.replaceAll("\\*",".\\{3\\}");
		
        return inputstr.matches(regexpattern);
    
  } 
  
  
  
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(WildcardCharacters(s.nextLine())); 
  }   
  
}