package awk.vakzineverwaltung.usecase;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;

public interface IChargeSuchenRemote extends Remote{

	public Collection<ImpfstoffchargeTO> getAllChargenR() throws AnwendungskernException, RemoteException;
	
	public Collection<ImpfstoffchargeTO> getChargenByHerstellerR(String hersteller) throws AnwendungskernException, RemoteException;
}
