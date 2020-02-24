package View;

import Model.*;
import Data.DataList;
import java.util.*;

public class UserPanel extends FacilityGroup {
static int input = 25;

 public static void main(String args[]) {
	 
	 Scanner keyboard = new Scanner(System.in);
	 while(input != 0){
	 System.out.println("User, What would you like to do?. Enter a number between 1 - 20 to select an action. Enter 0 to quit.");
	 System.out.println("1: addNewFacility");
	 System.out.println("2: removeFacility");
	 System.out.println("3: listFacilities");
	 System.out.println("4: addFacilityDetail");
	 System.out.println("5: requestAvailableCapacity");
	 System.out.println("6: getFacilityInformation");
	 System.out.println("7: assignFacilityToUse");
	 System.out.println("8: vacateFacility");
	 System.out.println("9: isInUseDuringInterval");
	 System.out.println("10: calcUsageRate");
	 System.out.println("11: listActualUsage");
	 System.out.println("12: listInspections");
	 System.out.println("13: makeFacilityMaintRequest / schedule maintenance");
	 System.out.println("14: calcMaintenanceCost");
	 System.out.println("15: calcProblemRate");
	 System.out.println("16: calcDownTime");
	 System.out.println("17: listMaintRequest");
	 System.out.println("18: listMaintenance");
	 System.out.println("19: listFacilityProblems");
	 
	 FacilityGroup business = new FacilityGroup();
	 Facility hold = new Facility();
	 int id;
	 String detail;
	 double result;
	 
	 input = keyboard.nextInt();
	 switch(input){
		 case 1:   System.out.println("Please enter facility information: ");           
		 System.out.println("Please enter facilityID: ");
		     int a = keyboard.nextInt();
		     keyboard.nextLine();
		 System.out.println("Please enter facility Name: ");
			String b = keyboard.nextLine();
	     System.out.println("Please enter current capacity: ");
			int c = keyboard.nextInt();
			keyboard.nextLine();
		 System.out.println("Please enter max capacity: ");
			int d = keyboard.nextInt();
			keyboard.nextLine();
		 System.out.println("Please enter number of rooms: ");
			int e = keyboard.nextInt();
			keyboard.nextLine();
		 System.out.println("Please enter status: ");
			String f = keyboard.nextLine();
		 System.out.println("Please enter user: ");
			String g = keyboard.nextLine();
		 System.out.println("Please enter facility use start date: (Year-Month-Day) ");
		    String h = keyboard.nextLine();
		 System.out.println("Please enter facility use end date: (Year-Month-Day) ");
		    String i = keyboard.nextLine();
		    
		  Facility building = new Facility(a,b,c,d,e,f,g,h,i);
		  business.addNewFacility(building);
		  System.out.println("Facility successfully added to owned facilities");	
			
			 break; //addFacility
		 case 2:				//removeFacility
			 if(business.holdings.size() > 0) {
				 System.out.println("Please enter the facilityID you want to remove from the list of facilities: ");
				 id = keyboard.nextInt();
				 for(int j = 0; j < business.holdings.size();j++) {
						if (id == holdings.get(j).getFacilityID()) {
					 hold = holdings.get(j);
					 business.removeFacility(hold);
					 break;
						}
			  else {
				 System.out.println("Error: unable to remove building from the list.");
			 }
			}
		}
			 break;
		 case 3:				//listFacilities
			 business.listFacilities();
			 break;
		 case 4:                 //addFacilityDetail
			 System.out.println("Please enter the string that will be the business detail : ");
			 detail = keyboard.nextLine();
			 keyboard.nextLine();
			 System.out.println("Please enter the facilityID you want to add this detail to: ");
			 id = keyboard.nextInt();
			 keyboard.nextLine();
			 business.getFacility(id).addFacilityDetail(detail);
			 break;
		 case 5: 
			 System.out.println("Please enter the facilityID you want to find the available capacity of: ");
			 id = keyboard.nextInt();
			 System.out.println("Available capacity: " + business.getFacility(id).requestAvailableCapacity());//requestAvailableCapacity
			 break;
		 case 6:				//getFacilityInformation - end of Facility
			 System.out.println("Please enter the facilityID you want to find the details of: ");
			 id = keyboard.nextInt();
			 business.getFacilityInfo(id);
			 break;
		 case 7:                 //assignFacilityToUse
			 System.out.println("Please enter the string that will be the user added : ");
			 detail = keyboard.nextLine();
			 System.out.println("Please enter the facilityID you want to add this detail to: ");
			 id = keyboard.nextInt();
			 business.getFacility(id).assignFacilityToUse(detail);
			 break;
		 case 8:				//vacate Facility-removal of user 
			 System.out.println("Please enter the facilityID you want to modify to remove the user: ");
			 id = keyboard.nextInt();
			 business.getFacility(id).vacateFacility();
			 break;
		 case 9:				//isInUseDuringInterval
			 System.out.println("Please enter the facilityID you want to retrieve the interval of use from: ");
			 id = keyboard.nextInt();
			 result = business.getFacility(id).isInUseDuringInterval();
			 System.out.println("Interval: " + result + " days ");
			 break;
		 case 10:                 //calcUsageRate
			 System.out.println("Please enter the facilityID you want to calculate usage rate for ");
			 id = keyboard.nextInt();
			 result = business.getFacility(id).calcUsageRate();
			 System.out.println("Usage Rate: " + result );
			 break;
		 case 11:				//listActualUsage
			 System.out.println("Please enter the facilityID you want to list actual usage for ");
			 id = keyboard.nextInt();
			 result = business.getFacility(id).listActualUsage();
			 System.out.println("Actual Usage: " + result + " days ");
			 break;
		 case 12:				//listInspections - end of FacilityUse
			 System.out.println("Please enter the facilityID you want to add this detail to: ");
			 id = keyboard.nextInt();
			 business.getFacility(id).listInspections();
			 break;
		 case 13:                 //makeFacilityMaintenanceRequest or scheduleMaintenance
			 System.out.println("Please enter Maintenance information: ");           
			 System.out.println("Please enter RequestID: ");
			     int rID = keyboard.nextInt();
			     keyboard.nextLine();
			 System.out.println("Please enter requestor Name: ");
				String rName = keyboard.nextLine();
		     System.out.println("Please enter maintenance person: ");
				String mName = keyboard.nextLine();
			 System.out.println("Please enter problem short code: ");
				String probCode = keyboard.nextLine();
			 System.out.println("Please enter problem description: ");
				String pDesc = keyboard.nextLine();
			 System.out.println("Please enter daily rate for maintenance: ");
				double dRate = keyboard.nextDouble();
				keyboard.nextLine();
			 System.out.println("Please enter estimated down time in days: ");
				double downTime = keyboard.nextDouble();
				keyboard.nextLine();
			 System.out.println("Please enter maintenance start date: ");
			    String mStart = keyboard.nextLine();
			 System.out.println("Please enter maintenance end date: ");
			    String mEnd = keyboard.nextLine();
			    
			 Maintenance blank = new Maintenance(rID, rName, mName, probCode, pDesc, dRate, downTime, mStart, mEnd);
			 System.out.println("Please enter the facilityID you want to make a request for: "); 
			 id = keyboard.nextInt();
			 business.getFacility(id).scheduleMaintenance(blank);
			 break;
		
		 case 14:				//calcMaintenanceCost
			 System.out.println("Please enter the facilityID you want to calculate maintenance cost for: ");
			 id = keyboard.nextInt();
			 business.getFacility(id).m.calcMaintenanceCost();
			 double tc =  business.getFacility(id).m.getMaintenanceCost();
			 System.out.println("Total Facility Maintenance cost: " + tc);
			 break;
		 case 15:                 //calculateProblemRate
			 System.out.println("Please enter the facilityID you want to calculate problem rate for: ");
			 id = keyboard.nextInt();
			 business.getFacility(id).m.calcProblemRateForFacility();
			 double pr =  business.getFacility(id).m.getProblemRate();
			 System.out.println("Total Facility Problem Rate " + pr);
			 break;
		 case 16:				//calculateDownTime
			 System.out.println("Please enter the facilityID you want to calculate down time for: ");
			 id = keyboard.nextInt();
			 business.getFacility(id).m.calcDownTimeForFacility();
			 double dt =  business.getFacility(id).m.getTotalFacilityDownTime();
			 System.out.println("Total Facility Problem Rate " + dt);
			 break;
		 case 17:				//listMaintenanceRequest 
			 System.out.println("Please enter the facilityID you want to add this detail to: ");
			 id = keyboard.nextInt();
			 business.getFacility(id).m.listMaintenanceRequest();
			 break;
		 case 18:				//listMaintenance
			 System.out.println("Please enter the facilityID you want to add this detail to: ");
			 id = keyboard.nextInt();
			 business.getFacility(id).listMaintenance();
			 break;
		 case 19:				//listFacilityProblems 
			 System.out.println("Please enter the facilityID you want to add this detail to: ");
			 id = keyboard.nextInt();
			 business.getFacility(id).listFacilityProblems();
			 break;
		
		
	 }
	}
	 keyboard.close();
	 System.out.println("Program terminated");
 }
}
