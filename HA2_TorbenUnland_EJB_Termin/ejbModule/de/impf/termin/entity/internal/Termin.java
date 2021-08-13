package de.impf.termin.entity.internal;

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

import de.impf.termin.entity.TerminTO;

@Entity
@Access(AccessType.FIELD)
@Table(name="HA2_Termine")
@NamedQuery(name="Termin.findByID", query="select t from Termin t where t.terminID = :id")
@NamedQuery(name="Termin.findByPatientID", query="select t from Termin t where t.patientID = :patientid")
@NamedQuery(name="Termin.getOpenTermine", query="select t from Termin t where t.wahrgenommen = :wahrgenommen")
public class Termin {
	
	public static final String FIND_BY_ID = "Termin.findByID";
	public static final String FIND_BY_PATIENTID = "Termin.findByPatientID";
	public static final String GET_OPEN_TERMINE = "Termin.getOpenTermine";
	
	//Variablen
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IMPF_TERMIN_ID")
	@SequenceGenerator(name="IMPF_TERMIN_ID", sequenceName="IMPF_SEQ_TERMIN_ID", allocationSize=1)
	private int terminID;
	
	private LocalDate datum;
	private String uhrzeit;
	private int patientID;
	private boolean wahrgenommen;
	
	//Konstruktoren
	public Termin() {
	}
	
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
		
		//Set Pattern for convertion of LocalDate to String
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
				
		TerminTO aTerminTO = new TerminTO();
		aTerminTO.setTerminID(this.getTerminID());
		aTerminTO.setDatum(this.getDatum().format(formatter));
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
