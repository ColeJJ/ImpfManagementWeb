package awk.terminverwaltung.persistence;

import java.util.Collection;

import awk.DatenhaltungsException;
import awk.terminverwaltung.entity.TerminTO;

public interface ITerminDatenzugriff {
	
	public void termindatenSpeichern(TerminTO terminTO) throws DatenhaltungsException;
	
	public Collection<TerminTO> termindatenLesen() throws DatenhaltungsException;

}
