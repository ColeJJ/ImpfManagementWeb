package de.impf.termin.usecase.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.impf.termin.dao.TerminDAO;
import de.impf.termin.entity.TerminTO;
import de.impf.termin.usecase.ITermineSuchen;

@Stateless
public class TermineSuchen implements ITermineSuchen{

	@Inject
	TerminDAO terminDAO;

	@Override
	public List<TerminTO> getAllOpenTermine() {
		return (List <TerminTO>) terminDAO.getOpenTermine();
	}

}
