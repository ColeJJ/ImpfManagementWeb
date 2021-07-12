package de.bank.kunde.entity;

import java.io.Serializable;
import java.util.Collection;

import de.bank.kunde.entity.impl.Geschaeftskunde;
import de.bank.kunde.entity.impl.Kunde;

public class GeschaeftskundeTO extends KundeTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String ustId;
	
	public GeschaeftskundeTO (){
		super();
	}
	
	public GeschaeftskundeTO(int kundennummer, String nachname, String vorname, String str, 
			String nr, String plz, String ort, Collection<Integer> konten, String vat) {
		super(kundennummer, nachname, vorname, str, nr, plz, ort, konten);
		this.ustId = vat;
	}
	
	public String getUstId() {
		return ustId;
	}
	public void setUstId(String ustId) {
		this.ustId = ustId;
	}
	
	public Kunde toKunde() {
		Kunde kunde = new Geschaeftskunde(
//				this.getKundennummer(),
				this.getVorname(),
				this.getNachname(),
				this.getStr(),
				this.getNr(),
				this.getPlz(),
				this.getOrt(),
				this.getUstId());
		for (Integer kontonr:this.getKonten())
			kunde.getKonten().add(kontonr);
		
		return kunde;
	}
}
