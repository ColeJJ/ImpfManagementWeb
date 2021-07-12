package de.bank.kunde.shared;


import javax.persistence.Basic;
import javax.persistence.Embeddable;


@Embeddable
public class Adresse {

	@Basic(optional=false)	private String strasse;
	@Basic(optional=false)	private String hnr;
	@Basic(optional=false)	private String plz;
	@Basic(optional=false)	private String ort;

	public Adresse() {}
			
	public Adresse(String strasse, String hnr, String plz, String ort) {
		super();
		this.strasse = strasse;
		this.hnr = hnr;
		this.plz = plz;
		this.ort = ort;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHnr() {
		return hnr;
	}

	public void setHnr(String hnr) {
		this.hnr = hnr;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	
}
