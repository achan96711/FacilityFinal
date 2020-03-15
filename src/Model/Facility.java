package Model;

import java.util.*;
import java.time.LocalDate;
import java.time.Period;
import Data.DataList;

public class Facility  {
	private LocalDate start, end;
	private int facilityID, currentCapacity, maxCapacity, numRoom;
	private String name,status, user;
	private double workTime, actualUsage, actualUsageRate;
	public ArrayList<String> facilityDetail = new ArrayList<>();
	public ArrayList<String> maintenanceWorkers = new ArrayList<>();
	public ArrayList<Maintenance> temporaryProblems = new ArrayList<>();
	public ArrayList<Inspection> inspectionList = new ArrayList<>();
	
	public MaintenanceSchedule m = new MaintenanceSchedule();
	
	public Facility(){};
	
	public Facility(int a, String b, int c, int d, int f, String g, String h, String i, String j){
		facilityID = a;
		name = b;
		currentCapacity = c;
		maxCapacity = d;
		numRoom = f;
		status = g;
		user = h;
		start = LocalDate.parse(i);
		end = LocalDate.parse(j);
	}
	
	public double listActualUsage() {
		actualUsage = workTime - m.getTotalFacilityDownTime();
		return actualUsage;
	}
	
	public double calcUsageRate() {
		actualUsageRate = (workTime - m.getTotalFacilityDownTime()) / workTime;
		return actualUsageRate;
	}
	
	public String getFacilityUser() {
		return user;
	}
	
	public void assignFacilityToUse(String user) {
		this.user = user;
	}
	
	public void scheduleMaintenance(Maintenance addition) {
		m.makeFacilityMaintRequest(addition);
	}
	
	public void listFacilityProblems() {
		for(int i = 0; i < m.schedule.size(); i++) {
			String code = m.schedule.get(i).getProblemShortCode();
			String description = m.schedule.get(i).getDescription();
			System.out.println("Issue: " + code + " ");
			System.out.println("Description: " + description + " ");
			System.out.println(" ");
		}
	}
	
	public void listMaintenance() {
		temporaryProblems = m.schedule;
		for(int i = 0; i < temporaryProblems.size(); i++) {
			String worker = temporaryProblems.get(i).getMaintenancePerson();
			if(maintenanceWorkers.contains(worker) == false) {
				maintenanceWorkers.add(worker);
			}
		}
		if (maintenanceWorkers.size() == 0) {
			System.out.println("There are no maintenance workers for this facility.");
		}
		else {
			System.out.println("Maintenance workers: ");
			for (int i = 0; i < maintenanceWorkers.size(); i++) {
				System.out.println(maintenanceWorkers.get(i));	
			}
		}
	}
	public LocalDate getStart() {
		return start;		
	}
	
	public void setStart(LocalDate start) {
		this.start = start;
	}
	
	public LocalDate getEnd() {
		return end;		
	}
	
	public void setEnd(LocalDate end) {
		this.end = end;
	}
	
	public double isInUseDuringInterval() {
		Period period = Period.between(start, end); 
	    workTime = period.getDays();
	    return workTime;
	}
	
	public int getFacilityID() {
		return facilityID;
	}
	
	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	public int getCurrentCapacity() {
		return currentCapacity;
	}
	
	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}
	
	public void vacateFacility() {
		this.user = null;
	}
	
	public int getnumRoom() {
		return numRoom;
	}
	
	public void setNumRoom(int numRoom) {
		this.numRoom = numRoom;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFacilityStatus() {
		return status;
	}
	
	public void setFacilityStatus(String status) {
		this.status = status;
	}
	
	public int requestAvailableCapacity() {
		int availableCapacity = maxCapacity - currentCapacity;
		return availableCapacity;
	}
	
	public void addFacilityDetail(String s) {
	facilityDetail.add(s);
	}
	
	public void removeFacilityDetail(String s) {
	facilityDetail.remove(s);	
	}
	
	public String getFacilityDetail(int i) {
	return facilityDetail.get(i);	
	}
	
	public void addInspection(Inspection i) {
	inspectionList.add(i);
	}
		
	public void removeInspection(Inspection i) {
	inspectionList.remove(i);	//listed here but have not added to user panel yet
	}
		
	public void getInspection(int i) {
	inspectionList.get(i);	
	}
	
	public void listInspections() {
		for(int i = 0; i < inspectionList.size(); i++) {
			int ID = inspectionList.get(i).getFacilityID();
			String building = inspectionList.get(i).getFacilityName();
			String inspector = inspectionList.get(i).getInspector();
			String doli = inspectionList.get(i).getDateOfLastInspection();
			String expireDate = inspectionList.get(i).getExpirationDate();
			boolean result = inspectionList.get(i).getPass();
			System.out.println("Facility ID: " + ID + " ");
			System.out.print("Facility Name: " + building + " ");
			System.out.print("Inspector: " + inspector + " ");
			System.out.print("Date of Last Inspection: " + doli + " ");
			System.out.print("Certification Expiration Date: " + expireDate + " ");
			System.out.print("Certification Result: " + result + " ");
			}
	}
}
