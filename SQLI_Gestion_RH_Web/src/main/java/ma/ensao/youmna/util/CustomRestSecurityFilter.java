package ma.ensao.youmna.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.web.filter.GenericFilterBean;


public class CustomRestSecurityFilter extends GenericFilterBean {

	private AuthenticationManager authManager;	
	
    private AuthenticationEntryPoint authenticationEntryPoint;

    public CustomRestSecurityFilter(AuthenticationManager authenticationManager) {
        this(authenticationManager, new BasicAuthenticationEntryPoint());
        ((BasicAuthenticationEntryPoint)authenticationEntryPoint).setRealmName("Username: jack Password: jill");
    }

    public CustomRestSecurityFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
    	this.authManager = authenticationManager;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        
        //Pull out the Authorization header
        String authorization = request.getHeader("Authorization");

        //If the Authorization header is null, let the ExceptionTranslationFilter provided by
        //the <http> namespace kick of the BasicAuthenticationEntryPoint to provide the username and password dialog box
        if (authorization == null) {
            chain.doFilter(request, response);
            return;
        }

        String[] credentials = decodeHeader(authorization);
        assert credentials.length == 2;
        Authentication authentication = new RestToken(credentials[0], credentials[1]);

        try {
            //Request the authentication manager to authenticate the token
            Authentication successfulAuthentication = authManager.authenticate(authentication);
            
            //Pass the successful token to the SecurityHolder where it can be retrieved by this thread at any stage.
            SecurityContextHolder.getContext().setAuthentication(successfulAuthentication);
            
            //Continue with the Filters
            chain.doFilter(request, response);
        } catch (AuthenticationException authenticationException) {
        	System.out.println(authenticationException.getMessage());
            //If it fails clear this threads context and kick off the authentication entry point process.
            SecurityContextHolder.clearContext();
            authenticationEntryPoint.commence(request, response, authenticationException);
        }
    }

    public String[] decodeHeader(String authorization) {
        //Decode the Auth Header to get the username and password
        try {
            byte[] decoded = Base64.decode(authorization.getBytes("UTF-8"));
            String credentials = new String(decoded);
            System.out.println(credentials);
            return credentials.split(":");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

}