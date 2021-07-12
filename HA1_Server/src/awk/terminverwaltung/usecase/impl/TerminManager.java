package awk.terminverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.terminverwaltung.entity.TerminTO;
import awk.terminverwaltung.entity.impl.Termin;
import awk.terminverwaltung.persistence.ITerminDatenzugriff;
import awk.terminverwaltung.persistence.impl.TerminDatenzugriff_DAO_DB;

public class TerminManager {


	private ITerminDatenzugriff einDatenverwalter = new TerminDatenzugriff_DAO_DB();
	private Collection<Termin> termine;
	private static TerminManager terminManager;
	
	public static TerminManager getTerminManager() throws AnwendungskernException{
		//AF5 - neue Initialisierung, damit beim Aufruf die termine geupdatet werde
		terminManager = new TerminManager();
		return terminManager;
	}
	
	public TerminManager() throws AnwendungskernException {
		this.termine = new ArrayList<Termin>();
		this.termineLaden();
	}
	
	private boolean termineLaden() throws AnwendungskernException{
		Collection<TerminTO> terminTOListe = new ArrayList<TerminTO>();
		
		try {
			terminTOListe = einDatenverwalter.termindatenLesen();
		} catch (DatenhaltungsException e) {
			throw new AnwendungskernException();
		}
		
		this.termine.clear();
		for(TerminTO aTerminTO:terminTOListe) {
			termine.add(aTerminTO.toTermin());
		}
		
		return true;
	}
	
	public boolean terminHinzufuegen(Termin aTermin) throws AnwendungskernException{
		try {
			einDatenverwalter.termindatenSpeichern(aTermin.toTerminTO());
			return true;
		} catch (DatenhaltungsException e) {
			e.printStackTrace();
			throw new AnwendungskernException();
		}
	}

	
	public Collection<Termin> getTermine() {
		return termine;
	}

	public void setTermine(Collection<Termin> termine) {
		this.termine = termine;
	}
}