package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

	// Inside class:
	private ArrayList<String> patientNotes;

	// Constructor that takes an ID
	public Physician(Integer id) {
		super(id);
		this.patientNotes = new ArrayList<>();
	}

	// Implement HIPAACompliantUser!
	@Override
	public boolean assignPin(int pin) {
		int length = String.valueOf(pin).length();
		if (length < 4) {
			return false;
		} else {
			this.setId(pin);
		}
		return true;
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID != this.id) {
			return false;
		}
		return true;
	}

	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Datetime Submitted: %s \n", date);
		report += String.format("Reported By ID: %s\n", this.id);
		report += String.format("Patient Name: %s\n", patientName);
		report += String.format("Notes: %s \n", notes);
		this.patientNotes.add(report);
	}

	// Getters & Setters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}
	
	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
	
}
