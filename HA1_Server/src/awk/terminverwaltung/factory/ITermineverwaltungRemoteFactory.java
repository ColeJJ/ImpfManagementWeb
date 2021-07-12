package awk.terminverwaltung.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import awk.terminverwaltung.usecase.IImpfungPflegenRemote;
import awk.terminverwaltung.usecase.ITerminePflegenRemote;
import awk.terminverwaltung.usecase.ITermineSuchenRemote;

public interface ITermineverwaltungRemoteFactory extends Remote{

	ITerminePflegenRemote getTerminePflegenRemote() throws RemoteException;
	ITermineSuchenRemote getTermineSuchenRemote() throws RemoteException;
	IImpfungPflegenRemote getImpfungPflegenRemote() throws RemoteException;
}
