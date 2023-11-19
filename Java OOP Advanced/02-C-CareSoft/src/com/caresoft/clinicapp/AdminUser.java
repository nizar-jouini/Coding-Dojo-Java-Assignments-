package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

	private String role;
	private ArrayList<String> securityIncidents;

	// Implement a constructor that takes an ID and a role
	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
	}
	
	// Implement HIPAACompliantUser!
	@Override
	public boolean assignPin(int pin) {
		int length = String.valueOf(pin).length();
		if (length < 6) {
			return false;
		} else {
			this.id = pin;
		}
		return true;
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID != this.id) {
			this.authIncident();
			return false;
		}
		return true;
	}
	
	// Implement HIPAACompliantAdmin!
	
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return this.securityIncidents;
	}

	public void newIncident(String notes) {
		String report = String.format("Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", new Date(),
				this.id, notes);
		securityIncidents.add(report);
	}

	public void authIncident() {
		String report = String.format("Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", new Date(), this.id,
				"AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}

	// Setters & Getters
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	

}
