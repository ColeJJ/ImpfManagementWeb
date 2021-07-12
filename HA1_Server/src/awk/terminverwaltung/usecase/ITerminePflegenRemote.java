package awk.terminverwaltung.usecase;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import awk.AnwendungskernException;

public interface ITerminePflegenRemote extends Remote{
	
	
	public boolean terminAnlegenR(int terminID, LocalDate datum, String uhrzeit, int patientID) throws AnwendungskernException, RemoteException;
}
