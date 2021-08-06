package de.impf.mb;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("MenueMB")
@RequestScoped
public class MenueMB {
	
	
	
	public MenueMB() {}
	
	//@RolesAllowed("ADMIN")
	public String startePatientenverwaltung(){
		System.out.println("Anzeigen Patientenverwaltung");
		return "PATIENTENVERWALTUNG_MENUE";
		
		
		//TODO: Security
		/*if (securityContext.isCallerInRole("ADMIN")) {
			System.out.println("Anzeigen Kundenverwaltung");
			return "KUNDENVERWALTUNG_MENUE";
		} else {
			System.out.println("Keine Rechte zum Anzeigen Kundenverwaltung");
			return "STAY_ON_PAGE";	
		}*/
		
		
	}
	
	//@RolesAllowed("USER")
	public String starteTerminverwaltung(){
		System.out.println("Anzeigen Terminverwaltung");
		return "TERMINEVERWALTUNG_MENUE";
		
		
		//TODO: Security
		/*if (securityContext.isCallerInRole("USER")) {
			System.out.println("Anzeigen Kundenverwaltung");
			return "KONTENVERWALTUNG_MENUE";
		} else {
			System.out.println("Keine Rechte zum Anzeigen Kontenverwaltung");
			return "STAY_ON_PAGE";	
		}*/

	}
	
	//@RolesAllowed("USER")
	public String starteVakzineverwaltung(){
		System.out.println("Anzeigen Vakzineverwaltung");
		return "VAKZINEVERWALTUNG_MENUE";
		
		
		//TODO: Security
		/*if (securityContext.isCallerInRole("USER")) {
			System.out.println("Anzeigen Kundenverwaltung");
			return "KONTENVERWALTUNG_MENUE";
		} else {
			System.out.println("Keine Rechte zum Anzeigen Kontenverwaltung");
			return "STAY_ON_PAGE";	
		}*/

	}

}
