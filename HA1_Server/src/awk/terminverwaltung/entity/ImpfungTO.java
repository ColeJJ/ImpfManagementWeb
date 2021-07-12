package awk.terminverwaltung.entity;

import java.time.LocalDate;

import awk.terminverwaltung.entity.impl.Impfung;

public class ImpfungTO {
	
	//Eigenschaften
	private int impfungID;
	private LocalDate datum;
	private String uhrzeit;
	private String bemerkung;
	private int terminID;
	private int chargeID;
	
	public Impfung toImpfung() {
		Impfung aImpfung = new Impfung(
				this.impfungID,
				this.datum,
				this.uhrzeit,
				this.bemerkung,
				this.terminID,
				this.chargeID);
		return aImpfung;
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
