package awk.vakzineverwaltung.factory.impl;

import java.rmi.RemoteException;

import awk.vakzineverwaltung.factory.IVakzineverwaltungRemoteFactory;
import awk.vakzineverwaltung.usecase.IAnzeigeImpfdosenMengeRemote;
import awk.vakzineverwaltung.usecase.IChargeErfassenRemote;
import awk.vakzineverwaltung.usecase.IChargeSuchenRemote;
import awk.vakzineverwaltung.usecase.impl.AnzeigeImpfdosenMengeRemote;
import awk.vakzineverwaltung.usecase.impl.ChargeErfassenRemote;
import awk.vakzineverwaltung.usecase.impl.ChargeSuchenRemote;

public class VakzineverwaltungRemoteFactory implements IVakzineverwaltungRemoteFactory{

	@Override
	public IChargeErfassenRemote getChargeErfassenRemote() throws RemoteException {
		return new ChargeErfassenRemote();
	}

	@Override
	public IAnzeigeImpfdosenMengeRemote getAnzeigeImpfdosenMengeRemote() throws RemoteException {
		return new AnzeigeImpfdosenMengeRemote();
	}

	@Override
	public IChargeSuchenRemote getChargeSuchenRemote() throws RemoteException {
		return new ChargeSuchenRemote();
	}

}
