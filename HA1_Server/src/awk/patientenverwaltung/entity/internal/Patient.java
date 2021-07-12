package awk.patientenverwaltung.entity.internal;

import java.time.LocalDate;

import awk.patientenverwaltung.entity.PatientTO;

public class Patient {
	
	//Variablen
	private int patientenID;
	private String name;
	private String vorname;
	private LocalDate geburtsdatum;
	private String mail;
	private String telefonNr;
	
	//Konstruktor
	public Patient(int patientenID, String name, String vorname, LocalDate geburtsdatum, String mail, String telefonNr) {
		this.patientenID = patientenID;
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
		this.mail = mail;
		this.telefonNr = telefonNr;
	}
	
	public Patient(String name, String vorname, LocalDate geburtsdatum, String mail, String telefonNr) {
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
		this.mail = mail;
		this.telefonNr = telefonNr;
	}
	
	public Patient(PatientTO aPatientTO) {
		this.patientenID = aPatientTO.getPatientenID();
		this.name = aPatientTO.getName();
		this.vorname = aPatientTO.getVorname();
		this.geburtsdatum = aPatientTO.getGeburtsdatum();
		this.mail = aPatientTO.getMail();
		this.telefonNr = aPatientTO.getTelefonNr();
	}
	
	public PatientTO toPatientTO() {
		PatientTO aPatientTO = new PatientTO();
		aPatientTO.setPatientenID(this.getPatientenID());
		aPatientTO.setName(this.getName());
		aPatientTO.setVorname(this.getVorname());
		aPatientTO.setGeburtsdatum(this.getGeburtsdatum());
		aPatientTO.setTelefonNr(this.getTelefonNr());
		aPatientTO.setMail(this.getMail());
		return aPatientTO;
		
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
