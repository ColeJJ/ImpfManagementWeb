package rest;

import java.util.ArrayList;
import java.util.List;

public class AuftragListe {

	private List<Auftrag> auftragsliste;
	
	public AuftragListe(){
		this.auftragsliste = new ArrayList<Auftrag>();
	}
 
	public void addAuftrag(Auftrag aAuftrag1) {
		this.auftragsliste.add(aAuftrag1);
	}

	public Auftrag getAuftragById(int key) {

		
		for (Auftrag aAuftrag : auftragsliste){
			if (aAuftrag.getAnr() == key) return aAuftrag;
		}
		
		return null;
	}
	
	
}
