package awk.terminverwaltung.usecase.impl;

import java.time.LocalDate;

import awk.AnwendungskernException;
import awk.terminverwaltung.entity.impl.Termin;
import awk.terminverwaltung.usecase.ITerminePflegen;

public class TerminePflegen implements ITerminePflegen{

	@Override
	public boolean terminAnlegen(int terminID, LocalDate datum, String uhrzeit, int patientID)
			throws AnwendungskernException {
		TerminManager einTerminManager = TerminManager.getTerminManager();
		System.out.println("name:"+terminID+" "+datum+" "+uhrzeit+" "+patientID);
		return einTerminManager.terminHinzufuegen(new Termin(terminID, datum, uhrzeit, patientID, false));
	}

}
