package de.impf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import de.impf.impfstoffcharge.entity.ImpfstoffchargeTO;
import de.impf.impfstoffcharge.usecase.IAnzeigeImpfdosenMenge;
import de.impf.impfstoffcharge.usecase.IChargeErfassen;
import de.impf.impfstoffcharge.usecase.IChargeSuchen;

@Named("ImpfstoffchargeMB")
@RequestScoped
public class ImpfstoffchargeMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6454512266816010697L;
	
	@Inject
	IAnzeigeImpfdosenMenge anzeigeImpfdosenMengeFacade;
	
	@Inject
	IChargeErfassen chargeErfassenFacade;
	
	@Inject
	IChargeSuchen chargeSuchenFacade;
	
	//Variablen
	private ImpfstoffchargeTO aChargeTO;
	private List<ImpfstoffchargeTO> herstellerListe;
	
	public ImpfstoffchargeMB() {
	}
	
	@PostConstruct
	public void initBean() {
		this.aChargeTO = new ImpfstoffchargeTO();
		this.herstellerListe = new ArrayList<ImpfstoffchargeTO>();
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
	
	public String chargeErfassen() {
		try {
			chargeErfassenFacade.chargeErfassen(this.aChargeTO);
			sendInfoMessageToUser("Impfstoffcharge erfasst");
			return "IMPFSTOFFCHARGE_ERFASSEN_ABBRECHEN";
		} catch (EJBException e) {
			sendErrorMessageToUser("Kann die Impfstoffcharge nicht erfassen.");
			return "";
		}
		
	}
	
	public void anzeigeImpfdosenNachHersteller() {
		this.herstellerListe = anzeigeImpfdosenMengeFacade.anzeigeImpfdosenNachHersteller();
	}
	
	//Navigation
	public String starteVakzineverwaltung() {
		return "VAKZINEVERWALTUNG_MENUE";
	}
	
	public String chargeErfassenAbbrechenClicked() {
		return "IMPFSTOFFCHARGE_ERFASSEN_ABBRECHEN";
	}
	
	public String starteChargeErfassen() {
		return "IMPFCHARGE_ERFASSEN";
	}
	
	public String starteAnzeigeImpfdosenMenge() {
		return "ANZEIGE_IMPFDOSENMENGE";
	}

	public String vakzineVwAbbruchKlicked() {
		return "BACK_TO_HAUPTMENUE";
	}

	public ImpfstoffchargeTO getaChargeTO() {
		return aChargeTO;
	}

	public void setaChargeTO(ImpfstoffchargeTO aChargeTO) {
		this.aChargeTO = aChargeTO;
	}

	public List<ImpfstoffchargeTO> getHerstellerListe() {
		return herstellerListe;
	}

	public void setHerstellerListe(List<ImpfstoffchargeTO> herstellerListe) {
		this.herstellerListe = herstellerListe;
	}

}
