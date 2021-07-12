package bank.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("menueMB")
@RequestScoped
public class MenuMB {
	
	public String starteKundenverwaltung(){
		System.out.println("Anzeigen Kundenverwaltung");
		return "KUNDENVERWALTUNG_MENUE";
	}

	public String starteKontenverwaltung(){
		return "KONTENVERWALTUNG_MENUE";
	}
}
