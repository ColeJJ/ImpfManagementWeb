package awk.vakzineverwaltung.usecase.impl;

import java.rmi.RemoteException;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;
import awk.vakzineverwaltung.usecase.IChargeSuchen;
import awk.vakzineverwaltung.usecase.IChargeSuchenRemote;

public class ChargeSuchenRemote implements IChargeSuchenRemote{

	@Override
	public Collection<ImpfstoffchargeTO> getAllChargenR() throws AnwendungskernException, RemoteException {
		IChargeSuchen chargeSuchen = new ChargeSuchen();
		return chargeSuchen.getAllChargen();
	}

	@Override
	public Collection<ImpfstoffchargeTO> getChargenByHerstellerR(String hersteller) throws AnwendungskernException, RemoteException {
		IChargeSuchen chargeSuchen = new ChargeSuchen();
		return chargeSuchen.getChargenByHersteller(hersteller);
	}

}
