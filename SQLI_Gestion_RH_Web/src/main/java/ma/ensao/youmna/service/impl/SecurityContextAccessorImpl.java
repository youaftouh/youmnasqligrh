package ma.ensao.youmna.service.impl;

import ma.ensao.youmna.service.SecurityContextAccessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextAccessorImpl implements SecurityContextAccessor {

	@Autowired
	private AuthenticationTrustResolver authenticationTrustResolver;

	public boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder
				.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}
}