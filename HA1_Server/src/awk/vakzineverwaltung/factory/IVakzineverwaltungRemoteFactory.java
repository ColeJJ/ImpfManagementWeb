package awk.vakzineverwaltung.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import awk.vakzineverwaltung.usecase.IAnzeigeImpfdosenMengeRemote;
import awk.vakzineverwaltung.usecase.IChargeErfassenRemote;
import awk.vakzineverwaltung.usecase.IChargeSuchenRemote;

public interface IVakzineverwaltungRemoteFactory extends Remote{

	public IChargeErfassenRemote getChargeErfassenRemote() throws RemoteException;
	public IChargeSuchenRemote getChargeSuchenRemote() throws RemoteException;
	public IAnzeigeImpfdosenMengeRemote getAnzeigeImpfdosenMengeRemote() throws RemoteException;
}
