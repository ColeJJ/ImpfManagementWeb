package awk.patientenverwaltung.usecase.impl;

import java.rmi.RemoteException;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.patientenverwaltung.entity.PatientTO;
import awk.patientenverwaltung.usecase.IPatientenSuchen;
import awk.patientenverwaltung.usecase.IPatientenSuchenRemote;

public class PatientenSuchenRemote implements IPatientenSuchenRemote{

	@Override
	public Collection<PatientTO> getAllPatientenR() throws AnwendungskernException, RemoteException {
		IPatientenSuchen patientenSuchen = new PatientenSuchen();
		return patientenSuchen.getAllPatienten();
	}

}
