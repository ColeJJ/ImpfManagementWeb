package de.impf.termin.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import de.impf.termin.entity.TerminTO;
import de.impf.termin.entity.internal.Termin;

@Stateless
public class TerminDAO extends GenericDAO<Termin>{
	
	private static final boolean NICHTWAHRGENOMMEN = false;
	private static final boolean WAHRGENOMMEN = true;

	public TerminDAO() {
		super(Termin.class);
	}
	
	public List<TerminTO> getOpenTermine(){
		List<TerminTO> terminTOListe = new ArrayList<TerminTO>();
		Map<String,Object>parameters = new HashMap<String, Object>();
		parameters.put("wahrgenommen", NICHTWAHRGENOMMEN);
		List<Termin> terminListe =  super.findListResult(Termin.GET_OPEN_TERMINE, parameters);
		for(Termin aTermin:terminListe) {
			terminTOListe.add(aTermin.toTerminTO());
		}
		return terminTOListe;
	}
	
	public Termin findTerminByID(int ID) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", ID);
		return super.findOneResult(Termin.FIND_BY_ID, parameters);
	}

	public void setTerminWahrgenommen(int terminID) {
		Termin aTermin = this.findTerminByID(terminID);
		aTermin.setWahrgenommen(WAHRGENOMMEN);
		super.save(aTermin);
	}

	public List<TerminTO> getTermineForPatientNr(int NR) {
		List<TerminTO> terminTOList = new ArrayList<TerminTO>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("patientid", NR);
		List<Termin> terminList = super.findListResult(Termin.FIND_BY_PATIENTID, parameters);
		for(Termin aTermin:terminList) {
			terminTOList.add(aTermin.toTerminTO());
		}
		return terminTOList;
	}
}
