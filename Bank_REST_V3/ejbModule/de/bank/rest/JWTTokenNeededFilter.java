package de.bank.rest;

import java.io.IOException;
import java.security.Key;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import de.bank.jwt.KeyGenerator;
import io.jsonwebtoken.Jwts;
import java.io.Serializable;

@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
@SessionScoped
public class JWTTokenNeededFilter implements Serializable, ContainerRequestFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3434364851812214865L;

	@Inject
	private Logger logger;
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private KeyGenerator keyGenerator;
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
	
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		logger.info("### authorizationHeader: "+authorizationHeader);
		
		if (authorizationHeader == null || authorizationHeader.startsWith("Bearer")) {
			logger.severe("### fehlerhafter authorizationHeader: "+ authorizationHeader);
			throw new NotAuthorizedException("Authorization Header muss unterstützt werden");
		}
		
		String token = authorizationHeader.substring("Bearer".length()).trim();
		
		try {
			Key key = keyGenerator.generateKey();
			Jwts.parser().setSigningKey(key).parseClaimsJws(token);
			logger.info("### korrektes token: "+token);
		} catch (Exception e) {
			logger.info("### fehlerhaftes token: "+token);
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}

}
