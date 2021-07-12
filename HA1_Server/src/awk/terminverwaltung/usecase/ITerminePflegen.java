package awk.terminverwaltung.usecase;

import java.time.LocalDate;

import awk.AnwendungskernException;

public interface ITerminePflegen {

	public boolean terminAnlegen(int terminID, LocalDate datum, String uhrzeit, int patientID) throws AnwendungskernException;
}
