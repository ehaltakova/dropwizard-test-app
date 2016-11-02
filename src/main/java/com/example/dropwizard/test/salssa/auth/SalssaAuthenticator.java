package com.example.dropwizard.test.salssa.auth;

import java.util.Optional;

import com.example.dropwizard.test.salssa.api.User;

import io.dropwizard.auth.*;

public class SalssaAuthenticator implements io.dropwizard.auth.Authenticator<SalssaCredentials, User>{

	public Optional<User> authenticate(SalssaCredentials credentisla) throws AuthenticationException {
		return Optional.of(new User());
	}
}
