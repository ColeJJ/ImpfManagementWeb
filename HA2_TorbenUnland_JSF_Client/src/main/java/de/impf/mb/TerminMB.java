package de.impf.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.impf.termin.entity.TerminTO;
import de.impf.termin.usecase.ITerminePflegen;
import de.impf.termin.usecase.ITermineSuchen;

@Named("TerminMB")
@RequestScoped
public class TerminMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3342217031141923805L;
	
	@Inject
	ITerminePflegen terminPflegenFacade;
	
	@Inject
	ITermineSuchen termineSuchenFacade;
	
	//Variblen
	private TerminTO aTerminTO;
	
	public TerminMB() {
	}
	
	@PostConstruct
	public void initBean() {
		this.aTerminTO = null;
	}

}
