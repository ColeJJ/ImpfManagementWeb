package awk.terminverwaltung.persistence.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import awk.DatenhaltungsException;
import awk.persistence.Persistence;
import awk.terminverwaltung.entity.TerminTO;
import awk.terminverwaltung.persistence.ITerminDatenzugriff;

public class TerminDatenzugriff_DAO_DB implements ITerminDatenzugriff{

	@Override
	public void termindatenSpeichern(TerminTO terminTO) throws DatenhaltungsException {
		Connection aConnection = Persistence.getConnection();
		try {			
				Date date = Date.valueOf(terminTO.getDatum());
				int isWahrgenommen = terminTO.isWahrgenommen() ? 1 : 0;
		
				Persistence.executeUpdateStatement(
						aConnection, 
						"INSERT INTO HA1_TERMIN VALUES ( " +
						"Termin_seq.nextval," +
						"DATE '"+ date + "'," +
						"'"+ terminTO.getUhrzeit() + "'," +
						""+ terminTO.getPatientID() + "," +
						""+ isWahrgenommen +")");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatenhaltungsException();
		} finally {
			Persistence.closeConnection(aConnection);
		}
	}

	@Override
	public Collection<TerminTO> termindatenLesen() throws DatenhaltungsException {
		Connection aConnection = Persistence.getConnection();
		ResultSet resultSet;
		TerminTO aTerminTO;
		Collection<TerminTO> terminTOListe = new ArrayList<TerminTO>();
		try {
			resultSet = 
				Persistence.executeQueryStatement(aConnection, "SELECT * FROM HA1_TERMIN");
			while (resultSet.next()) {
				aTerminTO = new TerminTO();
				aTerminTO.setTerminID(resultSet.getInt("TERMINID"));
				aTerminTO.setDatum(resultSet.getDate("DATUM").toLocalDate());		
				aTerminTO.setUhrzeit(resultSet.getString("UHRZEIT"));
				aTerminTO.setPatientID(resultSet.getInt("PATIENTID"));
				int isWahrgenommen = resultSet.getInt("ISWAHRGENOMMEN");
				//Umwandeln des DB-Wertes (0 -> false, 1 -> true)
				if(isWahrgenommen == 1) aTerminTO.setWahrgenommen(true);
				else aTerminTO.setWahrgenommen(false);

				terminTOListe.add(aTerminTO);
			};
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatenhaltungsException();
		} finally {
			Persistence.closeConnection(aConnection);
		}
		System.out.println("Anzahl geladener Termine:"+terminTOListe.size());
		return terminTOListe;
	}
}
