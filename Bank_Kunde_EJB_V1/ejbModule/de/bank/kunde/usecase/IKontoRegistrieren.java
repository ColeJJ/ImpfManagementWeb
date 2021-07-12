package de.bank.kunde.usecase;

import javax.ejb.Local;

@Local
public interface IKontoRegistrieren {
	public void kontoHinzufuegen(int kdnr, int ktonr);
	
}
