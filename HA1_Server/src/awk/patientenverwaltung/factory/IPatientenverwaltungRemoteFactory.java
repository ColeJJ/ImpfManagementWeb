package awk.patientenverwaltung.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import awk.patientenverwaltung.usecase.IPatientenPflegenRemote;
import awk.patientenverwaltung.usecase.IPatientenSuchenRemote;

public interface IPatientenverwaltungRemoteFactory extends Remote{

	IPatientenPflegenRemote getPatientenPflegenRemote() throws RemoteException;
	IPatientenSuchenRemote getPatientenSuchenRemote() throws RemoteException;

}
