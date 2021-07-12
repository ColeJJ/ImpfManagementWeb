package de.impf.impfstoffcharge.entity.internal;

import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import de.impf.impfstoffcharge.entity.ImpfstoffchargeTO;

@Entity
@Access(AccessType.FIELD)
@Table(name="HA2_Impfstoffcharge")
@NamedQuery(name="Impfstoffcharge.findByID", query="select i from Impfstoffcharge i where i.id = :id")
@NamedQuery(name="Impfstoffcharge.getSummedChargenByHersteller", query="select i.hersteller, sum(i.anzahl) as MENGE from Impfstoffcharge i group by i.hersteller")
@NamedQuery(name="Impfstoffcharge.findByHersteller", query="select i from Impfstoffcharge i where i.hersteller = :hersteller")
public class Impfstoffcharge {
	
	public static final String GET_SUMMEDCHARGEN_BY_HERSTELLER = "Impfstoffcharge.getSummedChargenByHersteller";
	public static final String FIND_BY_ID = "Impfstoffcharge.findByID";
	public static final String FIND_BY_HERSTELLER = "Impfstoffcharge.findByHersteller";
	
	//Variablen
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IMPF_IMPFSTOFFCHARGE_ID")
	@SequenceGenerator(name="IMPF_IMPFSTOFFCHARGE_ID", sequenceName="IMPF_SEQ_IMPFSTOFFCHARGE_ID", allocationSize = 1)
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
