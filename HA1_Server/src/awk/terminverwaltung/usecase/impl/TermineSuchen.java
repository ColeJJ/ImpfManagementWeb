package awk.terminverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.terminverwaltung.entity.TerminTO;
import awk.terminverwaltung.entity.impl.Termin;
import awk.terminverwaltung.usecase.ITermineSuchen;

public class TermineSuchen implements ITermineSuchen{

	@Override
	public Collection<TerminTO> getAllTermine() throws AnwendungskernException {
		Collection<TerminTO> terminTOListe = new ArrayList<TerminTO>();
		TerminManager einTerminManager = TerminManager.getTerminManager();
		for(Termin aTermin:einTerminManager.getTermine()) {
			terminTOListe.add(aTermin.toTerminTO());
		}
		return terminTOListe;
	}

	@Override
	public Collection<TerminTO> getAllOpenTermine() throws AnwendungskernException {
		Collection<TerminTO> terminTOListe = new ArrayList<TerminTO>();
		TerminManager einTerminManager = TerminManager.getTerminManager();
		for(Termin aTermin:einTerminManager.getTermine()) {
			if(!aTermin.isWahrgenommen()) terminTOListe.add(aTermin.toTerminTO());
		}
		return terminTOListe;
	}

}
