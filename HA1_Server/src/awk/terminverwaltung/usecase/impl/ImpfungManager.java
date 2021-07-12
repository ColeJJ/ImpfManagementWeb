package awk.terminverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.terminverwaltung.entity.ImpfungTO;
import awk.terminverwaltung.entity.impl.Impfung;
import awk.terminverwaltung.persistence.IImpfungDatenzugriff;
import awk.terminverwaltung.persistence.impl.ImpfungDatenzugriff_DAO_DB;

public class ImpfungManager {

	private IImpfungDatenzugriff einDatenverwalter = new ImpfungDatenzugriff_DAO_DB();
	private Collection<Impfung> impfungen;
	private static ImpfungManager impfungManager;
	
	public static ImpfungManager getImpfungManager() throws AnwendungskernException {
		if(impfungManager == null) impfungManager = new ImpfungManager();
		return impfungManager;
	}
	
	public ImpfungManager() throws AnwendungskernException{
		this.impfungen = new ArrayList<Impfung>();
		this.impfungenLaden();
	}

	private boolean impfungenLaden() throws AnwendungskernException{
		Collection<ImpfungTO> impfungTOListe = new ArrayList<ImpfungTO>();
		
		try {
			impfungTOListe = einDatenverwalter.impfdatenLesen();
		} catch (DatenhaltungsException e) {
			e.printStackTrace();
			throw new AnwendungskernException();
		}
		
		this.impfungen.clear();
		for(ImpfungTO aImpfungTO:impfungTOListe) {
			this.impfungen.add(aImpfungTO.toImpfung());
		}
		return true;
	}
	
	public boolean ImpfungHinzufuegen(Impfung aImpfung) throws AnwendungskernException{
		try {
			einDatenverwalter.impfdatenSpeichern(aImpfung.toImpfungTO());
			return true;
		} catch (DatenhaltungsException e) {
			e.printStackTrace();
			throw new AnwendungskernException();
		}
	}
}
