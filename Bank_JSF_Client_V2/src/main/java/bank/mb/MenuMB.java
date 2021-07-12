package bank.mb;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;


@Named("menueMB")
@RequestScoped
@RolesAllowed({"ADMIN","USER"})
public class MenuMB {

	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	SecurityContext securityContext;
	
	public MenuMB() {}
	
	@RolesAllowed("ADMIN")
	public String starteKundenverwaltung(){
		
		if (securityContext.isCallerInRole("ADMIN")) {
			System.out.println("Anzeigen Kundenverwaltung");
			return "KUNDENVERWALTUNG_MENUE";
		} else {
			System.out.println("Keine Rechte zum Anzeigen Kundenverwaltung");
			return "STAY_ON_PAGE";	
		}
		
		
	}
	
	@RolesAllowed("USER")
	public String starteKontenverwaltung(){
		
		if (securityContext.isCallerInRole("USER")) {
			System.out.println("Anzeigen Kundenverwaltung");
			return "KONTENVERWALTUNG_MENUE";
		} else {
			System.out.println("Keine Rechte zum Anzeigen Kontenverwaltung");
			return "STAY_ON_PAGE";	
		}

	}



}
