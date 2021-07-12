package de.impf.termin.usecase;


import javax.ejb.Local;

import de.impf.termin.entity.TerminTO;

@Local
public interface ITerminePflegen {

	public void terminAnlegen(TerminTO aTerminTO);
}
