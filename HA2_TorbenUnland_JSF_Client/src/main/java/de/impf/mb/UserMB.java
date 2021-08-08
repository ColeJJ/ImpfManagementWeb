package de.impf.mb;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import javax.servlet.ServletException;

import de.impf.security.entity.User;
import de.impf.security.facade.IUserFacade;


@SessionScoped
@Named("userMB")
@RolesAllowed({"MATERIALMANAGER","ARZT"})
public class UserMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4350145920139285844L;

	private User user;
	
	@Inject
	private IUserFacade userFacade;
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	SecurityContext securityContext;
	
	public UserMB() {}
	
	public User getUser(){
		
		System.out.println("getUser() in UserMB called");
		if(user == null && securityContext.isCallerInRole("MATERIALMANAGER")){	
			System.out.println("User hat Rolle MATERIALMANAGER: "+securityContext.isCallerInRole("MATERIALMANAGER"));
			String username = securityContext.getCallerPrincipal().getName();
			user = userFacade.findUserByName(username);
		}else {
			System.out.println("User hat Rolle ARZT: "+securityContext.isCallerInRole("ARZT"));
			String username = securityContext.getCallerPrincipal().getName();
			user = userFacade.findUserByName(username);
		}
		
		return user;
	}
	
	public boolean isUserArzt(){
		return securityContext.isCallerInRole("ARZT");
	}
	
	public String logOut() throws IOException, ServletException{
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();
		try {
			ec.redirect(ec.getApplicationContextPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Logout; USER: "+securityContext.getCallerPrincipal().getName());
		return "LOGOUT";
	}
	
}