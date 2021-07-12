package awk.patientenverwaltung.factory.impl;

import awk.patientenverwaltung.factory.IPatientenverwaltungFactory;
import awk.patientenverwaltung.usecase.IPatientenPflegen;
import awk.patientenverwaltung.usecase.IPatientenSuchen;
import awk.patientenverwaltung.usecase.impl.PatientenPflegen;
import awk.patientenverwaltung.usecase.impl.PatientenSuchen;

public class PatientenverwaltungFactory implements IPatientenverwaltungFactory{

	@Override
	public IPatientenPflegen getPatientenPflegen() {
		return new PatientenPflegen();
	}

	@Override
	public IPatientenSuchen getPatientenSuchen() {	
		return new PatientenSuchen();
	}

}
