package awk.vakzineverwaltung.factory.impl;

import awk.vakzineverwaltung.factory.IVakzineverwaltungFactory;
import awk.vakzineverwaltung.usecase.IAnzeigeImpfdosenMenge;
import awk.vakzineverwaltung.usecase.IChargeErfassen;
import awk.vakzineverwaltung.usecase.IChargeSuchen;
import awk.vakzineverwaltung.usecase.impl.AnzeigeImpfdosenMenge;
import awk.vakzineverwaltung.usecase.impl.ChargeErfassen;
import awk.vakzineverwaltung.usecase.impl.ChargeSuchen;

public class VakzineverwaltungFactory implements IVakzineverwaltungFactory{

	@Override
	public IChargeErfassen getChargeErfassen() {
		return new ChargeErfassen();
	}

	@Override
	public IAnzeigeImpfdosenMenge getAnzeigeImpfdosenMenge() {
		return new AnzeigeImpfdosenMenge();
	}

	@Override
	public IChargeSuchen getChargeSuchen() {
		return new ChargeSuchen();
	}

}
