package dlg.menue;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

import awk.patientenverwaltung.usecase.IPatientenPflegenRemote;
import awk.patientenverwaltung.usecase.IPatientenSuchenRemote;
import awk.terminverwaltung.usecase.IImpfungPflegenRemote;
import awk.terminverwaltung.usecase.ITerminePflegenRemote;
import awk.terminverwaltung.usecase.ITermineSuchenRemote;
import awk.vakzineverwaltung.usecase.IAnzeigeImpfdosenMengeRemote;
import awk.vakzineverwaltung.usecase.IChargeErfassenRemote;
import awk.vakzineverwaltung.usecase.IChargeSuchenRemote;

public class HauptmenueService {
	
	private IPatientenPflegenRemote patientenPflegenRemote = null;
	private IPatientenSuchenRemote patientenSuchenRemote = null;
	private IChargeErfassenRemote chargeErfassenRemote = null;
	private IChargeSuchenRemote chargeSuchenRemote = null;
	private IAnzeigeImpfdosenMengeRemote anzeigeImpfstoffMengeRemote = null;
	private ITerminePflegenRemote terminePflegenRemote = null;
	private ITermineSuchenRemote termineSuchenRemote = null;
	private IImpfungPflegenRemote impfungenPflegenRemote = null;
	
	public HauptmenueService() throws RemoteException, NotBoundException, AccessException {
		
		Registry registry = LocateRegistry.getRegistry("127.0.0.1");
		
		patientenPflegenRemote = 
				(IPatientenPflegenRemote) registry.lookup("patientenPflegen");
		patientenSuchenRemote = 
				(IPatientenSuchenRemote) registry.lookup("patientenSuchen");
		chargeErfassenRemote = 
				(IChargeErfassenRemote) registry.lookup("chargeErfassen");
		chargeSuchenRemote = 
				(IChargeSuchenRemote) registry.lookup("chargeSuchen");
		anzeigeImpfstoffMengeRemote = 
				(IAnzeigeImpfdosenMengeRemote) registry.lookup("anzeigeImpfdosenMenge");
		terminePflegenRemote = 
				(ITerminePflegenRemote) registry.lookup("terminePflegen");
		termineSuchenRemote = 
				(ITermineSuchenRemote) registry.lookup("termineSuchen");
		impfungenPflegenRemote = 
				(IImpfungPflegenRemote) registry.lookup("impfungenPflegen");
			
		System.out.println("Connected to Server at: "+ new Date());
	}

	public IPatientenPflegenRemote getPatientenPflegenRemote() {
		return patientenPflegenRemote;
	}
	
	public IPatientenSuchenRemote getPatientenSuchenRemote() {
		return patientenSuchenRemote;
	}
	
	public IChargeErfassenRemote getChargeErfassenRemote() {
		return chargeErfassenRemote;
	}
	
	public IChargeSuchenRemote getChargeSuchenRemote() {
		return chargeSuchenRemote;
	}
	
	public IAnzeigeImpfdosenMengeRemote getAnzeigeImpfdosenMengeRemote() {
		return anzeigeImpfstoffMengeRemote;
	}
	
	public ITerminePflegenRemote getTerminePflegenRemote() {
		return terminePflegenRemote;
	}
	
	public ITermineSuchenRemote getTermineSuchenRemote() {
		return termineSuchenRemote;
	}
	
	public IImpfungPflegenRemote getImpfungPflegenRemote() {
		return impfungenPflegenRemote;
	}
	

}
