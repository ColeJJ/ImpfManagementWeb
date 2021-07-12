package awk.vakzineverwaltung.usecase;

import java.util.Collection;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;

public interface IAnzeigeImpfdosenMenge {
	
	public Collection<ImpfstoffchargeTO> anzeigeImpfdosenNachHersteller() throws AnwendungskernException;

}
