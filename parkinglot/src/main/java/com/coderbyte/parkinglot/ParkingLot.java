package com.coderbyte.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * This is the main class that implements all the functionality. Command objects call the appropriate methods of this class to get the job done. 
 * @author venkater
 *
 */
public class ParkingLot {
	/**
	 * emptySlots - stores the empty slot numbers at any point of time. 
	 * occupiedSlots - stores the slot numbers that are occupied at any point of time.
	 * slots - HashMap that maps slot number to the actual Slot object which stores the parked Vehicle information.  
	 */
	private ArrayList<Integer> emptySlots;
	private ArrayList<Integer> occupiedSlots;
	private HashMap<Integer,Slot> slots;
	
	public ParkingLot() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @return true if the ParkingLot has been initialized by calling the "create_parking_lot" command. 
	 */
	public boolean isReady() {
		if(slots == null) {
			System.out.println("Please Initialize parking lot by running the \"create_parking_lot <slots>\" command");
			return false;
		}
		return true;
	}
	
	/**
	 * Creates the parking lot object. This is called when "create_parking_lot" command is issued.
	 * Instantiates 
	 * 				- the "slots" HashMap with empty Slot objects for each slot.
	 * 				- emptySlots ArrayList with all the slot Numbers
	 * 				- occupiedSlots with an Empty ArrayList<Integer>
	 * @param noOfSlots 
	 * @return
	 */
	public int init(int noOfSlots) {
		emptySlots = new ArrayList<Integer>();
		occupiedSlots = new ArrayList<Integer>();;
		slots = new HashMap<Integer,Slot>();

		
		//create empty slots
		for(int i=0; i < noOfSlots; i++) {
			emptySlots.add(new Integer(i+1));
			slots.put(new Integer(i+1),new Slot(i+1));
		}
		System.out.println("Created a parking lot with " + noOfSlots + " slots");
		return slots.size();
	
	}
	
	/**
	 * This implements "park" command. 
	 * Selects the lowset/nearest available slot from emptySlot array and parks the vehicle. 
	 * Removes the selected slot from emptySlot array and adds it to occupiedSlot array. 
	 * @param - Vehicle to be parked
	 * @return
	 */
	public int Park(Vehicle v) {
		
		if (emptySlots.size() == 0 ) {
			System.out.println("Sorry, parking lot is full");
			return -1;
		}
		
		int slotno = emptySlots.get(0);
		emptySlots.remove(0);
		Collections.sort(emptySlots);
		
		occupiedSlots.add(new Integer(slotno));
		Slot slot = slots.get(slotno);
		slot.setVehicle(v);
		
		System.out.println("Allocated slot number: " + slotno );
		return slotno;
	}
	
	/** 
	 * Implements the "leave" command
	 * This frees the Slot Number. moves the slot from occupiedSlot to emptySlot array. 
	 * Also, sets the vehicle object to null in the Slot object. 
	 * @param slotno - slot number to be freed
	 * @return
	 */
	public int Leave(int slotno) {
	
		if(!occupiedSlots.contains(new Integer(slotno))) {
			System.out.println("Sorry, no vehicle parked in slot " + slotno);
			return -1;
		}
		
		Slot slot = slots.get(slotno);
		slot.setVehicle(null);
		
		emptySlots.add(new Integer(slotno));
		occupiedSlots.remove(new Integer(slotno));
		
		Collections.sort(emptySlots);
		
		System.out.println("Slot number " + slotno + " is free");
		return slotno;
	}
	
	/**
	 * Implements "slot_numbers_for_cars_with_colour"
	 * @param color
	 * @return - array of Registration numbers with the color
	 */
	public String[] getSlotsByColor(String color) {
		
		ArrayList<String> result = new ArrayList<String>();
		for(Integer key: occupiedSlots){
				Slot s = (Slot)slots.get(key);
				Vehicle v = s.getVehicle();
				if(v.getColour().equalsIgnoreCase(color)) {
					result.add(key.toString());
				}
	         }
		String[] resultarr = (String[])result.toArray(new String[] {});
		
		if(resultarr.length > 0 )
			System.out.println(String.join(", ", resultarr));
		
		return resultarr;
	}
	
	/**
	 * Implements "registration_numbers_for_cars_with_colour"
	 * @param color
	 * @return - Array of registration numbers for color
	 */
	public String[] getRegnosByColor(String color) {

		ArrayList<String> result = new ArrayList<String>();
		for(Integer key: occupiedSlots){
				Slot s = (Slot)slots.get(key);
				Vehicle v = s.getVehicle();
				if(v.getColour().equalsIgnoreCase(color)) {
					result.add(v.getRegistration());
				}
	         }
		String[] resultarr = (String[])result.toArray(new String[] {});
		
		if(resultarr.length > 0 )
			System.out.println(String.join(", ", resultarr));
		
		return resultarr;
	}
	
	/**
	 * Implements  "slot_number_for_registration_number" command 
	 * @param regno
	 * @return - Slot number for the regno
	 */

	public String getSlotByRegno(String regno) {
		String slotno="";
		for(Integer key:occupiedSlots){
			Slot s = (Slot)slots.get(key);
			Vehicle v = s.getVehicle();
			if(v.getRegistration().equalsIgnoreCase(regno)) {
				slotno = key.toString();
			}
		}
		if(!slotno.trim().equalsIgnoreCase(""))
			System.out.println("" + slotno);
		else
			System.out.println("Not Found");
		
		return slotno;
	}	
	
	/**
	 * Implements "status" command
	 * @return - Array of slot information separated by \t
	 */
	public String[] getStatus() {
		
		ArrayList<String> result = new ArrayList<String>();
		result.add("Slot No\tRegistration No\tColour");
		for(Integer key:occupiedSlots){
			Slot s = (Slot)slots.get(key);
			Vehicle v = s.getVehicle();
			result.add(key.toString()+"\t" + v.getRegistration() + "\t" + v.getColour() );
		}
		for(String output: result)
			System.out.println(output);
		
		return result.toArray(new String[] {});
	}
}
