package com.coderbyte.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
	
	private ArrayList<Integer> emptySlots;
	private ArrayList<Integer> occupiedSlots;
	private HashMap<Integer,Slot> slots;
	
	public ParkingLot() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isReady() {
		if(slots == null) {
			System.out.println("Please Initialize parking lot by running the \"create_parking_lot <slots>\" command");
			return false;
		}
		return true;
	}
	
	public int init(int noOfSlots) {
		emptySlots = new ArrayList<Integer>();
		occupiedSlots = new ArrayList<Integer>();;
		slots = new HashMap<Integer,Slot>();

		
		//create empty slots
		for(int i=0; i < noOfSlots; i++) {
			emptySlots.add(new Integer(i+1));
			slots.put(new Integer(i+1),new Slot(i+1));
		}
		System.out.println("Created a parking lot with" + noOfSlots + " slots");
		return slots.size();
	
	}
	
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
		
		System.out.println("Alloted slot number: " + slotno );
		return slotno;
	}
	
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
			System.out.println("Allocated slot number:" + slotno);
		else
			System.out.println("Not Found");
		
		return slotno;
	}	
	
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
