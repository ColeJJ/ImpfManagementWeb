package de.impf.patient.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import de.impf.patient.entity.internal.Patient;

@Stateless
public class PatientDAO extends GenericDAO<Patient>{
	
	public PatientDAO() {
		super(Patient.class);
	}
	
	public Patient findPatientByName(String name) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		System.out.println("Name: "+name);
		parameters.put("name", name);
		return super.findOneResult(Patient.FIND_BY_NAME, parameters);
	}

	public List<Patient> findPatientByFirstAndLastName(String firstName, String name) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("vorname", firstName);
		parameters.put("nachname", name);
		
		return super.findListResult(Patient.FIND_BY_FIRST_AND_LASTNAME, parameters);
	}

}
