package awk.vakzineverwaltung.usecase.impl;

import java.rmi.RemoteException;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;
import awk.vakzineverwaltung.usecase.IAnzeigeImpfdosenMengeRemote;

public class AnzeigeImpfdosenMengeRemote implements IAnzeigeImpfdosenMengeRemote{

	@Override
	public Collection<ImpfstoffchargeTO> anzeigeImpfdosenNachHerstellerR() throws AnwendungskernException, RemoteException {
		AnzeigeImpfdosenMenge anzeigeImpfdosenMenge = new AnzeigeImpfdosenMenge();
		return anzeigeImpfdosenMenge.anzeigeImpfdosenNachHersteller();
	}

}
