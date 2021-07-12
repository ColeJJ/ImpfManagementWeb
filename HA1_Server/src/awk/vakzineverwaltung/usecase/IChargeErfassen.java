package awk.vakzineverwaltung.usecase;

import java.time.LocalDate;

import awk.AnwendungskernException;

public interface IChargeErfassen {
	
	public boolean chargeErfassen(int anzahl, String hersteller, LocalDate datumAnlieferung) throws AnwendungskernException;
	
	public boolean reduceCharge(int chargeID) throws AnwendungskernException;

}
