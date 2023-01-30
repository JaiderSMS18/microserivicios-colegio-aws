package com.martinez.configurations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtProvider {

	@Value("${com.tutorial.jwt.aws.identityPoolUrl}")
	private String identityPoolUrl;
	private static final String USERNAME_FIELD = "cognito:username";
    private static final String AUTHORIZATION = "AutorizarToken";
    @Autowired
    ConfigurableJWTProcessor<?> configurableJWTProcessor;
	
	public Authentication authenticate(HttpServletRequest request) throws Exception {
        String token = request.getHeader(AUTHORIZATION);
        if (token != null) {
            JWTClaimsSet claims = configurableJWTProcessor.process(getToken(token), null);
            validacionDelToken(claims);
            Object username = getUsername(claims);
            if (username != null) {
                // TODO set roles
                List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));
                User user = new User(username.toString(), "", authorities);
                return new JwtAuthenticator(authorities, user, claims);
            }
        }
        return null;
    }
	
	private Object getUsername(JWTClaimsSet claims) {
		return claims.getClaim(USERNAME_FIELD);
	}
	
	private void validacionDelToken(JWTClaimsSet claims) throws Exception {
		if(!claims.getIssuer().equals(identityPoolUrl)) {
			throw new Exception("JWT not valid");
		}
	}
	
	private String getToken(String token) {
		return token.startsWith("Bearer ") ? token.substring("Bearer ".length()) : token;
	}
}
