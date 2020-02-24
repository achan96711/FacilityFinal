package Model;

import java.time.LocalDate;

public class Inspection {
	
private String inspector, facilityName;
private int facilityID;
private boolean pass;
private LocalDate dateOfLastInspection, expirationDate;

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

public LocalDate getDateOfLastInspection() {
	return dateOfLastInspection;		
}

public void setDateOfLastInspection (LocalDate dateOfLastInspection) {
	this.dateOfLastInspection = dateOfLastInspection;

}

public LocalDate getExpirationDate() {
	return expirationDate;		
}

public void setExpirationDate (LocalDate expirationDate) {
	this.expirationDate = expirationDate;

}



}
