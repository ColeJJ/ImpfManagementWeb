package de.bank.kunde.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.bank.kunde.dao.KundeDAO;
import de.bank.kunde.entity.GeschaeftskundeTO;
import de.bank.kunde.entity.KundeTO;
import de.bank.kunde.entity.PrivatkundeTO;
import de.bank.kunde.entity.impl.Geschaeftskunde;
import de.bank.kunde.entity.impl.Kunde;
import de.bank.kunde.entity.impl.Privatkunde;
import de.bank.kunde.usecase.IKundenPflegen;

@Stateless
public class KundenPflegen implements IKundenPflegen {

	@Inject
	KundeDAO kundeDAO;
	


	@Override
	public boolean kundenLoeschen(int nummer) {
		Kunde aKunde = kundeDAO.find(nummer);
		System.out.println("Kunde "+aKunde.getKundenNr()+" gefunden zum Loeschen");
		if (aKunde == null) return Boolean.FALSE;
		else {
			kundeDAO.delete(aKunde);
			return Boolean.TRUE;
		}
	}

	@Override
	public List<KundeTO> getAllKunde() {
		List<Kunde> aList = kundeDAO.findAll();
		List<KundeTO> returnList = new ArrayList<KundeTO>();
		for (Kunde aKunde : aList) returnList.add(aKunde.toKundeTO());
		return returnList;
	}

	@Override
	public void privatkundeAnlegen(KundeTO kundeTO) {
		Kunde aKunde = new Privatkunde();
		aKunde = kundeTO.toKunde();
		kundeDAO.save(aKunde);
	}

	@Override
	public void geschaeftskundeAnlegen(KundeTO kundeTO) {
		Kunde aKunde = new Geschaeftskunde();
		aKunde = kundeTO.toKunde();
		kundeDAO.save(aKunde);
		
		
	}

	@Override
	public void kundeSpeichern(KundeTO kundeTO) {
		System.out.println(kundeTO.toString());

		Kunde aKunde = kundeDAO.find(kundeTO.getKundennummer());
		aKunde.setVorname(kundeTO.getVorname());
		aKunde.setNachname(kundeTO.getNachname());
		aKunde.setKonten(kundeTO.getKonten());
		aKunde.setAdresse(kundeTO.getStr(), kundeTO.getNr(), kundeTO.getPlz(), kundeTO.getOrt());
		
		if (aKunde instanceof Geschaeftskunde) {
			((Geschaeftskunde) aKunde).setVat( ((GeschaeftskundeTO) kundeTO).getUstId());
		} else if (aKunde instanceof Privatkunde) {
			((Privatkunde) aKunde).setGeschlecht(((PrivatkundeTO) kundeTO).getGeschlecht());
		}
		kundeDAO.update(aKunde);		
	}

}
