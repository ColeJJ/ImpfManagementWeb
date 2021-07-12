package awk.vakzineverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;
import awk.vakzineverwaltung.entity.internal.Impfstoffcharge;
import awk.vakzineverwaltung.usecase.IChargeSuchen;

public class ChargeSuchen implements IChargeSuchen{

	@Override
	public Collection<ImpfstoffchargeTO> getAllChargen() throws AnwendungskernException {
		Collection<ImpfstoffchargeTO> chargenTOListe = new ArrayList<ImpfstoffchargeTO>();
		VakzineManager einVakzineManager = VakzineManager.getVakzineManager();
		for(Impfstoffcharge aCharge:einVakzineManager.getChargen()) {
			chargenTOListe.add(aCharge.toImpfstoffchargeTO());
		}
		return chargenTOListe;
	}

	@Override
	public Collection<ImpfstoffchargeTO> getChargenByHersteller(String hersteller) throws AnwendungskernException {
		Collection<ImpfstoffchargeTO> chargenTOListe = new ArrayList<ImpfstoffchargeTO>();
		VakzineManager einVakzineManager = VakzineManager.getVakzineManager();
		for(Impfstoffcharge aCharge:einVakzineManager.getChargenByHersteller(hersteller)) {
			chargenTOListe.add(aCharge.toImpfstoffchargeTO());
		}
		return chargenTOListe;
	}

}
