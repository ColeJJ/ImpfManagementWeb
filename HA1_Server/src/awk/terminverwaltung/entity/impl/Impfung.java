package awk.terminverwaltung.entity.impl;

import java.time.LocalDate;

import awk.terminverwaltung.entity.ImpfungTO;

public class Impfung {

	//Eigenschaften
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
