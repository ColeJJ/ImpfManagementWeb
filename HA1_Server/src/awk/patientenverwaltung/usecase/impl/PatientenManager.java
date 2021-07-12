package awk.patientenverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.patientenverwaltung.entity.PatientTO;
import awk.patientenverwaltung.entity.internal.Patient;
import awk.patientenverwaltung.persistence.IPatientenDatenzugriff;
import awk.patientenverwaltung.persistence.impl.PatientenDatenzugriff_DAO_DB;


public class PatientenManager {
	
	private IPatientenDatenzugriff einDatenverwalter= new PatientenDatenzugriff_DAO_DB();
	private Collection<Patient> patiente;
	private static PatientenManager patientenManager;
	
	public static PatientenManager getPatientenManager() throws AnwendungskernException {
		//AF5 - neue Initialisierung, damit beim Aufruf die Patiente geupdatet werden, wenn neue erstellt wurden
        patientenManager = new PatientenManager();
		return patientenManager;
	}
	
	private PatientenManager() throws AnwendungskernException{
		this.patiente = new ArrayList<Patient>();
		this.patientenLaden();
	}
	
	public boolean patientHinzufuegen(Patient aPatient) throws AnwendungskernException{
		try {
			einDatenverwalter.patientendatenSpeichern(aPatient.toPatientTO());
			return true;
		} catch (DatenhaltungsException e) {
			e.printStackTrace();
			throw new AnwendungskernException();
		}
	}
	
	private void patientenLaden() throws AnwendungskernException {
		Collection<PatientTO> patientenTOListe;
		
		try {
			patientenTOListe = einDatenverwalter.patientendatenLesen();
		}catch(DatenhaltungsException e) {
			throw new AnwendungskernException();
		}
		
		this.patiente.clear();
		for(PatientTO aPatientTO:patientenTOListe) {
			this.patiente.add(aPatientTO.toPatient());
		}
		
	}

	public void setPatiente(Collection<Patient> patiente) {
		this.patiente = patiente;
	}
	
	public Collection<Patient> getPatiente() {
		return patiente;
	}
}
