package de.bank.kunde.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import de.bank.kunde.entity.impl.Kunde;

@Stateless
public class KundeDAO extends GenericDAO<Kunde> {
	
	public KundeDAO(){
		super(Kunde.class);
	}
	
	public void delete(Kunde aKunde){
		super.delete(aKunde.getKundenNr(), Kunde.class);
	}
	
	public List<Kunde> findKundeByFirstAndLastName(String firstName, String lastName){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("vorname", firstName);
		parameters.put("nachname", lastName);
		
		return super.findListResult(Kunde.FIND_BY_FIRST_AND_LASTNAME, parameters);
		
	}

}
