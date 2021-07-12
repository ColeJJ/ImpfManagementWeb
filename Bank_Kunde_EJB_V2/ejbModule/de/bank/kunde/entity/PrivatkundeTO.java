package de.bank.kunde.entity;

import java.io.Serializable;
import java.util.Collection;

import de.bank.kunde.entity.impl.Kunde;
import de.bank.kunde.entity.impl.Privatkunde;

public class PrivatkundeTO extends KundeTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String geschlecht;
	
	public PrivatkundeTO() {
		super();
	}
	
	public PrivatkundeTO(int kundennummer, String nachname, String vorname, String str, 
			String nr, String plz, String ort, Collection<Integer> konten, String geschlecht) {
		super(kundennummer, nachname, vorname, str, nr, plz, ort, konten);
		this.geschlecht = geschlecht;
	}
	
	public String getGeschlecht() {
		return this.geschlecht;
	}
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	public Kunde toKunde() {
		Kunde kunde = new Privatkunde(
//				this.getKundennummer(),
				this.getVorname(),
				this.getNachname(),
				this.getStr(),
				this.getNr(),
				this.getPlz(),
				this.getOrt(),
				this.getGeschlecht());
		for (Integer kontonr:this.getKonten())
			kunde.getKonten().add(kontonr);
		
		return kunde;
	}

}
