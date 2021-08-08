package de.impf.mb;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;

@Named("MenueMB")
@RequestScoped
public class MenueMB {
	
	public MenueMB() {}
	
	public String startePatientenverwaltung(){
		return "PATIENTENVERWALTUNG_MENUE";
	}
	
	public String starteTerminverwaltung(){
		return "TERMINEVERWALTUNG_MENUE";
	}
	
	@RolesAllowed("MATERIALMANAGER")
	public String starteVakzineverwaltung(){
		return "VAKZINEVERWALTUNG_MENUE";
	}
}
