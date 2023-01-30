package com.martinez.configurations;

import java.io.IOException;
import java.lang.System.Logger;

import org.apache.commons.logging.Log;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;

@Component
//@Slf4j //se necesita lombok //@CommonsLog
public class JwtEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		//log.info("fallo en el clase JwtEntryPoint en el metodo commence");
		System.out.println("fallo en el clase JwtEntryPoint en el metodo commence");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "NO AUTORIZADO");
	}

}
