package Model;

import java.util.*;


public class FacilityGroup extends Facility{

	Facility temp = new Facility();
	Facility s = new Facility();
	public void addNewFacility(Facility f) {
		holdings.add(f);
	}
	
	public void removeFacility(Facility f) {
		holdings.remove(f);
	}
	
	public Facility getFacility(int id) {
	  for(int j = 0; j < holdings.size();j++) {
		if (id == holdings.get(j).getFacilityID()) {
			s = holdings.get(j);
		}
		else {
			s = null;
		}
	  }
	  return s;
	}
	
	public void listFacilities() {
		for(int i = 0; i < holdings.size(); i++) {
			int tempID = holdings.get(i).getFacilityID();
		String tempName = holdings.get(i).getName();
		System.out.println("ID: " + tempID + " ");
		System.out.print("Facility Name: " + tempName + " ");
		}
	}
	
	public void getFacilityInfo(int ID) {
		for(int j = 0; j < holdings.size(); j++) {
			if(holdings.get(j).getFacilityID() == ID) {
				temp = holdings.get(j);
				break;
			}
		}
		
		if (temp.getFacilityID() == 0) {
			System.out.println("Error: facility not found with ID input...");
		}
		
		else {
			System.out.println("ID: " + temp.getFacilityID()  + " ");
			System.out.println("Facility Name: " + temp.getName() + " ");
			System.out.println("Status: " + temp.getFacilityStatus()  + " ");
			System.out.println("Available Capacity: " + temp.requestAvailableCapacity() + " ");
			System.out.println("Max Capacity: " + temp.getMaxCapacity()  + " ");
			System.out.println("Number of Rooms: " + temp.getnumRoom()  + " ");
			
		}
		
	}
}
