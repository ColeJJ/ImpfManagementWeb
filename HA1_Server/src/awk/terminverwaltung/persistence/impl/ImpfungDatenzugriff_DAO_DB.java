package awk.terminverwaltung.persistence.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import awk.DatenhaltungsException;
import awk.persistence.Persistence;
import awk.terminverwaltung.entity.ImpfungTO;
import awk.terminverwaltung.persistence.IImpfungDatenzugriff;

public class ImpfungDatenzugriff_DAO_DB implements IImpfungDatenzugriff{

	@Override
	public void impfdatenSpeichern(ImpfungTO impfungTO) throws DatenhaltungsException {
		Connection aConnection = Persistence.getConnection();
		
		try {			
			Date date = Date.valueOf(impfungTO.getDatum());
			Persistence.executeUpdateStatement(
					aConnection, 
					"INSERT INTO HA1_IMPFUNG VALUES ( " +
					"Impfung_seq.nextval," +
					"DATE '"+ date + "'," +
					"'"+ impfungTO.getUhrzeit() + "'," +
					""+ impfungTO.getTerminID() + "," +
					""+ impfungTO.getChargeID() + "," +
					"'"+ impfungTO.getBemerkung() +"')");
			Persistence.executeUpdateStatement(
					aConnection, 
					"UPDATE HA1_TERMIN SET ISWAHRGENOMMEN = 1 WHERE TERMINID = " + impfungTO.getTerminID());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatenhaltungsException();
		} finally {
			Persistence.closeConnection(aConnection);
		}	
	}

	@Override
	public Collection<ImpfungTO> impfdatenLesen() throws DatenhaltungsException {
		Connection aConnection = Persistence.getConnection();
		ResultSet resultSet;
		ImpfungTO aImpfungTO;
		Collection<ImpfungTO> impfungTOListe = new ArrayList<ImpfungTO>();
		
		try {
			resultSet = Persistence.executeQueryStatement(aConnection, "SELECT * FROM HA1_IMPFUNG");
			while(resultSet.next()) {
				aImpfungTO = new ImpfungTO();
				aImpfungTO.setImpfungID(resultSet.getInt("IMPFUNGID"));
				aImpfungTO.setDatum(resultSet.getDate("DATUM").toLocalDate());
				aImpfungTO.setUhrzeit(resultSet.getString("UHRZEIT"));
				aImpfungTO.setBemerkung(resultSet.getString("BEMERKUNG"));
				aImpfungTO.setTerminID(resultSet.getInt("TERMINID"));
				aImpfungTO.setChargeID(resultSet.getInt("CHARGEID"));
				impfungTOListe.add(aImpfungTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatenhaltungsException();
		} finally {
			Persistence.closeConnection(aConnection);
		}
		System.out.println("Anzahl geladener Impfungen:"+impfungTOListe.size());
		return impfungTOListe;
	}
}
