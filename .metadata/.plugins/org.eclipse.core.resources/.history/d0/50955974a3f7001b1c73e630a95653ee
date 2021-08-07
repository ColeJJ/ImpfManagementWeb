package de.impf.termin.usecase.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.impf.termin.dao.ImpfungDAO;
import de.impf.termin.entity.ImpfungTO;
import de.impf.termin.entity.internal.Impfung;
import de.impf.termin.usecase.IImpfungPflegen;

@Stateless
public class ImpfungPflegen implements IImpfungPflegen{

	@Inject
	ImpfungDAO impfDAO;
	
	@Override
	public void impfungAnlegen(ImpfungTO aImpfungTO) {
		Impfung aImpfung = aImpfungTO.toImpfung();
		impfDAO.save(aImpfung);	
	}


}
