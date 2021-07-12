package awk.vakzineverwaltung.usecase;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import awk.AnwendungskernException;

public interface IChargeErfassenRemote extends Remote{
	
	public boolean chargeErfassenR(int anzahl, String hersteller, LocalDate datumAnlieferung) throws AnwendungskernException, RemoteException;
	
	public boolean reduceChargeR(int chargeID) throws AnwendungskernException, RemoteException;
}
