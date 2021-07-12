package awk.terminverwaltung.usecase;

import java.util.Collection;

import awk.AnwendungskernException;
import awk.terminverwaltung.entity.TerminTO;

public interface ITermineSuchen {

	public Collection<TerminTO> getAllTermine() throws AnwendungskernException;
	
	public Collection<TerminTO> getAllOpenTermine() throws AnwendungskernException;
}
