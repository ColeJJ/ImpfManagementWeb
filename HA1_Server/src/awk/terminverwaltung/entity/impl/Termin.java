package awk.terminverwaltung.entity.impl;

import java.time.LocalDate;

import awk.terminverwaltung.entity.TerminTO;

public class Termin {
	
	//Eigenschaften
	private int terminID;
	private LocalDate datum;
	private String uhrzeit;
	private int patientID;
	private boolean wahrgenommen;
	
	//Konstruktoren
	public Termin(int terminID, LocalDate datum, String uhrzeit, int patientID, boolean wahrgenommen) {
		this.terminID = terminID;
		this.datum = datum;
		this.uhrzeit = uhrzeit;
		this.patientID = patientID;
		this.wahrgenommen = wahrgenommen;
	}
	
	public Termin(LocalDate datum, String uhrzeit, int patientID) {
		this.datum = datum;
		this.uhrzeit = uhrzeit;
		this.patientID = patientID;
	}
	
	//Transportobjekt erzeugen
	public TerminTO toTerminTO() {
		TerminTO aTerminTO = new TerminTO();
		aTerminTO.setTerminID(this.getTerminID());
		aTerminTO.setDatum(this.getDatum());
		aTerminTO.setUhrzeit(this.getUhrzeit());
		aTerminTO.setPatientID(this.getPatientID());
		aTerminTO.setWahrgenommen(this.isWahrgenommen());
		return aTerminTO;
	}

	public boolean isWahrgenommen() {
		return wahrgenommen;
	}

	public void setWahrgenommen(boolean wahrgenommen) {
		this.wahrgenommen = wahrgenommen;
	}

	public int getTerminID() {
		return terminID;
	}

	public void setTerminID(int terminID) {
		this.terminID = terminID;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public String getUhrzeit() {
		return uhrzeit;
	}

	public void setUhrzeit(String uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	
	

}
