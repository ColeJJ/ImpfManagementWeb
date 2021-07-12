package de.bank.kunde.usecase;

import javax.ejb.Local;

import de.bank.kunde.entity.KundeTO;

@Local
public interface IKundeninformationFuerNr {

	public KundeTO kundeSuchenByNr (int nr);
}
