package de.bank.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.PasswordHash;


@ApplicationScoped
public class PlainTextPasswordHash implements PasswordHash {

    public String generate(char[] password) {
        return new String(password);
    }

    public boolean verify(char[] password, String hashedPassword) {
        return hashedPassword!=null && hashedPassword.equals(new String(password));
    }

}
