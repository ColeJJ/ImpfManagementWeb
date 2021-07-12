package de.impf.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.impf.termin.entity.ImpfungTO;
import de.impf.termin.usecase.IImpfungPflegen;

@Named("ImpfungMB")
@RequestScoped
public class ImpfungMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2293814775363405581L;
	
	@Inject 
	IImpfungPflegen impfungPflegenFacade;
	
	//Variablen
	private ImpfungTO aImpfungTO;
	
	public ImpfungMB() {
	}
	
	@PostConstruct
	public void initBean() {
		this.aImpfungTO = null;
	}

}