package de.impf.impfstoffcharge.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import de.impf.impfstoffcharge.entity.ImpfstoffchargeTO;
import de.impf.impfstoffcharge.entity.internal.Impfstoffcharge;

@Stateless
public class ImpfstoffchargeDAO extends GenericDAO<Impfstoffcharge>{

	public ImpfstoffchargeDAO() {
		super(Impfstoffcharge.class);
	}
	
	public Impfstoffcharge findChargeByID(int ID) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		System.out.println("ID: "+ID);
		parameters.put("ID", ID);
		return super.findOneResult(Impfstoffcharge.FIND_BY_ID, parameters);
	}
	
	public void reduceChargeByID(int ID) {
		Impfstoffcharge aCharge = this.findChargeByID(ID);
		aCharge.setAnzahl(aCharge.getAnzahl()-1);
		super.save(aCharge);
	}
	
	public List<ImpfstoffchargeTO> getSummedChargenByHersteller() {
		List<ImpfstoffchargeTO> chargenTOListe = new ArrayList<ImpfstoffchargeTO>();
		List<Impfstoffcharge> chargenListe= super.findListResult(Impfstoffcharge.GET_SUMMEDCHARGEN_BY_HERSTELLER, null);
		for(Impfstoffcharge aCharge:chargenListe) {
			chargenTOListe.add(aCharge.toImpfstoffchargeTO());
		}
		return chargenTOListe;
	}
	
	public List<ImpfstoffchargeTO> getChargenByHerstellerAsTO(){
		List<ImpfstoffchargeTO> chargenTOListe = new ArrayList<ImpfstoffchargeTO>();
		List<Impfstoffcharge> chargenListe= super.findListResult(Impfstoffcharge.FIND_BY_HERSTELLER, null);
		for(Impfstoffcharge aCharge:chargenListe) {
			chargenTOListe.add(aCharge.toImpfstoffchargeTO());
		}
		return chargenTOListe;
	}
}
