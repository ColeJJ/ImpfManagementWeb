package awk.patientenverwaltung.persistence.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import awk.DatenhaltungsException;
import awk.patientenverwaltung.entity.PatientTO;
import awk.patientenverwaltung.persistence.IPatientenDatenzugriff;
import awk.persistence.Persistence;

public class PatientenDatenzugriff_DAO_DB implements IPatientenDatenzugriff {

	@Override
	public void patientendatenSpeichern(PatientTO patientTO) throws DatenhaltungsException {
		Connection aConnection = Persistence.getConnection();
		
		try {
			PatientTO aPatientTO = (PatientTO) patientTO;
			Date date = Date.valueOf(patientTO.getGeburtsdatum());
			Persistence.executeUpdateStatement(
					aConnection, 
					"INSERT INTO HA1_PATIENT VALUES ( " +
					"PatientID_seq.nextval," +
					"'"+ aPatientTO.getName() + "'," +
					"'"+ aPatientTO.getVorname() + "'," +
					"DATE '"+ date + "'," +
					"'"+ aPatientTO.getMail() + "',"+
					"'"+ aPatientTO.getTelefonNr() +"')");	
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatenhaltungsException();
		} finally {
			Persistence.closeConnection(aConnection);
		}
		
	}

	@Override
	public Collection<PatientTO> patientendatenLesen() throws DatenhaltungsException {
		Connection aConnection = Persistence.getConnection();
		ResultSet resultSet;
		PatientTO aPatientTO;
		Collection<PatientTO> patientenTOListe = new ArrayList<PatientTO>();
		try {
			resultSet = 
				Persistence.executeQueryStatement(aConnection, "SELECT * FROM HA1_PATIENT");
			while (resultSet.next()) {
				aPatientTO = new PatientTO();
				aPatientTO.setPatientenID(resultSet.getInt("PATIENTENID"));
				aPatientTO.setName(resultSet.getString("NAME"));		
				aPatientTO.setVorname(resultSet.getString("VORNAME"));
				aPatientTO.setGeburtsdatum(resultSet.getDate("GEBURTSDATUM").toLocalDate());
				aPatientTO.setMail(resultSet.getString("MAIL"));
				aPatientTO.setTelefonNr(resultSet.getString("TELEFONNR"));
	
				patientenTOListe.add(aPatientTO);
			};
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatenhaltungsException();
		} finally {
			Persistence.closeConnection(aConnection);
		}
		System.out.println("Anzahl geladener Kunden:"+patientenTOListe.size());
		return patientenTOListe;
	}

}
