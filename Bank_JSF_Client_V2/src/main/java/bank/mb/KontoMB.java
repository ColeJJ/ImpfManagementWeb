package bank.mb;

import java.io.Serializable;

import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import de.bank.konto.AnwendungskernException;
import de.bank.konto.entity.KontoTO;
import de.bank.konto.usecase.IKontenPflegen;
import de.bank.konto.usecase.IKontobewegungBuchen;
import de.bank.kunde.entity.KundeTO;
import de.bank.kunde.usecase.IKundeninformationFuerNr;

@Named("kontoMB")
@RequestScoped
public class KontoMB implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2526217096894280449L;

	@Inject
	IKundeninformationFuerNr kundenInfoFuerNr;
	
	@Inject
	IKontenPflegen kontenPflegen;
	
	@Inject
	IKontobewegungBuchen kontoBewegungBuchen;
	
	public KontoMB() {
	}
	

	private int kundenNr;
	private int ktoNr;
	private double betrag;
	private KundeTO kundeTO;
	private KontoTO kontoTO;
	
	public int getKundenNr() {
		return kundenNr;
	}

	public void setKundenNr(int kundenNr) {
		this.kundenNr = kundenNr;
	}

	public int getKtoNr() {
		return ktoNr;
	}

	public void setKtoNr(int ktoNr) {
		this.ktoNr = ktoNr;
	}

	public double getBetrag() {
		return betrag;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}

	public KundeTO getKundeTO() {
		return kundeTO;
	}

	public void setKundeTO(KundeTO kundeTO) {
		this.kundeTO = kundeTO;
	}
	
	public void starteKundensuche() {
		try {
			this.kundeTO = kundenInfoFuerNr.kundeSuchenByNr(this.kundenNr);
		} catch (EJBException e) {
			sendErrorMessageToUser("Kann keinen Kunden finden");
		}
	}
	
	public void sucheKontoInfo() throws AnwendungskernException{
		try {
			this.kontoTO = kontoBewegungBuchen.kontoSuchen(this.ktoNr);
		} catch (EJBException e) {
			sendErrorMessageToUser("Kann Konto nicht finden");
		}
	}
	
	public String kontoAnlegenAbbrechenClicked() {
		return "KONTO_ANLEGEN_ABBRECHEN";
	}
	
	public String kontobewegungBuchenAbbrechenClicked(){
		return "KONTOBEWEGUNG_ABBRECHEN";
	}
	
	public String kontoAnlegen() throws AnwendungskernException  {
		try {
			kontenPflegen.kontoAnlegen(this.kundenNr);
			sendInfoMessageToUser("Konto angelegt");
			return "KONTO_ANLEGEN_ABBRECHEN";
		} catch (EJBException e) {
			sendErrorMessageToUser("Kann das Konto nicht anlegen.");
			return "";
		}
		
	}
	
	public void einzahlen() throws AnwendungskernException {
		if (this.betrag != 0.0 ) {
			try {
				kontoBewegungBuchen.einzahlen(ktoNr, betrag);
				sendInfoMessageToUser("Betrag "+betrag+" eingezahlt");
				this.betrag = 0.0;
			} catch (EJBException e) {
				sendErrorMessageToUser("Betrag "+betrag+" konnte nicht eingezahlt werden");
				e.printStackTrace();
			}
		} else {
			sendErrorMessageToUser("Geben Sie einen Betrag ein");
		}
	}
	
	public void auszahlen() throws AnwendungskernException {
		
		if (this.betrag != 0.0 ) {
			try {
				kontoBewegungBuchen.abheben(ktoNr, betrag);
				sendInfoMessageToUser("Betrag "+betrag+" ausgezahlt");
				this.betrag = 0.0;
			} catch (EJBException e) {
				sendErrorMessageToUser("Betrag "+betrag+" konnte nicht ausgezahlt werden");
				e.printStackTrace();
			}
		} else {
			sendErrorMessageToUser("Geben Sie einen Betrag ein");
		}
	}
	public String kontoVwAbbruchClicked() {
		return "BACK_TO_HAUPTMENUE";
	}
	
	public String starteKontoAnlegen(){
		return "KONTO_ANLEGEN";
	}
	
	public String starteKontobewegungBuchen(){
		return "KONTOBEWEGUNG_BUCHEN";
	}

	public KontoTO getKontoTO() {
		return kontoTO;
	}

	public void setKontoTO(KontoTO kontoTO) {
		this.kontoTO = kontoTO;
	}
	
	
	private void sendInfoMessageToUser(String message){
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	private void sendErrorMessageToUser(String message){
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	private FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context;
	}
	
	
}
