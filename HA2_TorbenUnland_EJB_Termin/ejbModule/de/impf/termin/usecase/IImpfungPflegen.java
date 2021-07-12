package de.impf.termin.usecase;

import javax.ejb.Local;

import de.impf.termin.entity.ImpfungTO;

@Local
public interface IImpfungPflegen {

	public void impfungAnlegen(ImpfungTO aImpfungTO);
}
