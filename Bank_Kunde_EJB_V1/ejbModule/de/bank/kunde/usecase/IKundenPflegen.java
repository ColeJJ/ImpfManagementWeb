package de.bank.kunde.usecase;

import java.util.List;

import javax.ejb.Local;

import de.bank.kunde.entity.KundeTO;

@Local
public interface IKundenPflegen {


	public boolean kundenLoeschen (int nummer);
	public List<KundeTO> getAllKunde();
	public void privatkundeAnlegen(KundeTO kundeTO);
	public void geschaeftskundeAnlegen(KundeTO kundeTO);
	public void kundeSpeichern(KundeTO kundeTO);
}
