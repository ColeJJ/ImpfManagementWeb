package awk.vakzineverwaltung.usecase;

import java.util.Collection;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;

public interface IChargeSuchen {

	public Collection<ImpfstoffchargeTO> getAllChargen() throws AnwendungskernException;
	
	public Collection<ImpfstoffchargeTO> getChargenByHersteller(String hersteller) throws AnwendungskernException;
}
