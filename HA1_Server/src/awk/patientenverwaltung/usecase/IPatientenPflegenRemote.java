package awk.patientenverwaltung.usecase;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import awk.AnwendungskernException;

public interface IPatientenPflegenRemote extends Remote{

	public boolean patientAnlegenR(String name, String vorname, LocalDate Geburtsdatum, String Mail, String TelefonNr) throws AnwendungskernException, RemoteException;
}
