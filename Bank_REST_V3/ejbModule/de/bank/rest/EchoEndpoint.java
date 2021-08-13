package de.bank.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/echo")
@Produces(MediaType.TEXT_PLAIN)
public class EchoEndpoint {

	/* im Browser:
	 * http://localhost:8080/Bank_REST_V3/api/echo?message=hallo%20Klaus
	 * 
	 * oder in Terminal:
	 * curl -i -X GET http://localhost:8080/Bank_REST_V3/api/echo?message=Hallo%20BIM
	 * */

	@GET
	public Response echo(@QueryParam("message") String message) {
		System.out.println("REST echo("+message+") called");
	     return Response.ok().entity(message == null ? "no message" : message).build();
	}


	
	/*
	* http://localhost:8080/Bank_REST_V3/api/echo/jwt?message=hallo%20Klaus
	* 
	* im Terminal:
	* curl -i -X GET http://localhost:8080/Bank_REST_V3/api/echo/jwt?message=HalloBim
	*/
	
	@GET
	@Path("jwt")
	@JWTTokenNeeded
	public Response echoWithJWTToken(@QueryParam("message") String message) {
	    return Response.ok().entity(message == null ? "no message" : message).build();
	}
	
}
