package de.impf.patient.entity.internal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import de.impf.patient.entity.PatientTO;

@Entity
@Access(AccessType.FIELD)
@Table(name="HA2_Patient")
@NamedQuery(name="Patient.findPatientByName", query="select p from Patient p where p.name = :name")
@NamedQuery(name="Patient.findPatientByFirstAndLastName", query="select p from Patient p where p.name = :name and p.vorname = :vorname")
public class Patient {
	
	public static final String FIND_BY_NAME = "Patient.findPatientByName";
	public static final String FIND_BY_FIRST_AND_LASTNAME = "Patient.findPatientByFirstAndLastName";
	
	//Variablen
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IMPF_PATIENT_ID")
	@SequenceGenerator(name="IMPF_PATIENT_ID", sequenceName="IMPF_SEQ_PATIENT_ID", allocationSize=1)
	private int patientenID;
	
	private String name;
	private String vorname;
	private LocalDate geburtsdatum;
	private String mail;
	private String telefonNr;
	
	//Konstruktor
	public Patient() {
	}
	
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
	
	public PatientTO toPatientTO() {
		//Set Pattern for convertion of LocalDate to String
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		
		PatientTO aPatientTO = new PatientTO();
		aPatientTO.setPatientenID(this.getPatientenID());
		aPatientTO.setName(this.getName());
		aPatientTO.setVorname(this.getVorname());
		aPatientTO.setGeburtsdatum(this.getGeburtsdatum().format(formatter));
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
