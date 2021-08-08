package de.impf.security.facade;


import javax.inject.Inject;

import de.impf.security.dao.UserDAO;
import de.impf.security.entity.User;

import javax.ejb.Stateless;

@Stateless
public class UserFacadeImp implements IUserFacade {

	@Inject
	private UserDAO userDAO;
	
	public User findUserByName(String name) {
		return userDAO.findUserByName(name);
	}
}