package Model;

import java.util.*;


public class FacilityGroup  {
	/*Facility Group*/
	public ArrayList<Facility> holdings = new ArrayList<>();
	
	Facility temp = new Facility();
	Facility s = new Facility();
	
	public void addNewFacility(Facility f) {
		this.holdings.add(f);
	}
	
	public void removeFacility(Facility f) {
		this.holdings.remove(f);
	}
	
	public Facility getFacility(int id) {
	  for(int j = 0; j < this.holdings.size();j++) {
		if (id == this.holdings.get(j).getFacilityID()) {
			s = this.holdings.get(j);
		}
		else {
			s = null;
		}
	  }
	  return s;
	}
	
	public void listFacilities() {
		for(int i = 0; i < this.holdings.size(); i++) {
		int tempID = this.holdings.get(i).getFacilityID();
		String tempName = this.holdings.get(i).getName();
		System.out.println("ID: " + tempID + ", Facility Name: " + tempName + " ");
		
		}
	}
	
	public void getFacilityInfo(int ID) {
		for(int j = 0; j < this.holdings.size(); j++) {
			if(this.holdings.get(j).getFacilityID() == ID) {
				temp = this.holdings.get(j);
				break;
			}
		}
		
		if (temp.getFacilityID() == 0) {
			System.out.println("Error: facility not found with ID input...");
		}
		
		else {
			System.out.println("ID: " + temp.getFacilityID()  + " ");
			System.out.println("Facility Name: " + temp.getName() + " ");
			System.out.println("User: " + temp.getFacilityUser() + " ");
			System.out.println("Status: " + temp.getFacilityStatus()  + " ");
			System.out.println("Available Capacity: " + temp.requestAvailableCapacity() + " ");
			System.out.println("Max Capacity: " + temp.getMaxCapacity()  + " ");
			System.out.println("Number of Rooms: " + temp.getnumRoom()  + " ");
			System.out.println("");
			System.out.println("Facility Extra Info added by user: ");
			System.out.println("");
			
			if(temp.facilityDetail.size() > 0) {
				for(int measure = 0; measure < temp.facilityDetail.size(); measure++) {
					System.out.println(temp.getFacilityDetail(measure));
				}
					
			}
			
		}
		
	}
}
