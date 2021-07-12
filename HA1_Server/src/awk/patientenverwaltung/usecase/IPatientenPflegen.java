package awk.patientenverwaltung.usecase;

import java.time.LocalDate;

import awk.AnwendungskernException;

public interface IPatientenPflegen {
	
	public boolean patientAnlegen(String name, String vorname, LocalDate Geburtsdatum, String Mail, String TelefonNr) throws AnwendungskernException;
}
