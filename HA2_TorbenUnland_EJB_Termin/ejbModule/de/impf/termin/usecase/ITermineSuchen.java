package de.impf.termin.usecase;

import java.util.List;

import javax.ejb.Local;

import de.impf.termin.entity.TerminTO;

@Local
public interface ITermineSuchen {
	
	public List<TerminTO> getAllOpenTermine();
}
