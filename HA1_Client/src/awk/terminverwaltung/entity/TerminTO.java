package awk.terminverwaltung.entity;

import java.io.Serializable;
import java.time.LocalDate;

import awk.terminverwaltung.entity.impl.Termin;

public class TerminTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7722320900024156408L;
	
	//Eigenschaften
	private int terminID;
	private LocalDate datum;
	private String uhrzeit;
	private int patientID;
	private boolean wahrgenommen;

	//Konstruktor
	public TerminTO() {
	}
	
	//Terminobjekt erzeugen
	public Termin toTermin() {
		Termin aTermin = new Termin(
				this.getTerminID(),
				this.getDatum(),
				this.getUhrzeit(),
				this.getPatientID(),
				this.isWahrgenommen());
		return aTermin;
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
	
	public boolean isWahrgenommen() {
		return wahrgenommen;
	}

	public void setWahrgenommen(boolean wahrgenommen) {
		this.wahrgenommen = wahrgenommen;
	}

}
