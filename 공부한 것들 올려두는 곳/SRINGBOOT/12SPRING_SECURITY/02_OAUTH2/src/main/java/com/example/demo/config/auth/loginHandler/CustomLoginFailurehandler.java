package com.example.demo.config.auth.loginHandler;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginFailurehandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

		log.error("CustomLoginFailureHandler's onAuthenticationFailure invoke...");
		request.getSession().setAttribute("loginErrorMsg", exception.getMessage());
		String errorMessage = URLEncoder.encode(exception.getMessage(), StandardCharsets.UTF_8);
		response.sendRedirect(request.getContextPath() + "/login?error=" + errorMessage);
	}

}
