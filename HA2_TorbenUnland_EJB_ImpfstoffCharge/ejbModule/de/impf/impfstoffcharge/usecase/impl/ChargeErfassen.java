package de.impf.impfstoffcharge.usecase.impl;


import javax.ejb.Stateless;
import javax.inject.Inject;

import de.impf.impfstoffcharge.dao.ImpfstoffchargeDAO;
import de.impf.impfstoffcharge.entity.ImpfstoffchargeTO;
import de.impf.impfstoffcharge.entity.internal.Impfstoffcharge;
import de.impf.impfstoffcharge.usecase.IChargeErfassen;

@Stateless
public class ChargeErfassen implements IChargeErfassen{

	@Inject
	ImpfstoffchargeDAO chargeDAO;
	
	public ChargeErfassen() {
	}
	
	@Override
	public void chargeErfassen(ImpfstoffchargeTO aChargeTO) {
		Impfstoffcharge aCharge = aChargeTO.toImpfstoffcharge();
		chargeDAO.save(aCharge);
	}

	@Override
	public void reduceCharge(int chargeID) {
		chargeDAO.reduceChargeByID(chargeID);
	}
}