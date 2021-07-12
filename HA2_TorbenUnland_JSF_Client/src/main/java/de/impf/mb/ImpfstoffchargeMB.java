package de.impf.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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
	
	public ImpfstoffchargeMB() {
	}
	
	@PostConstruct
	public void initBean() {
		this.aChargeTO = null;
	}

}
