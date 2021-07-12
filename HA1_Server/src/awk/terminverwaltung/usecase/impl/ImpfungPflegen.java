package awk.terminverwaltung.usecase.impl;

import java.time.LocalDate;

import awk.AnwendungskernException;
import awk.terminverwaltung.entity.impl.Impfung;
import awk.terminverwaltung.usecase.IImpfungPflegen;

public class ImpfungPflegen implements IImpfungPflegen{

	@Override
	public boolean impfungAnlegen(LocalDate datum, String uhrzeit, String bemerkung, int terminID,
			int chargeID) throws AnwendungskernException {
		ImpfungManager einImpfManager = ImpfungManager.getImpfungManager();
		System.out.println("name:"+datum+" "+uhrzeit+" "+bemerkung+" "+terminID+" "+chargeID);
		return einImpfManager.ImpfungHinzufuegen(new Impfung(datum, uhrzeit, bemerkung, terminID, chargeID));
	}

}
