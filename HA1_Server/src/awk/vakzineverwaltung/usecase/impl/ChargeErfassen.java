package awk.vakzineverwaltung.usecase.impl;

import java.time.LocalDate;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.internal.Impfstoffcharge;
import awk.vakzineverwaltung.usecase.IChargeErfassen;

public class ChargeErfassen implements IChargeErfassen{

	@Override
	public boolean chargeErfassen(int anzahl, String hersteller, LocalDate datumAnlieferung) throws AnwendungskernException {
		// erzeuge ChargeManager welche in persitence die methode ausführt
		VakzineManager vakzineManager = VakzineManager.getVakzineManager();
		return vakzineManager.chargeHinzufuegen(new Impfstoffcharge(anzahl, hersteller, datumAnlieferung));
	}

	@Override
	public boolean reduceCharge(int chargeID) throws AnwendungskernException {
		VakzineManager vakzineManager = VakzineManager.getVakzineManager();
		return vakzineManager.reduceCharge(chargeID);
	}

}
