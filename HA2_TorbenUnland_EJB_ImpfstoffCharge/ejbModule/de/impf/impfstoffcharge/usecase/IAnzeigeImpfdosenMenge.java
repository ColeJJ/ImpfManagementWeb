package de.impf.impfstoffcharge.usecase;

import java.util.List;

import javax.ejb.Local;

import de.impf.impfstoffcharge.entity.ImpfstoffchargeTO;

@Local
public interface IAnzeigeImpfdosenMenge {
	
	public List<ImpfstoffchargeTO> anzeigeImpfdosenNachHersteller();
}