package awk.terminverwaltung.usecase.impl;

import java.rmi.RemoteException;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.terminverwaltung.entity.TerminTO;
import awk.terminverwaltung.usecase.ITermineSuchen;
import awk.terminverwaltung.usecase.ITermineSuchenRemote;

public class TermineSuchenRemote implements ITermineSuchenRemote{

	@Override
	public Collection<TerminTO> getAllTermineR() throws AnwendungskernException, RemoteException {
		ITermineSuchen termineSuchen = new TermineSuchen();
        return termineSuchen.getAllTermine();
	}

	@Override
	public Collection<TerminTO> getAllOpenTermineR() throws AnwendungskernException, RemoteException {
		ITermineSuchen termineSuchen = new TermineSuchen();
        return termineSuchen.getAllOpenTermine();
	}

}
