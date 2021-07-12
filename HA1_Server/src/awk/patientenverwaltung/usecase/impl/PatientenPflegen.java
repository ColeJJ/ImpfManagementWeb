package awk.patientenverwaltung.usecase.impl;

import java.time.LocalDate;

import awk.AnwendungskernException;
import awk.patientenverwaltung.entity.internal.Patient;
import awk.patientenverwaltung.usecase.IPatientenPflegen;

public class PatientenPflegen implements IPatientenPflegen{
	
	public PatientenPflegen() {
	}
	
	public boolean patientAnlegen(String name, String vorname, LocalDate Geburtsdatum, String Mail, String TelefonNr) throws AnwendungskernException {
		PatientenManager einPatientenManager =  PatientenManager.getPatientenManager();
		System.out.println("name:"+name+" "+vorname+" "+Geburtsdatum+" "+Mail+" "+TelefonNr);
		return einPatientenManager.patientHinzufuegen(new Patient(name,vorname,Geburtsdatum,Mail,TelefonNr));
	}

}
