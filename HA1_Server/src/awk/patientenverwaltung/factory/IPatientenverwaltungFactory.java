package awk.patientenverwaltung.factory;

import awk.patientenverwaltung.usecase.IPatientenPflegen;
import awk.patientenverwaltung.usecase.IPatientenSuchen;

public interface IPatientenverwaltungFactory {
	
	IPatientenPflegen getPatientenPflegen();
	IPatientenSuchen getPatientenSuchen();

}
