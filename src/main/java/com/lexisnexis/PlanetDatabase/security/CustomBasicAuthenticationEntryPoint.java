package com.lexisnexis.PlanetDatabase.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomBasicAuthenticationEntryPoint.class);

    @Override
    public void commence(final HttpServletRequest request, 
            final HttpServletResponse response, 
            final AuthenticationException authException) throws IOException, ServletException {
         
    	logger.info("User is not Authorized");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
         
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 : " + authException.getMessage());
    }
     
    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("MY_PLANET_REALM");
        super.afterPropertiesSet();
    }
}
