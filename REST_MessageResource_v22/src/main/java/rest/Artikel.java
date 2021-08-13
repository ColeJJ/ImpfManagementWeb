package rest;

import java.io.Serializable;


public class Artikel {

	private int id;
	private String name;
	private double preis;
	
	
//	public String toString(){
//		return new String ("User [id="+this.id + ",name="+ this.name + ",preis=" + this.preis+"]");
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
}
