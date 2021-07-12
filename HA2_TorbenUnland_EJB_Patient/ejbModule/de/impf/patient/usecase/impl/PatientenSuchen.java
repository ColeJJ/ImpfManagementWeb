package de.impf.patient.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.impf.patient.dao.PatientDAO;
import de.impf.patient.entity.PatientTO;
import de.impf.patient.entity.internal.Patient;
import de.impf.patient.usecase.IPatientenSuchen;

@Stateless
public class PatientenSuchen implements IPatientenSuchen{

	@Inject
	PatientDAO patientDAO;
	
	@Override
	public List<PatientTO> patientSuchenByName(String vorname, String name){
		
		List<Patient> aList = patientDAO.findPatientByFirstAndLastName(vorname, name);
		List<PatientTO> returnList = new ArrayList<PatientTO>();
		for (Patient aPatient : aList) returnList.add(aPatient.toPatientTO());
		return returnList;
	}

}
