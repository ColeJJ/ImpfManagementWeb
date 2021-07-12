package awk.vakzineverwaltung.persistence.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import awk.DatenhaltungsException;
import awk.persistence.Persistence;
import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;
import awk.vakzineverwaltung.entity.internal.Impfstoffcharge;
import awk.vakzineverwaltung.persistence.IVakzineDatenzugriff;

public class VakzineDatenzugriff_DAO_DB implements IVakzineDatenzugriff{

	@Override
	public void impstoffchargeSpeichern(ImpfstoffchargeTO chargeTO) throws DatenhaltungsException {
		Connection aConnection = Persistence.getConnection();
		try {
				Date date = Date.valueOf(chargeTO.getDatumAnlieferung());
		
				Persistence.executeUpdateStatement(
						aConnection, 
						"INSERT INTO HA1_IMPFSTOFFCHARGE VALUES ( " +
						"Impfstoffcharge_seq.nextval," +
						""+ chargeTO.getAnzahl() + "," +
						"'"+ chargeTO.getHersteller() + "'," +
						"DATE '"+ date +"')");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DatenhaltungsException();
			} finally {
				Persistence.closeConnection(aConnection);
			}
	}

	@Override
	public Collection<ImpfstoffchargeTO> impfstoffchargeLesen() throws DatenhaltungsException {
		// Connection aufbauen -> alle datensätze lesen und in collection packen -> connection schließen -> return collection 
		Connection aConnection = Persistence.getConnection();
		Collection<ImpfstoffchargeTO> chargenTOListe = new ArrayList<ImpfstoffchargeTO>();
		ResultSet resultSet;
		
		try{
			resultSet = Persistence.executeQueryStatement(aConnection, "SELECT * FROM HA1_IMPFSTOFFCHARGE");
			
			while(resultSet.next()) {
				ImpfstoffchargeTO chargeTO = new ImpfstoffchargeTO();
				chargeTO.setChargeID(resultSet.getInt("CHARGEID"));
				chargeTO.setAnzahl(resultSet.getInt("ANZAHL"));
				chargeTO.setHersteller(resultSet.getString("HERSTELLER"));
				chargeTO.setDatumAnlieferung(resultSet.getDate("DATUM_ANLIEFERUNG").toLocalDate());
				
				chargenTOListe.add(chargeTO);
			}
			
		}catch (SQLException e){
			e.printStackTrace();
			throw new DatenhaltungsException();
		}finally {
			Persistence.closeConnection(aConnection);
		}
		System.out.println("Anzahl geladener Impfstoffchargen:"+chargenTOListe.size());
		return chargenTOListe;
	}

	//AF3 - ermittelt die Gesamtmengen an Impfstoff nach Hersteller
	@Override
	public Collection<Impfstoffcharge> chargenNachHersteller() throws DatenhaltungsException {
		// Connection aufbauen -> alle Chargen nach Hersteller holen und in eine Collection packen
		Connection aConnection = Persistence.getConnection();
		Collection<Impfstoffcharge> chargenMengeListe = new ArrayList<>();
		ResultSet resultSet;
		
		try{
			resultSet = Persistence.executeQueryStatement(aConnection, "SELECT HERSTELLER, SUM(ANZAHL) AS MENGE FROM HA1_IMPFSTOFFCHARGE GROUP BY HERSTELLER");
			
			while(resultSet.next()) {
				Impfstoffcharge aCharge = new Impfstoffcharge(
						resultSet.getInt("MENGE"),
						resultSet.getString("HERSTELLER")
				);
				chargenMengeListe.add(aCharge);
			}		
		}catch (SQLException e){
			e.printStackTrace();
			throw new DatenhaltungsException();
		}finally {
			Persistence.closeConnection(aConnection);
		}
		return chargenMengeListe;
	}

	//ermittelt alle einzelnen Chargen nach ausgewählten Hersteller
	@Override
	public Collection<Impfstoffcharge> getChargenByHersteller(String hersteller) throws DatenhaltungsException{
		Connection aConnection = Persistence.getConnection();
		Collection<Impfstoffcharge> chargenMengeListe = new ArrayList<>();
		ResultSet resultSet;
		
		try{
			resultSet = Persistence.executeQueryStatement(aConnection, "SELECT * FROM HA1_IMPFSTOFFCHARGE WHERE HERSTELLER = " + "'" + hersteller + "' AND ANZAHL > 0 AND DATUM_ANLIEFERUNG <= TRUNC(SYSDATE)");
			
			while(resultSet.next()) {
				Impfstoffcharge aCharge = new Impfstoffcharge(
						resultSet.getInt("CHARGEID"),
						resultSet.getInt("ANZAHL"),
						resultSet.getString("HERSTELLER"),
						resultSet.getDate("DATUM_ANLIEFERUNG").toLocalDate()
				);
				chargenMengeListe.add(aCharge);
			}		
		}catch (SQLException e){
			e.printStackTrace();
			throw new DatenhaltungsException();
		}finally {
			Persistence.closeConnection(aConnection);
		}
		return chargenMengeListe;
	}

	//AF5 - reduziert die Menge einer benutzten Charge um 1
	@Override
	public void reduceCharge(int chargeID) throws DatenhaltungsException {
		Connection aConnection = Persistence.getConnection();
		
		try {
			Persistence.executeUpdateStatement(aConnection, "UPDATE HA1_IMPFSTOFFCHARGE SET ANZAHL = ANZAHL-1 WHERE CHARGEID = " + chargeID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatenhaltungsException();
		} finally {
			Persistence.closeConnection(aConnection);
		}		
	}
}
