package com.example.dropwizard.test.salssa.auth;

/**
 * POJO used holding custom credentials to be used to link a request to a specific principle (User)
 *  @author Elitza Haltakova
 */
public class SalssaCredentials {
	
	private final String token;

    public SalssaCredentials(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
