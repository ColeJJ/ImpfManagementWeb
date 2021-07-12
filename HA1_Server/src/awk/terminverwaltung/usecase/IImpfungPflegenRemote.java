package awk.terminverwaltung.usecase;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import awk.AnwendungskernException;

public interface IImpfungPflegenRemote extends Remote{

	public boolean impfungAnlegenR(LocalDate datum, String uhrzeit, String bemerkung, int terminID, int chargeID) throws AnwendungskernException, RemoteException;
}
