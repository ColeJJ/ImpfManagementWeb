package awk.patientenverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.patientenverwaltung.entity.PatientTO;
import awk.patientenverwaltung.entity.internal.Patient;
import awk.patientenverwaltung.usecase.IPatientenSuchen;

public class PatientenSuchen implements IPatientenSuchen{

	@Override
	public Collection<PatientTO> getAllPatienten() throws AnwendungskernException {
		Collection<PatientTO> patientenTOListe = new ArrayList<PatientTO>();
		PatientenManager einPatientenManager = PatientenManager.getPatientenManager();
		for(Patient aPatient:einPatientenManager.getPatiente()) {
			patientenTOListe.add(aPatient.toPatientTO());
		}
		return patientenTOListe;
	}

}
