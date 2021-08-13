package de.bank.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;



@BasicAuthenticationMechanismDefinition()
@DatabaseIdentityStoreDefinition(
//    config for Oracle-DB-Server
        dataSourceLookup = "java:/l4asrv-oracle",
        callerQuery = "select PASSWORD from t_user where USERNAME=?",
        groupsQuery = "select ROLENAME as GROUPNAME from t_user_roles where USERNAME=?",
      hashAlgorithm = PlainTextPasswordHash.class
//        hashAlgorithm = PlainSHA512PasswordHash.class
)

@ApplicationScoped
@Named
@ApplicationPath("api")
public class ApplicationConfig extends Application {

}
