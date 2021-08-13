package de.bank.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.QueryParam;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Logger;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import de.bank.jwt.KeyGenerator;
import de.security.entity.User;
import de.security.facade.IUserFacade;


/* Testen des REST-Services in Konsole mit:
 * curl -i -X POST 'http://localhost:8080/Bank_REST_V3/api/users/login?username=kda&password=kda'
 */

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class UserService {

	@Inject
	private IUserFacade userFacade;
	
	@Inject
	private KeyGenerator keyGenerator;
	
    @Context
    private UriInfo uriInfo;
    
    @Inject
    private Logger logger;
	
    
    /*
		curl -i -X POST 'http://localhost:8080/Bank_REST_V3/api/users/login?username=chef&password=chef'
     */
    
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(
				@QueryParam("username") String username,
				@QueryParam("password") String password
				) {
		System.out.println("login called with login: "+username+" password: "+password);
		try {
			authenticate(username, password);
			String token = issueToken(username);
			return Response.ok().header(AUTHORIZATION, "Bearer" +token).build();
		} catch (Exception e) {
			return Response.status(UNAUTHORIZED).build();
		}
		
		
	}

	private void authenticate(String username, String password) throws Exception {
		
		User aUser = userFacade.findUserByName(username);
		System.out.println("authenticate called with username: "+username+" password: "+password);
		if (aUser != null) {
			System.out.println("User found:"+aUser.getUsername());
			if (aUser.getPassword().equals(password)) {
				System.out.println("User korrektes Password:"+aUser.getPassword());
				logger.info("### korrekte Authentifizierung ###");
			} else {
				System.out.println("Falsches Kennwort: "+aUser.getPassword() + " uebergebener Wert:"+password);
				throw new SecurityException("Falscher Benutzername/Kennwort");
			}
		}
	}
	
	
    private String issueToken(String username) {
        Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(username)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
       
        return jwtToken;

    }
    
    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
