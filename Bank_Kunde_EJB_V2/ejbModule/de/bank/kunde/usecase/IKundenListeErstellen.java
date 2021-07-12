package de.bank.kunde.usecase;

import java.util.Collection;

import javax.ejb.Local;

import de.bank.kunde.entity.KundeTO;

@Local
public interface IKundenListeErstellen {
	public Collection<KundeTO> kundeListeAusgeben();

}
