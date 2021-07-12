package de.impf.patient.usecase.impl;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.impf.patient.dao.PatientDAO;
import de.impf.patient.entity.PatientTO;
import de.impf.patient.entity.internal.Patient;
import de.impf.patient.usecase.IPatientenPflegen;

@Stateless
public class PatientenPflegen implements IPatientenPflegen{
	
	@Inject
	PatientDAO patientDAO;
	
	public PatientenPflegen() {
	}
	
	@Override
	public void patientAnlegen(PatientTO aPatientTO){
		Patient aPatient = aPatientTO.toPatient();
		patientDAO.save(aPatient);		
	}

	@Override
	public List<PatientTO> getAllKunde() {
		List<Patient> aList = patientDAO.findAll();
		List<PatientTO> returnList = new ArrayList<PatientTO>();
		for(Patient aPatient:aList) returnList.add(aPatient.toPatientTO());
		return returnList;
	}
	
	

}
