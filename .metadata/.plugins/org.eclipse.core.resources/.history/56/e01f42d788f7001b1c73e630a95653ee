package de.impf.termin.usecase.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.impf.termin.dao.TerminDAO;
import de.impf.termin.entity.TerminTO;
import de.impf.termin.entity.internal.Termin;
import de.impf.termin.usecase.ITerminePflegen;

@Stateless
public class TerminePflegen implements ITerminePflegen{

	@Inject
	TerminDAO terminDAO;
	
	@Override
	public void terminAnlegen(TerminTO aTerminTO) {
		Termin aTermin = aTerminTO.toTermin();
		terminDAO.save(aTermin);		
	}
}
