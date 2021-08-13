package de.bank.jwt;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import java.util.logging.Logger;
import java.io.Serializable;

@SessionScoped
public class LoggerProducer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3986797632252209396L;

	@Produces
	public Logger produceLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
}
