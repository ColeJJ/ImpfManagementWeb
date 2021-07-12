package de.impf.termin.usecase;

import java.util.Collection;

import javax.ejb.Local;

import de.impf.termin.entity.TerminTO;

@Local
public interface ITermineSuchen {
	
	public Collection<TerminTO> getAllOpenTermine();
}
