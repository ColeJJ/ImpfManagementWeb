package awk.vakzineverwaltung.usecase.impl;

import java.rmi.RemoteException;
import java.time.LocalDate;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.usecase.IChargeErfassenRemote;

public class ChargeErfassenRemote implements IChargeErfassenRemote{

	@Override
	public boolean chargeErfassenR(int anzahl, String hersteller, LocalDate datumAnlieferung) throws AnwendungskernException, RemoteException {
		// Erzeugt ChargeErfassen und fuehrt dessen charge erfassen aus
		ChargeErfassen chargeErfassen = new ChargeErfassen();
		return chargeErfassen.chargeErfassen(anzahl, hersteller, datumAnlieferung);
	}

	@Override
	public boolean reduceChargeR(int chargeID) throws AnwendungskernException, RemoteException {
		ChargeErfassen chargeErfassen = new ChargeErfassen(); 
		return chargeErfassen.reduceCharge(chargeID);
	}

}
