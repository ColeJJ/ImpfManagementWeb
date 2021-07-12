package awk.vakzineverwaltung.entity.internal;

import java.time.LocalDate;

import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;

public class Impfstoffcharge {
	
	//Eigenschaften
	private int chargeID;
	private int anzahl;
	private String hersteller;
	private LocalDate datumAnlieferung;
	
	public Impfstoffcharge(int chargeID, int anzahl, String hersteller, LocalDate datumAnlieferung) {
		this.chargeID = chargeID;
		this.anzahl = anzahl;
		this.hersteller = hersteller;
		this.datumAnlieferung = datumAnlieferung;
	}
	
	public Impfstoffcharge(int anzahl, String hersteller, LocalDate datumAnlieferung) {
		this.anzahl = anzahl;
		this.hersteller = hersteller;
		this.datumAnlieferung = datumAnlieferung;
	}
	
	public Impfstoffcharge(int anzahl, String hersteller) {
		this.anzahl = anzahl;
		this.hersteller = hersteller;
	}
	
	public Impfstoffcharge(ImpfstoffchargeTO impfstoffchargeTO) {
		this.chargeID = impfstoffchargeTO.getChargeID();
		this.anzahl = impfstoffchargeTO.getAnzahl();
		this.hersteller = impfstoffchargeTO.getHersteller();
		this.datumAnlieferung = impfstoffchargeTO.getDatumAnlieferung();
	}
	
	public ImpfstoffchargeTO toImpfstoffchargeTO() {
		ImpfstoffchargeTO aImpfstoffchargeTO = new ImpfstoffchargeTO();
		aImpfstoffchargeTO.setChargeID(this.getChargeID());
		aImpfstoffchargeTO.setAnzahl(this.getAnzahl());
		aImpfstoffchargeTO.setHersteller(this.getHersteller());
		aImpfstoffchargeTO.setDatumAnlieferung(this.getDatumAnlieferung());
		return aImpfstoffchargeTO;
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
