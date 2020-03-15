package Model;

import java.util.*;
import java.time.LocalDate;
import java.time.Period;
import Data.DataList;

public class Inspection {
	
private String inspector, facilityName;
private int facilityID;
private boolean pass;
private String dateOfLastInspection, expirationDate;

public Inspection () {}

public Inspection(String inspect, String fn, int fi, boolean result, String DOLI, String ED) {
	inspector = inspect;
	facilityName = fn;
	facilityID = fi;
	pass = result;
	dateOfLastInspection = DOLI;
	expirationDate = ED;
}

public int getFacilityID() {
	return facilityID;
}

public void setFacilityID(int facilityID) {
	this.facilityID = facilityID;
}

public String getFacilityName() {
	return facilityName;
}

public void setFacility(String facilityName) {
	this.facilityName = facilityName;
}

public String getInspector() {
	return inspector;
}

public void setInspector(String inspector) {
	this.inspector = inspector;
}

public boolean getPass() {
	return pass;
}

public void setPass(boolean pass) {
	this.pass=pass;
}

public String getDateOfLastInspection() {
	return dateOfLastInspection;		
}

public void setDateOfLastInspection (String dateOfLastInspection) {
	this.dateOfLastInspection = dateOfLastInspection;

}

public String getExpirationDate() {
	return expirationDate;		
}

public void setExpirationDate (String expirationDate) {
	this.expirationDate = expirationDate;

}



}
