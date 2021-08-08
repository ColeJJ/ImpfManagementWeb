package de.impf.security.facade;


import javax.ejb.Local;

import de.impf.security.entity.User;


@Local
public interface IUserFacade {
	public User findUserByName(String username);
}