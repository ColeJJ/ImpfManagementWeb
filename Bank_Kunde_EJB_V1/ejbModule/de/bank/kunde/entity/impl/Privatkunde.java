package de.bank.kunde.entity.impl;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import de.bank.kunde.entity.PrivatkundeTO;

@Entity
@Access(AccessType.FIELD)
public class Privatkunde extends Kunde implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String geschlecht;
	
	public Privatkunde() {
		super();
	}
	
	public Privatkunde(String nachname, String vorname, String str, String nr,
			String plz, String ort, String geschlecht) {
		super(nachname, vorname, str, nr, plz, ort);
		this.geschlecht = geschlecht;
	}
	

	public String getGeschlecht() {
		return geschlecht;
	}


	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	@Override
	public PrivatkundeTO toKundeTO() {
		
		PrivatkundeTO privatKundenTO = new PrivatkundeTO();
		privatKundenTO.setKundennummer(this.getKundenNr());
		privatKundenTO.setNachname(this.getNachname());
		privatKundenTO.setVorname(this.getVorname());
		privatKundenTO.setStr(this.getAdresse().getStrasse());
		privatKundenTO.setNr(this.getAdresse().getHnr());
		privatKundenTO.setPlz(this.getAdresse().getPlz());
		privatKundenTO.setOrt(this.getAdresse().getOrt());
		for (Integer kontonummer:this.getKonten()) {
			privatKundenTO.addKonto(kontonummer);
			
		}
		privatKundenTO.setGeschlecht(this.geschlecht);
		
		return privatKundenTO;
		
	}
	
}
