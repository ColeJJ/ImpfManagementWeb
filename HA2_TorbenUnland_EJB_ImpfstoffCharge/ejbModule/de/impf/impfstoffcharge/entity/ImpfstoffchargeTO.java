package de.impf.impfstoffcharge.entity;

import java.io.Serializable;
import java.time.LocalDate;

import de.impf.impfstoffcharge.entity.internal.Impfstoffcharge;


public class ImpfstoffchargeTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3976249587553018680L;
	
	
	//Eigenschaften
	private int chargeID;
	private int anzahl;
	private String hersteller;
	private LocalDate datumAnlieferung;
		
	public ImpfstoffchargeTO() {
	}
	
	public Impfstoffcharge toImpfstoffcharge() {
		Impfstoffcharge aImpfstoffcharge = new Impfstoffcharge(
				this.getChargeID(),
				this.getAnzahl(),
				this.getHersteller(),
				this.getDatumAnlieferung());
		return aImpfstoffcharge;
	}

	public int getChargeID() {
		return chargeID;
	}

	public void setChargeID(int chargeID) {
		this.chargeID = chargeID;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public String getHersteller() {
		return hersteller;
	}

	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}

	public LocalDate getDatumAnlieferung() {
		return datumAnlieferung;
	}

	public void setDatumAnlieferung(LocalDate datumAnlieferung) {
		this.datumAnlieferung = datumAnlieferung;
	}
	
	

}