package awk.vakzineverwaltung.usecase;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;

public interface IAnzeigeImpfdosenMengeRemote extends Remote{

	public Collection<ImpfstoffchargeTO> anzeigeImpfdosenNachHerstellerR() throws AnwendungskernException, RemoteException;
}
