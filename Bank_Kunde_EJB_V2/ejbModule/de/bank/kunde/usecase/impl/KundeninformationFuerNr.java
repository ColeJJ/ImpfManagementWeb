package de.bank.kunde.usecase.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.bank.kunde.dao.KundeDAO;
import de.bank.kunde.entity.KundeTO;
import de.bank.kunde.usecase.IKundeninformationFuerNr;

@Stateless
public class KundeninformationFuerNr implements IKundeninformationFuerNr {

	@Inject
	KundeDAO kundeDAO;
	
	@Override
	public KundeTO kundeSuchenByNr(int nr) {
		return kundeDAO.find(nr).toKundeTO();
	}

}
