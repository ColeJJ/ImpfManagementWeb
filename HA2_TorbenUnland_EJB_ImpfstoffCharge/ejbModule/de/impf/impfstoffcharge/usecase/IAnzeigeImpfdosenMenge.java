package de.impf.impfstoffcharge.usecase;

import java.util.Collection;

import javax.ejb.Local;

import de.impf.impfstoffcharge.entity.ImpfstoffchargeTO;

@Local
public interface IAnzeigeImpfdosenMenge {
	
	public Collection<ImpfstoffchargeTO> anzeigeImpfdosenNachHersteller();
}