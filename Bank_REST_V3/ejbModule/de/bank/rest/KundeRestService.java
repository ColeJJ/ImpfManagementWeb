package de.bank.rest;

import javax.annotation.security.PermitAll;
//import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.bank.kunde.entity.KundeTO;
import de.bank.kunde.usecase.IKundeninformationFuerNr;


@Path("kunde")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class KundeRestService {

	@Inject
	IKundeninformationFuerNr kundeInfoFuerNr;
	
	
	/*
	 *  http://localhost:8080/Bank_REST_V3/api/kunde/getKunde/{nr}
	 *  curl -i -X GET http://localhost:8080/Bank_REST_V3/api/kunde/getKunde/1
	 */
    @GET
    @Path("getKunde/{nr}")
    @PermitAll
//    @RolesAllowed("ADMIN")
    public KundeTO getKunde(@PathParam("nr") int nr) {
    	System.out.println("getKunde("+nr+") called");
        return kundeInfoFuerNr.kundeSuchenByNr(nr);
    }
    
//    @GET
//    @Path("admin")
//    @RolesAllowed("ADMIN")
//    public DemoModel getAdminDemo() {
//        return new DemoModel("Hello Admin");
//    }
    
    
    
}
