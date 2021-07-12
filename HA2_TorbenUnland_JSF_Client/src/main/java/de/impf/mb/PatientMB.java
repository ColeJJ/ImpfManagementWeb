package de.impf.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import de.impf.patient.entity.PatientTO;
import de.impf.patient.usecase.IPatientenPflegen;
import de.impf.patient.usecase.IPatientenSuchen;

@Named("PatientMB")
@RequestScoped
public class PatientMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2340591047267891474L;
	
	@Inject
	IPatientenPflegen patientPflegenFacade;
	
	@Inject
	IPatientenSuchen patientSuchenFacade;
	
	//Variablen
	private PatientTO aPatientTO;
	
	public PatientMB() {
	}
	
	@PostConstruct
	public void initBean() {
		this.aPatientTO = null;
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
	
	public String patientAnlegen() {
		try {
			patientPflegenFacade.patientAnlegen(this.aPatientTO);
			sendInfoMessageToUser("Patient angelegt");
			return "PATIENT_ANLEGEN_ABBRECHEN";
		} catch (EJBException e) {
			sendErrorMessageToUser("Kann den Patienten nicht anlegen.");
			return "";
		}
		
	}
	
	public String patientAnlegenAbbrechenClicked() {
		return "PATIENT_ANLEGEN_ABBRECHEN";
	}
	
}
