package de.impf.patient.entity;

import java.io.Serializable;
import java.time.LocalDate;

import de.impf.patient.entity.internal.Patient;


public class PatientTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2968133220811123538L;
	
	//Variablen
	private int patientenID;
	private String name;
	private String vorname;
	private LocalDate geburtsdatum;
	private String mail;
	private String telefonNr;
	
	public PatientTO() {
	}
	
	public Patient toPatient() {
		Patient aPatient = new Patient(
				this.getPatientenID(),
				this.getName(),
				this.getVorname(),
				this.getGeburtsdatum(),
				this.getMail(),
				this.getTelefonNr());
		return aPatient;
	}
	
	public String toString() {
		return this.getPatientenID() + ", " + this.getName() + ", " + this.getVorname();
	}

	public int getPatientenID() {
		return patientenID;
	}

	public void setPatientenID(int patientenID) {
		this.patientenID = patientenID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(String telefonNr) {
		this.telefonNr = telefonNr;
	}

}
