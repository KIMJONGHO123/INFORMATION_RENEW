package com.example.demo.config.auth.loginHandler;

import java.io.IOException;
import java.time.LocalDateTime;

import com.example.demo.config.auth.jwt.JwtProperties;
import com.example.demo.config.auth.jwt.JwtTokenProvider;
import com.example.demo.config.auth.jwt.TokenInfo;
import com.example.demo.domain.entity.JwtToken;
import com.example.demo.domain.repository.JwtTokenRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomLoginSuccesshandler implements AuthenticationSuccessHandler {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private JwtTokenRepository jwtTokenRepository;
	

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
		log.info("CustomLoginSuccessHandler's onAuthenticationSuccess invoke...");
		TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
		Cookie cookie = new Cookie(JwtProperties.ACCESS_TOKEN_COOKIE_NAME,tokenInfo.getAccessToken());
		cookie.setMaxAge(JwtProperties.ACCESS_TOKEN_EXPIRATION_TIME);
		cookie.setPath("/");
		response.addCookie(cookie);

		// JWTTOKEN DB 저장
		JwtToken jwtToken = new JwtToken();
		jwtToken.setAccessToken(null);
		jwtToken.setRefreshToken(null);
		jwtToken.setUsername(null);
		jwtToken.setCreatedAt(LocalDateTime.now());



		response.sendRedirect(request.getContextPath()+"/");
	}

}
