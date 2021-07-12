package awk.vakzineverwaltung.usecase.impl;

import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;
import awk.vakzineverwaltung.entity.internal.Impfstoffcharge;
import awk.vakzineverwaltung.usecase.IAnzeigeImpfdosenMenge;

public class AnzeigeImpfdosenMenge implements IAnzeigeImpfdosenMenge{

	@Override
	public Collection<ImpfstoffchargeTO> anzeigeImpfdosenNachHersteller() throws AnwendungskernException {
		VakzineManager vakzineManager = VakzineManager.getVakzineManager();
		Collection<ImpfstoffchargeTO> chargenMengeTOListe = new ArrayList<ImpfstoffchargeTO>();
		Collection<Impfstoffcharge> chargenMengeListe = vakzineManager.chargenNachHersteller();
		for(Impfstoffcharge aCharge:chargenMengeListe) {
			chargenMengeTOListe.add(aCharge.toImpfstoffchargeTO());
		}
		return chargenMengeTOListe;
	}

}
