package de.impf.impfstoffcharge.usecase;


import javax.ejb.Local;

import de.impf.impfstoffcharge.entity.ImpfstoffchargeTO;

@Local
public interface IChargeErfassen {
	
	public void chargeErfassen(ImpfstoffchargeTO aChargeTO);
	public void reduceCharge(int chargeID);

}
