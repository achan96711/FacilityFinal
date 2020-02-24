package Model;

import Data.DataList;
import java.time.LocalDate;
import java.time.Period;


public class Maintenance extends DataList {
/* one issue that affects a facility */
	private LocalDate start, end;
	private int requestID;
	private String requestor, maintenancePerson, problemShortCode ,description;
	private double totalCost, dailyRate, downTime;
	private boolean status;
	
  public Maintenance() {};
	
 public Maintenance(int a, String b, String c, String d, String f, double g, double h, String i, String j){
		requestID = a;
		requestor = b;
		maintenancePerson = c;
		problemShortCode = d;
		description= f;
		dailyRate = g;
		downTime = h;
		start = LocalDate.parse(i);
		end = LocalDate.parse(j);
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
	public int getRequestID() {
		return requestID;
	}
	
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	
	public String getRequestor() {
		return requestor;
	}
	
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	
	public String getProblemShortCode() { /* ie HEAT or COOL */
		return problemShortCode;
	}
	
	public void setProblemShortCode(String problemShortCode) {
		this.problemShortCode = problemShortCode;
	}
	
	public String getMaintenancePerson() {
		return maintenancePerson;
	}
	
	public void setMaintenencePerson(String maintenancePerson) {
		this.maintenancePerson = maintenancePerson;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public double getDailyRate() {
		return dailyRate;
	}
	
	public void setDailyRate (double dailyRate) {
		this.dailyRate = dailyRate;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	
	public void calcTotalCost() {
		totalCost = downTime * dailyRate; /*Faculty Maintenance*/
	}
	
	public double getdownTime() {
		return downTime;
	}
	
	public void calcDownTimeForFacility() {
		Period period = Period.between(start, end); /*Faculty Maintenance*/
	    downTime = period.getDays();
	    
	}
	
	
}
