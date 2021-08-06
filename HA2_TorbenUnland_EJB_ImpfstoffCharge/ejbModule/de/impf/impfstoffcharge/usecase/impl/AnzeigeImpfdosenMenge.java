package de.impf.impfstoffcharge.usecase.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.impf.impfstoffcharge.dao.ImpfstoffchargeDAO;
import de.impf.impfstoffcharge.entity.ImpfstoffchargeTO;
import de.impf.impfstoffcharge.usecase.IAnzeigeImpfdosenMenge;

@Stateless
public class AnzeigeImpfdosenMenge implements IAnzeigeImpfdosenMenge{
	
	@Inject
	ImpfstoffchargeDAO chargeDAO;

	@Override
	public List<ImpfstoffchargeTO> anzeigeImpfdosenNachHersteller() {
		return chargeDAO.getSummedChargenByHersteller();
	}
}
