package de.bank.kunde.usecase;

import java.util.List;

import javax.ejb.Local;

import de.bank.kunde.entity.KundeTO;

@Local
public interface IKundenSuchen {
	
	public List<KundeTO> kundenSuchenByName (String vorname, String nachname);
	
}
