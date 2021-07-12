package awk.terminverwaltung.persistence;

import java.util.Collection;

import awk.DatenhaltungsException;
import awk.terminverwaltung.entity.ImpfungTO;

public interface IImpfungDatenzugriff {

	public void impfdatenSpeichern(ImpfungTO impfungTO) throws DatenhaltungsException;
	
	public Collection<ImpfungTO> impfdatenLesen() throws DatenhaltungsException;
}
