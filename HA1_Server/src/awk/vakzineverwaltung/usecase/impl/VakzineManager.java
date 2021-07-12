package awk.vakzineverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;
import awk.vakzineverwaltung.entity.internal.Impfstoffcharge;
import awk.vakzineverwaltung.persistence.IVakzineDatenzugriff;
import awk.vakzineverwaltung.persistence.impl.VakzineDatenzugriff_DAO_DB;

public class VakzineManager {
	
	private IVakzineDatenzugriff einDatenverwalter = new VakzineDatenzugriff_DAO_DB();
	private Collection<Impfstoffcharge> chargen;
	private static VakzineManager vakzineManager;
	
	public static VakzineManager getVakzineManager() throws AnwendungskernException {
		if (vakzineManager == null) {
			vakzineManager = new VakzineManager();
		}
		
		return vakzineManager;
	}
	
	public VakzineManager() throws AnwendungskernException {
		this.chargen = new ArrayList<Impfstoffcharge>();
		this.chargenLaden();
	}
	
	//ChargenLaden -> Laden über ChargenManager
	public void chargenLaden() throws AnwendungskernException {
		Collection<ImpfstoffchargeTO> chargenTOListe;
		
		try {
			chargenTOListe = einDatenverwalter.impfstoffchargeLesen();
		}catch(DatenhaltungsException e) {
			throw new AnwendungskernException();
		}
		
		this.chargen.clear();
		for(ImpfstoffchargeTO chargeTO:chargenTOListe) {
			this.chargen.add(chargeTO.toImpfstoffcharge());
		}
		
	}
	
	//ChargeHinzufügen -> Charge der Collection hinzufügren und an chargenspeichern übergeben
	public boolean chargeHinzufuegen(Impfstoffcharge aCharge) throws AnwendungskernException{
		try {
			einDatenverwalter.impstoffchargeSpeichern(aCharge.toImpfstoffchargeTO());
			return true;
		} catch (DatenhaltungsException e) {
			e.printStackTrace();
			throw new AnwendungskernException();
		}
	}
	
	
	public Collection<Impfstoffcharge> chargenNachHersteller() throws AnwendungskernException{
		Collection<Impfstoffcharge> chargenMengeListe = new ArrayList<Impfstoffcharge>();
		try {
			chargenMengeListe = einDatenverwalter.chargenNachHersteller();
		}catch(DatenhaltungsException e) {
			throw new AnwendungskernException();
		}
		
		return chargenMengeListe;
	}
	
	public Collection<Impfstoffcharge> getChargenByHersteller(String hersteller) throws AnwendungskernException{
		Collection<Impfstoffcharge> chargenMengeListe = new ArrayList<Impfstoffcharge>();
		try {
			chargenMengeListe = einDatenverwalter.getChargenByHersteller(hersteller);
		}catch(DatenhaltungsException e) {
			throw new AnwendungskernException();
		}
		
		return chargenMengeListe;
	}
	
	public boolean reduceCharge(int chargeID) throws AnwendungskernException{
		try {
			einDatenverwalter.reduceCharge(chargeID);
		} catch (DatenhaltungsException e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	
	public Collection<Impfstoffcharge> getChargen() {
		return chargen;
	}

	public void setChargen(Collection<Impfstoffcharge> chargen) {
		this.chargen = chargen;
	}
}
