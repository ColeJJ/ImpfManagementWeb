package awk.patientenverwaltung.usecase;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.patientenverwaltung.entity.PatientTO;

public interface IPatientenSuchenRemote extends Remote{
	
	public Collection<PatientTO> getAllPatientenR() throws AnwendungskernException, RemoteException;
}
