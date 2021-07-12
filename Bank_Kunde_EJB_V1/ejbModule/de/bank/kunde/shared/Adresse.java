package de.bank.kunde.shared;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Access(AccessType.FIELD)
@Table(name="Bank_Adresse")
public class Adresse {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BANK_ADRESSE_ID")
	@SequenceGenerator(name="BANK_ADRESSE_ID", sequenceName="BANK_SEQ_ADRESSE_ID", allocationSize = 1)
	private int id;
	private String strasse;
	private String hnr;
	private String plz;
	private String ort;

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
