package com.example.aptech_final_project_be.constant;

public class SecurityConstants {
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String[] PUBLIC_URLS = {
        "/api/auth/**",
        "/swagger-ui/**",
        "/v3/api-docs/**"
    };
} 