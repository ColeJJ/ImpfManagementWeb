package bank.mb;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import de.bank.kunde.entity.GeschaeftskundeTO;
import de.bank.kunde.entity.KundeTO;
import de.bank.kunde.entity.PrivatkundeTO;
import de.bank.kunde.usecase.IKundenPflegen;
import de.bank.kunde.usecase.IKundenSuchen;
import de.bank.kunde.usecase.IKundeninformationFuerNr;

import java.io.Serializable;


@Named("kundeMB")
@RequestScoped
public class KundeMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4993586984162593024L;

	@Inject
	IKundenPflegen kundePflegenFacade;
	
	@Inject
	IKundeninformationFuerNr kundenSuchenFacade;
	
	@Inject
	IKundenSuchen kundeSuchen;

//	
//	private List<Integer> konten;

	
	@NotNull
	private String kundenArt;
	
	private String selectedKdNr;
	private KundeTO selectedKundeTo;
	private PrivatkundeTO pkTo;
	private GeschaeftskundeTO gkTo;
	private String sucheName;
	private String sucheVorname;
	
	public KundeMB() {
	}
	

	@PostConstruct
	public void initBean() {
		this.kundenArt = "";
		this.selectedKundeTo = null;
		this.selectedKdNr = "";
		this.pkTo = new PrivatkundeTO();
		this.gkTo = new GeschaeftskundeTO();
//		this.setErgebnisListe(new List<KundeTO>());
	}
	

	
	public String kundeSpeichernClicked() {
				
		if (this.kundenArt.equals("privatkunde")) {
			this.pkTo.setKonten(new ArrayList<Integer>());
			kundePflegenFacade.privatkundeAnlegen(this.pkTo);
		}
		else if (this.kundenArt.contentEquals("geschaeftskunde")) {
			this.gkTo.setKonten(new ArrayList<Integer>());
			kundePflegenFacade.geschaeftskundeAnlegen(this.gkTo);
		}
		this.initBean();
		return "BACK_TO_KUNDENVW";
	}
	
	public String updateKundeStart(){
		System.out.println("Starte Update Kunde: "+ this.selectedKundeTo.getKundennummer());
		
		String ret = "";
		if (this.selectedKundeTo instanceof PrivatkundeTO) {
			ret = "UPDATE_PRIVATKUNDE";
			this.kundenArt = "privatkunde";
			System.out.println("Zeige Update Privatkunde-Form "+this.pkTo.getKundennummer());
		} else {
			ret = "UPDATE_GESCHAEFTSKUNDE";
			this.kundenArt = "geschaeftskunde";
			System.out.println("Zeige Update Geschaeftskunde-Form "+this.gkTo.getKundennummer());
		}
		return ret;
	}

	public String updateKundeStart2(){

		System.out.println("Update Kunde: "+ this.selectedKdNr);
		
		String ret = "";
		if (this.selectedKundeTo instanceof PrivatkundeTO) {
			ret = "UPDATE_PRIVATKUNDE";
			this.kundenArt = "privatkunde";
			System.out.println("Zeige Update Privatkunde-Form "+this.pkTo.getKundennummer());
		} else {
			ret = "UPDATE_GESCHAEFTSKUNDE";
			this.kundenArt = "geschaeftskunde";
			System.out.println("Zeige Update Geschaeftskunde-Form "+this.gkTo.getKundennummer());
		}
		return ret;
	}
	
	public String updatePrivatkundeEnd() {
		System.out.println("Privatkunde speichern: "+this.pkTo.getKundennummer()+" "+this.pkTo.getNachname());
		kundePflegenFacade.kundeSpeichern(this.pkTo);
		return "BACK_TO_KUNDENLISTANZEIGE";
	}
	
	public String updateGeschaeftskundeEnd() {
		System.out.println("Geschaeftskunde speichern: "+this.gkTo.getKundennummer()+" "+this.gkTo.getNachname());
		kundePflegenFacade.kundeSpeichern(this.gkTo);
		return "BACK_TO_KUNDENLISTANZEIGE";
	}
	
	public String updateKundeAbbrechen(){
		return "BACK_TO_KUNDENLISTANZEIGE";
	}
	
	public String sucheKundeStart() {
		return "SHOW_EINGABE_SUCHPARAMETER";
	}
	
	public String sucheKundeStartClicked() {
		return "SHOW_SUCH_ERGEBNIS";
	}
	
	public String sucheKundeAbbruch() {
		return "BACK_TO_KUNDENVW";
	}
	
	public String deleteKundeStart() {
				
		KundeTO aKundeTo = kundenSuchenFacade.kundeSuchenByNr(this.selectedKundeTo.getKundennummer());
		System.out.println("Starte Loeschen Kunde: "+aKundeTo.getKundennummer());
		
		return "DELETE_KUNDE";
	}
	
	public String deleteKundeEnd() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		this.selectedKdNr = params.get("selectedKdNr");
		
		System.out.println("Loesche Kunde: "+ this.selectedKdNr);
		try {
			kundePflegenFacade.kundenLoeschen(Integer.valueOf(this.selectedKdNr));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "BACK_TO_KUNDENLISTANZEIGE";
	}
	
	public String deleteKundeAbbrechenClicked() {
		System.out.println("Loesche Kunde abgebrochen: "+this.getSelectedKdNr());
		this.initBean();
		return "BACK_TO_KUNDENLISTANZEIGE";
	}

	public String kundeAnlegenAbbrechenClicked() {
		this.initBean();
		return "BACK_TO_KUNDENVW";
	}
	
	public String kundeListanzeigeAbbrechenClicked(){
		System.out.println("KundeListanzeigeAbbrechen-Button clicked");
		return "BACK_TO_KUNDENVW";
	}
	
	public String kundenVwAbbruchKlicked(){
		return "BACK_TO_HAUPTMENUE";
	}
	
	public List<KundeTO> getAllKunde(){
		return kundePflegenFacade.getAllKunde();
	}
	
	public List<KundeTO> starteSuche() {
		return kundeSuchen.kundenSuchenByName(this.sucheVorname, this.sucheName);
	}
	
	public String starteKundenAnlegen(){
		return "KUNDEN_ANLEGEN";
	}
	
	public String starteKundenListanzeige(){
		return "KUNDEN_LISTANZEIGE";
	}
	

	public String getKundenArt() {
		return kundenArt;
	}

	public void setKundenArt(String kundenArt) {
		this.kundenArt = kundenArt;
	}

	public String getSelectedKdNr() {
		return selectedKdNr;
	}

	public void setSelectedKdNr(String selectedKdNr) {
		this.selectedKdNr = selectedKdNr;
	}


	public KundeTO getPkTo() {
		return pkTo;
	}

	public void setPkTo(PrivatkundeTO pkTo) {
		if (this.pkTo == null) {
			this.pkTo = new PrivatkundeTO();
		}
		this.pkTo = pkTo;
	}

	public KundeTO getGkTo() {
		if (this.gkTo == null ) {
			this.gkTo = new GeschaeftskundeTO();
		}
		return gkTo;
	}

	public void setGkTo(GeschaeftskundeTO gkTo) {
		this.gkTo = gkTo;
	}

	public KundeTO getSelectedKundeTo() {
		return selectedKundeTo;
	}

	public void setSelectedKundeTo(KundeTO selectedKundeTo) {
		this.selectedKundeTo = selectedKundeTo;
	}


	public String getSucheName() {
		return sucheName;
	}


	public void setSucheName(String sucheName) {
		this.sucheName = sucheName;
	}


	public String getSucheVorname() {
		return sucheVorname;
	}


	public void setSucheVorname(String sucheVorname) {
		this.sucheVorname = sucheVorname;
	}



	
}
