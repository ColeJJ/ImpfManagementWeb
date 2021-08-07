package de.impf.impfstoffcharge.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.impf.impfstoffcharge.dao.ImpfstoffchargeDAO;
import de.impf.impfstoffcharge.entity.ImpfstoffchargeTO;
import de.impf.impfstoffcharge.entity.internal.Impfstoffcharge;
import de.impf.impfstoffcharge.usecase.IChargeSuchen;

@Stateless
public class ChargeSuchen implements IChargeSuchen{
	
	@Inject 
	ImpfstoffchargeDAO chargenDAO;
	
	@Override
	public List<ImpfstoffchargeTO> getChargenByHersteller(String hersteller) {
		return chargenDAO.getChargenByHerstellerAsTO();
	}

	@Override
	public List<ImpfstoffchargeTO> getAllChargen() {
		List<ImpfstoffchargeTO> chargenTOListe = new ArrayList<ImpfstoffchargeTO>();
		List<Impfstoffcharge> chargenListe = chargenDAO.findAll();
		for(Impfstoffcharge aCharge:chargenListe) {
			chargenTOListe.add(aCharge.toImpfstoffchargeTO());
		}
		return chargenTOListe;
	}	
}