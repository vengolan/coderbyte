package com.coderbyte.parkinglot;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ParkingLotTests {

	public String getEncolsingMethod() {
		
		String methodName = new Throwable() 
                .getStackTrace()[1] 
                .getMethodName(); 
		return methodName;
	}
	
	@Test
	public void TestCreateParkingLot() {

		System.out.println("===" + getEncolsingMethod() + "=====");

		ParkingLot parkinglot = new ParkingLot();
		int count = parkinglot.init(6);
		assertEquals(count, 6);
	}

	
	@Test
	public void CheckIfLowestSlotIsAllocated() {
		
		System.out.println("===" + getEncolsingMethod() + "=====");
		ParkingLot parkinglot = new ParkingLot();
		int count = parkinglot.init(6);
		
		//park 3 vehicles at slots 1,2,3
		parkinglot.Park(new Vehicle("KA-01-HH-1234", "White"));
		parkinglot.Park(new Vehicle("KA-01-HH-9999", "White"));
		parkinglot.Park(new Vehicle("KA-01-BB-0001", "Blue"));
		
		//now empty slot 2 
		parkinglot.Leave(2);
		
		//now park another vehicle, and it should be allotted the lowest slot 2 
		int newslot = parkinglot.Park(new Vehicle("KA-01-HH-7777", "Red"));
		assertEquals(2, newslot);
	}


	@Test
	public void checkLeaveOnEmptySlot() {
		System.out.println("===" + getEncolsingMethod() + "=====");	
		ParkingLot parkinglot = new ParkingLot();
		int count = parkinglot.init(5);
		
		int slot = parkinglot.Leave(2);
		assertEquals(-1,slot);
	}
	
	@Test
	public void checkParkOnOccupiedSlot() {

		System.out.println("===" + getEncolsingMethod() + "=====");
		ParkingLot parkinglot = new ParkingLot();
		int count = parkinglot.init(3);

		
		//park 3 vehicles at slots 1,2,3
		parkinglot.Park(new Vehicle("KA-01-HH-1234", "White"));
		parkinglot.Park(new Vehicle("KA-01-HH-9999", "White"));
		parkinglot.Park(new Vehicle("KA-01-BB-0001", "Blue"));

		int slot = parkinglot.Park(new Vehicle("KA-01-BB-0002", "Yellow"));
		assertEquals(-1, slot);
		
	}
	
	@Test
	public void checkGetSlotsByColor() {

		System.out.println("===" + getEncolsingMethod() + "=====");
		ParkingLot parkinglot = new ParkingLot();
		int count = parkinglot.init(5);	
		
		parkinglot.Park(new Vehicle("KA-01-HH-1234", "White"));
		parkinglot.Park(new Vehicle("KA-01-HH-9999", "White"));
		parkinglot.Park(new Vehicle("KA-01-BB-0001", "Yellow"));
		parkinglot.Park(new Vehicle("KA-01-HH-2701", "Blue"));
		parkinglot.Park(new Vehicle("KA-01-HH-3141", "White"));

		
		String[] slots = parkinglot.getSlotsByColor("White");
		String[] expected = {"1","2","5"};
		
		assertArrayEquals(expected, slots);
		
	}
	
	
	
	@Test 
	public void checkGetRegnoByColor() {
		System.out.println("===" + getEncolsingMethod() + "=====");
		ParkingLot parkinglot = new ParkingLot();
		int count = parkinglot.init(5);	
		
		parkinglot.Park(new Vehicle("KA-01-HH-1234", "White"));
		parkinglot.Park(new Vehicle("KA-01-HH-9999", "White"));
		parkinglot.Park(new Vehicle("KA-01-BB-0001", "Yellow"));
		parkinglot.Park(new Vehicle("KA-01-HH-2701", "Blue"));
		parkinglot.Park(new Vehicle("KA-01-HH-3141", "White"));
		
		String[] slots = parkinglot.getRegnosByColor("White");
		String[] expected = {"KA-01-HH-1234","KA-01-HH-9999","KA-01-HH-3141"};
		
		assertArrayEquals(expected, slots);
	}
	
	
	@Test
	public void checkSlotByRegNo() {
		
		System.out.println("===" + getEncolsingMethod() + "=====");
		ParkingLot parkinglot = new ParkingLot();
		int count = parkinglot.init(3);	
		
		parkinglot.Park(new Vehicle("KA-01-HH-1234", "White"));
		parkinglot.Park(new Vehicle("KA-01-HH-9999", "White"));
		parkinglot.Park(new Vehicle("KA-01-BB-0001", "Yellow"));
		
		String slot = parkinglot.getSlotByRegno("KA-01-HH-9999");
		assertEquals("2", slot);		
	}
	
	@Test
	public void checkStatus() {
		System.out.println("===" + getEncolsingMethod() + "=====");
		ParkingLot parkinglot = new ParkingLot();
		int count = parkinglot.init(3);	
		
		parkinglot.Park(new Vehicle("KA-01-HH-1234", "White"));
		parkinglot.Park(new Vehicle("KA-01-HH-9999", "White"));
		parkinglot.Park(new Vehicle("KA-01-BB-0001", "Yellow"));
		
		String[] expected = {"Slot No\tRegistration No\tColour","1\tKA-01-HH-1234\tWhite","2\tKA-01-HH-9999\tWhite","3\tKA-01-BB-0001\tYellow"};
		assertArrayEquals(expected, parkinglot.getStatus());
	}
}


