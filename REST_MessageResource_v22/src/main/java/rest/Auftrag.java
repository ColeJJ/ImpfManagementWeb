package rest;

import java.util.ArrayList;
import java.util.List;

public class Auftrag {

	private int anr;
	private List<Auftragsposition> aposliste;
	
	public Auftrag(int id){
		this.anr = id;
		this.aposliste = new ArrayList<Auftragsposition>();
	}
	
	public int getAnr() {
		return anr;
	}
	
	public void setAnr(int anr) {
		this.anr = anr;
	}
	
	public List<Auftragsposition> getAposliste() {
		return aposliste;
	}
	
	public void addAuftragsposition(Auftragsposition aPosition) {
		this.aposliste.add(aPosition);
	}
	
	
	
}
