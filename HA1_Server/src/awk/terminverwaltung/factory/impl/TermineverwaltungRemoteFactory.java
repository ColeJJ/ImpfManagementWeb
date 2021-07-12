package awk.terminverwaltung.factory.impl;

import java.rmi.RemoteException;

import awk.terminverwaltung.factory.ITermineverwaltungRemoteFactory;
import awk.terminverwaltung.usecase.IImpfungPflegenRemote;
import awk.terminverwaltung.usecase.ITerminePflegenRemote;
import awk.terminverwaltung.usecase.ITermineSuchenRemote;
import awk.terminverwaltung.usecase.impl.ImpfungPflegenRemote;
import awk.terminverwaltung.usecase.impl.TerminePflegenRemote;
import awk.terminverwaltung.usecase.impl.TermineSuchenRemote;

public class TermineverwaltungRemoteFactory implements ITermineverwaltungRemoteFactory{

	@Override
	public ITerminePflegenRemote getTerminePflegenRemote() throws RemoteException {
		return new TerminePflegenRemote();
	}

	@Override
	public ITermineSuchenRemote getTermineSuchenRemote() throws RemoteException {
		return new TermineSuchenRemote();
	}

	@Override
	public IImpfungPflegenRemote getImpfungPflegenRemote() throws RemoteException {
		return new ImpfungPflegenRemote();
	}

}
