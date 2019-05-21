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
	
	public void init(int noOfSlots) {
		emptySlots = new ArrayList<Integer>();
		occupiedSlots = new ArrayList<Integer>();;
		slots = new HashMap<Integer,Slot>();

		
		//create empty slots
		for(int i=0; i < noOfSlots; i++) {
			emptySlots.add(new Integer(i+1));
			slots.put(new Integer(i+1),new Slot(i+1));
		}
		System.out.println("Created a parking lot with" + noOfSlots + " slots");
	
	}
	
	public void Park(Vehicle v) {
		
		if (emptySlots.size() == 0 ) {
			System.out.println("Sorry, parking lot is full");
			return;
		}
		
		int slotno = emptySlots.get(0);
		emptySlots.remove(0);
		Collections.sort(emptySlots);
		
		occupiedSlots.add(new Integer(slotno));
		Slot slot = slots.get(slotno);
		slot.setVehicle(v);
		
		System.out.println("Alloted slot number: " + slotno );
	}
	
	public void Leave(int slotno) {
	
		if(!occupiedSlots.contains(new Integer(slotno))) {
			System.out.println("Sorry, no vehicle parked in slot " + slotno);
			return;
		}
		
		Slot slot = slots.get(slotno);
		slot.setVehicle(null);
		
		emptySlots.add(new Integer(slotno));
		occupiedSlots.remove(new Integer(slotno));
		
		Collections.sort(emptySlots);
	}
	
	public void getSlotsByColor(String color) {
		
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
		
	}
	
	public void getRegnosByColor(String color) {

		ArrayList<String> result = new ArrayList<String>();
		for(Integer key: occupiedSlots){
				Slot s = (Slot)slots.get(key);
				Vehicle v = s.getVehicle();
				if(v.getColour().equalsIgnoreCase(color)) {
					result.add(v.getRegistration());
				}
	         }
		String[] resultarr = (String[])result.toArray();
		
		if(resultarr.length > 0 )
			System.out.println(String.join(", ", resultarr));
	}
	

	public void getSlotByRegno(String regno) {
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
	}	
	
	public void getStatus() {
		
		ArrayList<String> result = new ArrayList<String>();
		result.add("Slot No\tRegistration No\tColour");
		for(Integer key:occupiedSlots){
			Slot s = (Slot)slots.get(key);
			Vehicle v = s.getVehicle();
			result.add(key.toString()+"\t" + v.getRegistration() + "\t" + v.getColour() );
		}
		for(String output: result)
			System.out.println(output);		
	}
}
