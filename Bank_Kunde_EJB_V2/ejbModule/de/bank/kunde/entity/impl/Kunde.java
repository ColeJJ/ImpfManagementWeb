package de.bank.kunde.entity.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import de.bank.kunde.entity.KundeTO;
import de.bank.kunde.shared.Adresse;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)
@Table(name="T_Bank_Kunde")
@NamedQuery(name="Kunde.findKundeByLastAndFirstName", 
	query="SELECT k from Kunde k where k.vorname = :vorname or k.nachname = :nachname")
public abstract class Kunde implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_BY_FIRST_AND_LASTNAME = "Kunde.findKundeByLastAndFirstName";
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BANK_KUNDE_ID")
	@SequenceGenerator(name="BANK_KUNDE_ID", sequenceName="BANK_SEQ_KUNDE_ID", allocationSize = 1)
	private int kundenNr;
	
	private String vorname;
	private String nachname;

	@ElementCollection
	@CollectionTable(name="T_Bank_Kunde_Konten",
		joinColumns=@JoinColumn(name="KUNDE_NR"))
	private Collection<Integer> konten;
	
	@Embedded()
//	@Table(name="T_Adresse")
	private Adresse adresse;
	
	public Kunde() {
		this.setKonten(new ArrayList<Integer>());
	}
	
	
	public Kunde(String vorname, String nachname, String str, String hnr, String plz, String ort) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.adresse = new Adresse(str, hnr, plz, ort);
		this.setKonten(new ArrayList<Integer>());
	}	
	
	public Kunde (KundeTO einKundenTO) {
		this.kundenNr = einKundenTO.getKundennummer();
		this.nachname = einKundenTO.getNachname();
		this.vorname = einKundenTO.getVorname();
		this.adresse = new Adresse (
				einKundenTO.getStr(),einKundenTO.getNr(), einKundenTO.getPlz(), einKundenTO.getOrt());
		this.konten = new ArrayList<Integer>();
		for (Integer kontonr:einKundenTO.getKonten()) {
			this.konten.add(kontonr);
		}
		
	}
	
	public abstract KundeTO toKundeTO();
	
	
	public int getKundenNr() {
		return kundenNr;
	}

	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setAdresse(String str, String nr, String plz, String ort) {
		this.adresse.setStrasse(str);
		this.adresse.setHnr(nr);
		this.adresse.setPlz(plz);
		this.adresse.setOrt(ort);
	}
	
	public Collection<Integer> getKonten() {
		return konten;
	}

	public void setKonten(Collection<Integer> konten) {
		this.konten = konten;
	}

	public void addKonto(Integer ktoNr) {
		this.konten.add(ktoNr);
	}

	
	
}
