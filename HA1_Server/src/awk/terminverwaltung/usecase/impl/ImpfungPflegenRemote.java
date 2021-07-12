package awk.terminverwaltung.usecase.impl;

import java.rmi.RemoteException;
import java.time.LocalDate;

import awk.AnwendungskernException;
import awk.terminverwaltung.usecase.IImpfungPflegen;
import awk.terminverwaltung.usecase.IImpfungPflegenRemote;

public class ImpfungPflegenRemote implements IImpfungPflegenRemote{

	@Override
	public boolean impfungAnlegenR(LocalDate datum, String uhrzeit, String bemerkung, int terminID,
			int chargeID) throws AnwendungskernException, RemoteException {
		IImpfungPflegen impfungPflegen = new ImpfungPflegen();
		return impfungPflegen.impfungAnlegen(datum, uhrzeit, bemerkung, terminID, chargeID);
	}

}
