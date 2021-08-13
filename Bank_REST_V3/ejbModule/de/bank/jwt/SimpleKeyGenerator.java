package de.bank.jwt;

import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@RequestScoped
public class SimpleKeyGenerator implements Serializable, KeyGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6709786221442670165L;

	@Override
	public Key generateKey() {
		String keyString = "simplekey";
	    Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
	    return key;
		
	}

}
