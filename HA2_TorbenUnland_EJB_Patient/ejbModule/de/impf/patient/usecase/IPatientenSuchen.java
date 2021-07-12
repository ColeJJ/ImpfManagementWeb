package de.impf.patient.usecase;

import java.util.List;

import javax.ejb.Local;

import de.impf.patient.entity.PatientTO;

@Local
public interface IPatientenSuchen {

	public List<PatientTO> patientSuchenByName(String vorname, String name);
}
