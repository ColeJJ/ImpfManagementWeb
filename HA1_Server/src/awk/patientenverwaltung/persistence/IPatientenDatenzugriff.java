package awk.patientenverwaltung.persistence;

import java.util.Collection;

import awk.DatenhaltungsException;
import awk.patientenverwaltung.entity.PatientTO;

public interface IPatientenDatenzugriff {
	
	public void patientendatenSpeichern(PatientTO patientTO) throws DatenhaltungsException;
	
	public Collection<PatientTO> patientendatenLesen() throws DatenhaltungsException;

}
