package awk.terminverwaltung.usecase.impl;

import java.rmi.RemoteException;
import java.time.LocalDate;

import awk.AnwendungskernException;
import awk.terminverwaltung.usecase.ITerminePflegenRemote;

public class TerminePflegenRemote implements ITerminePflegenRemote{

	@Override
	public boolean terminAnlegenR(int terminID, LocalDate datum, String uhrzeit, int patientID)
			throws AnwendungskernException, RemoteException {
		TerminePflegen terminePflegen = new TerminePflegen();
		return terminePflegen.terminAnlegen(terminID, datum, uhrzeit, patientID);
	}

}
