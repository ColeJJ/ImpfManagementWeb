package awk.vakzineverwaltung.persistence;

import java.util.Collection;

import awk.DatenhaltungsException;
import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;
import awk.vakzineverwaltung.entity.internal.Impfstoffcharge;



public interface IVakzineDatenzugriff {
	
	public void impstoffchargeSpeichern (ImpfstoffchargeTO aChargeTO) throws DatenhaltungsException;
	
	public Collection<ImpfstoffchargeTO> impfstoffchargeLesen() throws DatenhaltungsException;
	
	public Collection<Impfstoffcharge> chargenNachHersteller() throws DatenhaltungsException;

	public Collection<Impfstoffcharge> getChargenByHersteller(String hersteller) throws DatenhaltungsException;

	public void reduceCharge(int chargeID) throws DatenhaltungsException;
}
