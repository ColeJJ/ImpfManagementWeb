package de.bank.kunde.entity.impl;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import de.bank.kunde.entity.GeschaeftskundeTO;

@Entity
@Access(AccessType.FIELD)
public class Geschaeftskunde extends Kunde implements Serializable {


	private static final long serialVersionUID = 1L;

	private String vat;
	
	public Geschaeftskunde() {
		super();
	}
	
	
	public Geschaeftskunde(String nachname, String vorname, String str, String nr,
			String plz, String ort, String ustId) {
		super( nachname, vorname, str, nr, plz, ort);
		this.vat = ustId;
	}
	public Geschaeftskunde (GeschaeftskundeTO einGKundeTO) {
		super (einGKundeTO);
		this.vat = einGKundeTO.getUstId();
	}
	public String getVat() {
		return vat;
	}
	public void setVat(String vat) {
		this.vat = vat;
	}

	@Override
	public GeschaeftskundeTO toKundeTO() {
		GeschaeftskundeTO einGeschaeftskundenTO = new GeschaeftskundeTO();
		einGeschaeftskundenTO.setKundennummer(this.getKundenNr());
		einGeschaeftskundenTO.setNachname(this.getNachname());
		einGeschaeftskundenTO.setVorname(this.getVorname());
		einGeschaeftskundenTO.setStr(this.getAdresse().getStrasse());
		einGeschaeftskundenTO.setNr(this.getAdresse().getHnr());
		einGeschaeftskundenTO.setPlz(this.getAdresse().getPlz());
		einGeschaeftskundenTO.setOrt(this.getAdresse().getOrt());
		einGeschaeftskundenTO.setUstId(this.vat);
		for (Integer kontonummer:this.getKonten())
			einGeschaeftskundenTO.addKonto(kontonummer);
		return einGeschaeftskundenTO;
	}
}
