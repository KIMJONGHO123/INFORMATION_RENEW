package com.example.demo.config.auth.jwt;

/**
 * JWT 기본 설정값
 */
public class JwtProperties {
    public static final int ACCESS_TOKEN_EXPIRATION_TIME = 1000*30; // 60초
    public static final int REFRESH_TOKEN_EXPIRATION_TIME = 1000*60*2; // 60초
    public static final String ACCESS_TOKEN_COOKIE_NAME = "access-token";
    public static final String FRESH_TOKEN_COOKIE_NAME = "refresh-token";
}