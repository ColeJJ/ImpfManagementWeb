package de.impf.termin.entity.internal;

import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import de.impf.termin.entity.ImpfungTO;


@Entity
@Access(AccessType.FIELD)
@Table(name="HA2_Impfungen")
public class Impfung {

	//Variablen
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IMPF_IMPFUNG_ID")
	@SequenceGenerator(name="IMPF_IMPFUNG_ID", sequenceName="IMPF_SEQ_IMPFUNG_ID", allocationSize=1)
	private int impfungID;
	
	private LocalDate datum;
	private String uhrzeit;
	private String bemerkung;
	private int terminID;
	private int chargeID;
	
	public Impfung(int impfungID, LocalDate datum, String uhrzeit, String bemerkung, int terminID, int chargeID) {
		this.impfungID = impfungID;
		this.datum = datum;
		this.uhrzeit = uhrzeit;
		this.bemerkung = bemerkung;
		this.terminID = terminID;
		this.chargeID = chargeID;
	}
	
	public Impfung(LocalDate datum, String uhrzeit, String bemerkung, int terminID, int chargeID) {
		this.datum = datum;
		this.uhrzeit = uhrzeit;
		this.bemerkung = bemerkung;
		this.terminID = terminID;
		this.chargeID = chargeID;
	}
	
	public ImpfungTO toImpfungTO() {
		ImpfungTO aImpfungTO = new ImpfungTO();
		aImpfungTO.setImpfungID(this.impfungID);
		aImpfungTO.setDatum(this.datum);
		aImpfungTO.setUhrzeit(this.uhrzeit);
		aImpfungTO.setBemerkung(this.bemerkung);
		aImpfungTO.setTerminID(this.terminID);
		aImpfungTO.setChargeID(this.chargeID);
		return aImpfungTO;
	}
	
	
	public int getImpfungID() {
		return impfungID;
	}
	public void setImpfungID(int impfungID) {
		this.impfungID = impfungID;
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
	public String getBemerkung() {
		return bemerkung;
	}
	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}
	public int getTerminID() {
		return terminID;
	}
	public void setTerminID(int terminID) {
		this.terminID = terminID;
	}
	public int getChargeID() {
		return chargeID;
	}
	public void setChargeID(int chargeID) {
		this.chargeID = chargeID;
	}
	
	
}