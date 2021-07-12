package awk.terminverwaltung.usecase;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.terminverwaltung.entity.TerminTO;

public interface ITermineSuchenRemote extends Remote{

	public Collection<TerminTO> getAllTermineR() throws AnwendungskernException, RemoteException;
	
	public Collection<TerminTO> getAllOpenTermineR() throws AnwendungskernException, RemoteException;
}
