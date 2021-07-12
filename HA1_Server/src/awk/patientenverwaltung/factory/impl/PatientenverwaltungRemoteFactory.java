package awk.patientenverwaltung.factory.impl;


import java.rmi.RemoteException;

import awk.patientenverwaltung.factory.IPatientenverwaltungRemoteFactory;
import awk.patientenverwaltung.usecase.IPatientenPflegenRemote;
import awk.patientenverwaltung.usecase.IPatientenSuchenRemote;
import awk.patientenverwaltung.usecase.impl.PatientenPflegenRemote;
import awk.patientenverwaltung.usecase.impl.PatientenSuchenRemote;

public class PatientenverwaltungRemoteFactory implements IPatientenverwaltungRemoteFactory{

	public IPatientenPflegenRemote getPatientenPflegenRemote() {
		return new PatientenPflegenRemote();
	}

	@Override
	public IPatientenSuchenRemote getPatientenSuchenRemote() throws RemoteException {
		return new PatientenSuchenRemote();
	}
}
