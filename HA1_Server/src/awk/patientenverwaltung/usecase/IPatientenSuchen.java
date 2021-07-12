package awk.patientenverwaltung.usecase;

import java.util.Collection;

import awk.AnwendungskernException;
import awk.patientenverwaltung.entity.PatientTO;

public interface IPatientenSuchen {

	public Collection<PatientTO> getAllPatienten() throws AnwendungskernException;
}
