package de.impf.impfstoffcharge.usecase.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.impf.impfstoffcharge.dao.ImpfstoffchargeDAO;
import de.impf.impfstoffcharge.entity.ImpfstoffchargeTO;
import de.impf.impfstoffcharge.usecase.IChargeSuchen;

@Stateless
public class ChargeSuchen implements IChargeSuchen{
	
	@Inject 
	ImpfstoffchargeDAO chargenDAO;
	
	@Override
	public Collection<ImpfstoffchargeTO> getChargenByHersteller(String hersteller) {
		return chargenDAO.getChargenByHerstellerAsTO();
	}	
}