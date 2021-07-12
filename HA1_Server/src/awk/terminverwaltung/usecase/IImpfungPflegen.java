package awk.terminverwaltung.usecase;

import java.time.LocalDate;

import awk.AnwendungskernException;

public interface IImpfungPflegen {

	public boolean impfungAnlegen(LocalDate datum, String uhrzeit, String bemerkung, int terminID, int chargeID) throws AnwendungskernException;
}
