package de.impf.termin.usecase;

import java.util.List;

import javax.ejb.Local;

import de.impf.termin.entity.ImpfungTO;

@Local
public interface IImpfungPflegen {

	public void impfungAnlegen(ImpfungTO aImpfungTO);
	public void impfungUpdaten(ImpfungTO aImpfungTO);
	public List<ImpfungTO> getAllImpfungen();
}
