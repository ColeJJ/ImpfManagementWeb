package de.impf.patient.usecase;

import java.util.List;

import javax.ejb.Local;

import de.impf.patient.entity.PatientTO;

@Local
public interface IPatientenPflegen {
	
	public void patientAnlegen(PatientTO aPatientTO);
	public List<PatientTO> getAllPatienten();
}
