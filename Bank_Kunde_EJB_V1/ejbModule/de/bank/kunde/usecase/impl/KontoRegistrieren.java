package de.bank.kunde.usecase.impl;


import javax.ejb.Stateless;
import javax.inject.Inject;

import de.bank.kunde.dao.KundeDAO;
import de.bank.kunde.entity.impl.Kunde;
import de.bank.kunde.entity.impl.Privatkunde;
import de.bank.kunde.usecase.IKontoRegistrieren;

@Stateless
public class KontoRegistrieren implements IKontoRegistrieren{

	@Inject
	KundeDAO kundeDAO;
	
	@Override
	public void kontoHinzufuegen(int kdnr, int ktonr) {
		// TODO Auto-generated method stub
		
	}
	
}
