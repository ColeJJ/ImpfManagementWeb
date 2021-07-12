/*
 * Oracle-DB User: VS2021_16
 * Matrikelnummer: 903367
 * Name: Torben Unland
 */

package server;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

import awk.patientenverwaltung.factory.IPatientenverwaltungRemoteFactory;
import awk.patientenverwaltung.factory.impl.PatientenverwaltungRemoteFactory;
import awk.patientenverwaltung.usecase.IPatientenPflegenRemote;
import awk.patientenverwaltung.usecase.IPatientenSuchenRemote;
import awk.terminverwaltung.factory.ITermineverwaltungRemoteFactory;
import awk.terminverwaltung.factory.impl.TermineverwaltungRemoteFactory;
import awk.terminverwaltung.usecase.IImpfungPflegenRemote;
import awk.terminverwaltung.usecase.ITerminePflegenRemote;
import awk.terminverwaltung.usecase.ITermineSuchenRemote;
import awk.vakzineverwaltung.factory.IVakzineverwaltungRemoteFactory;
import awk.vakzineverwaltung.factory.impl.VakzineverwaltungRemoteFactory;
import awk.vakzineverwaltung.usecase.IAnzeigeImpfdosenMengeRemote;
import awk.vakzineverwaltung.usecase.IChargeErfassenRemote;
import awk.vakzineverwaltung.usecase.IChargeSuchenRemote;

public class StartServer {
	
	public static void main (String args[]) throws AccessException, RemoteException {
		/* 1. Implementierung der Komponenten des Anwendungskerns aus Factory beziehen */
		IPatientenverwaltungRemoteFactory patientenvf = new PatientenverwaltungRemoteFactory();
		IVakzineverwaltungRemoteFactory vakzinevf = new VakzineverwaltungRemoteFactory();
		ITermineverwaltungRemoteFactory terminevf = new TermineverwaltungRemoteFactory();
		
		/* 2. Implementierung der benoetigten Use Cases beziehen */
		IPatientenPflegenRemote patientenPflegenRemote = patientenvf.getPatientenPflegenRemote();
		IPatientenSuchenRemote patientenSuchenRemote = patientenvf.getPatientenSuchenRemote();
		IChargeErfassenRemote chargeErfassenRemote = vakzinevf.getChargeErfassenRemote();
		IChargeSuchenRemote chargeSuchenRemote = vakzinevf.getChargeSuchenRemote();
		IAnzeigeImpfdosenMengeRemote anzeigeImpfdosenMengeRemote = vakzinevf.getAnzeigeImpfdosenMengeRemote();
		ITerminePflegenRemote terminePflegenRemote = terminevf.getTerminePflegenRemote();
		ITermineSuchenRemote termineSuchenRemote = terminevf.getTermineSuchenRemote();
		IImpfungPflegenRemote impfungPflegenRemote = terminevf.getImpfungPflegenRemote();
		
	
		/* 3. Implementierungen extern verfuebar machen */
		IPatientenPflegenRemote stubPatientenPflegenRemote = (IPatientenPflegenRemote) UnicastRemoteObject.exportObject(patientenPflegenRemote,0);
		IPatientenSuchenRemote stubPatientenSuchenRemote = (IPatientenSuchenRemote) UnicastRemoteObject.exportObject(patientenSuchenRemote,0);
		IChargeErfassenRemote stubChargeErfassenRemote = (IChargeErfassenRemote) UnicastRemoteObject.exportObject(chargeErfassenRemote,0);
		IChargeSuchenRemote stubChargeSuchenRemote = (IChargeSuchenRemote) UnicastRemoteObject.exportObject(chargeSuchenRemote,0);
		IAnzeigeImpfdosenMengeRemote stubAnzeigeImpfdosenMengeRemote = (IAnzeigeImpfdosenMengeRemote) UnicastRemoteObject.exportObject(anzeigeImpfdosenMengeRemote,0);
		ITerminePflegenRemote stubTerminePflegenRemote = (ITerminePflegenRemote) UnicastRemoteObject.exportObject(terminePflegenRemote,0);
		ITermineSuchenRemote stubTermineSuchenRemote = (ITermineSuchenRemote) UnicastRemoteObject.exportObject(termineSuchenRemote,0);
		IImpfungPflegenRemote stubImpfungPflegenRemote = (IImpfungPflegenRemote) UnicastRemoteObject.exportObject(impfungPflegenRemote,0);
		
		/* Namensdienst starten und Remote Objekte dort anmelden */
		RemoteServer.setLog(System.out);
		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		Registry registry = LocateRegistry.getRegistry();
		
		registry.rebind("patientenPflegen", stubPatientenPflegenRemote);
		registry.rebind("patientenSuchen", stubPatientenSuchenRemote);
		registry.rebind("chargeErfassen", stubChargeErfassenRemote);
		registry.rebind("chargeSuchen", stubChargeSuchenRemote);
		registry.rebind("anzeigeImpfdosenMenge", stubAnzeigeImpfdosenMengeRemote);
		registry.rebind("terminePflegen", stubTerminePflegenRemote);
		registry.rebind("termineSuchen", stubTermineSuchenRemote);
		registry.rebind("impfungenPflegen", stubImpfungPflegenRemote);
		
	}
}
