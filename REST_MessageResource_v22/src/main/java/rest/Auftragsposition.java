package rest;

public class Auftragsposition {

	private int aposnr;
	private String text;
	private Artikel artikel;
	private double menge;
	private double epreis;
	private double pospreis;
	
	public Auftragsposition(int nr, String text, double menge, double epreis, double pospreis, Artikel aArtikel){
		this.aposnr = nr;
		this.text = text;
		this.epreis = epreis;
		this.menge = menge;
		this.pospreis = pospreis;
		this.artikel = aArtikel;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public double getMenge() {
		return menge;
	}
	public void setMenge(double menge) {
		this.menge = menge;
	}
	public double getEpreis() {
		return epreis;
	}
	public void setEpreis(double epreis) {
		this.epreis = epreis;
	}
	public double getPospreis() {
		return pospreis;
	}
	public void setPospreis(double pospreis) {
		this.pospreis = pospreis;
	}

	public Artikel getArtikel() {
		return artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}
	
}
