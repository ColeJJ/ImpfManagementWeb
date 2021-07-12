package awk.vakzineverwaltung.factory;

import awk.vakzineverwaltung.usecase.IAnzeigeImpfdosenMenge;
import awk.vakzineverwaltung.usecase.IChargeErfassen;
import awk.vakzineverwaltung.usecase.IChargeSuchen;

public interface IVakzineverwaltungFactory {
	
	public IChargeErfassen getChargeErfassen();
	public IChargeSuchen getChargeSuchen();
	public IAnzeigeImpfdosenMenge getAnzeigeImpfdosenMenge();

}
