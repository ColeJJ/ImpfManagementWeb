package awk.patientenverwaltung.usecase.impl;

import java.rmi.RemoteException;
import java.time.LocalDate;

import awk.AnwendungskernException;
import awk.patientenverwaltung.usecase.IPatientenPflegenRemote;

public class PatientenPflegenRemote implements IPatientenPflegenRemote{

	@Override
	public boolean patientAnlegenR(String name, String vorname, LocalDate Geburtsdatum, String Mail, String TelefonNr)
			throws AnwendungskernException, RemoteException {
		PatientenPflegen patientenPflegen = new PatientenPflegen();
		return patientenPflegen.patientAnlegen(name, vorname, Geburtsdatum, Mail, TelefonNr);
	}

}
