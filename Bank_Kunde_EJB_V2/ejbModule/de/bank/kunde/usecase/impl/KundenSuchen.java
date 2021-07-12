package de.bank.kunde.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.bank.kunde.dao.KundeDAO;
import de.bank.kunde.entity.KundeTO;
import de.bank.kunde.entity.impl.Kunde;
import de.bank.kunde.usecase.IKundenSuchen;

@Stateless
public class KundenSuchen implements IKundenSuchen {

	@Inject
	KundeDAO kundeDAO;
	
	
	@Override
	public List<KundeTO> kundenSuchenByName(String vorname, String nachname) {
		
		List<Kunde> aList = kundeDAO.findKundeByFirstAndLastName(vorname, nachname);
		List<KundeTO> returnList = new ArrayList<KundeTO>();
		for (Kunde aKunde : aList) returnList.add(aKunde.toKundeTO());
		return returnList;
	}

}
