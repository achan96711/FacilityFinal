package Model;
import java.util.*;
import Data.DataList;

public class MaintenanceSchedule  {
/* a list of issues for one facility */
	
	/*maintenance schedule */
	public ArrayList<Maintenance> schedule = new ArrayList<>();
	private double totalFacilityMaintenanceCost, problemRate, totalFacilityDownTime;
	Maintenance s = new Maintenance();
	
	public void makeFacilityMaintRequest(Maintenance m) { /* facility maintenance */
		schedule.add(m);
	}
	
	public void removeMaintenance(Maintenance m) {
		schedule.remove(m);
	}
	
	public Maintenance getMaintenance(int id) {
		for(int j = 0; j < schedule.size();j++) {
			if (id == schedule.get(j).getRequestID()) {
				s = schedule.get(j);
			}
			else {
				s = null;
			}
		  }
		  return s;
	}
	
	public double getMaintenanceCost() {   /* returns total maintenance cost of entire facility */
		return totalFacilityMaintenanceCost;
	}
	
	public void calcMaintenanceCost() {
		totalFacilityMaintenanceCost = 0; /*facility maintenance */
		for(int i = 0; i < schedule.size(); i++) {
			double temp = schedule.get(i).calcTotalCost(); /*retrieves total cost from each maintenance and sums them up */
			totalFacilityMaintenanceCost = totalFacilityMaintenanceCost + temp;
		}
	}
	
	public double getProblemRate() { 
		return problemRate;              /* returns rate of issues occurring for entire facility,facility maintenance */
	}
	
	public void calcProblemRateForFacility() { /*facility maintenance */
		problemRate = schedule.size() / 100.0 ;
	}
	
	public double getTotalFacilityDownTime() {
		return totalFacilityDownTime;    /* returns total down time of entire facility */
	}
	
	public void listMaintenanceRequest(){
		for(int i = 0; i < schedule.size(); i++) {
		int ID = schedule.get(i).getRequestID();
		String person = schedule.get(i).getRequestor();
		String code = schedule.get(i).getProblemShortCode();
		String problem = schedule.get(i).getDescription();
		System.out.println("");
		System.out.println("ID: " + ID + " ");
		System.out.println("Requestor: " + person + " ");
		System.out.println("Issue: " + code + " ");
		System.out.println("Description: " + problem + " ");
		}
	}
	
	public void calcDownTimeForFacility() { /*facility maintenance */
		totalFacilityDownTime = 0;
		for(int i = 0; i < schedule.size(); i++) {
			double temp = schedule.get(i).getdownTime(); /*retrieves total cost from each maintenance and sums them up */
			totalFacilityDownTime = totalFacilityDownTime + temp;
		}
		
	}
}
