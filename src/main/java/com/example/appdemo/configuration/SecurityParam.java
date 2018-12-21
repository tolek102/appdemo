package com.example.appdemo.configuration;

public class SecurityParam {

    static final String WEB_SECUTITY_IGNORING[] = new String[] {"/resources/**" , "/statics/**", "/css/**", "/js/**", "/images/**", "/incl/**"};
    static final String PERMITTED_TO_ALL[] = new String[] {"/", "/index", "/login", "/register", "/adduser"};
    static final String PERMITTED_ONLY_TO_ADMIN[] = new String[] {"/admin"};
    static final String ROLE_ADMIN = "ROLE_ADMIN";
    static final String LOGIN_PAGE = "/login";
    static final String FAILURE_URL = "/login?error=true";
    static final String SUCCESS_URL = "/";
    static final String LOGOUT_URL = "/logout";
    static final String ACCESS_DENIED_URL = "/denied";
    static final String EMAIL = "email";
    static final String PASSWORD = "password";

}
