package com.example.appdemo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers(SecurityParam.PERMITTED_TO_ALL).permitAll()
                .antMatchers(SecurityParam.PERMITTED_ONLY_TO_ADMIN).hasAuthority(SecurityParam.ROLE_ADMIN)
                .anyRequest().authenticated()
                .and().csrf().disable()
                .formLogin()
                .loginPage(SecurityParam.LOGIN_PAGE)
                .failureUrl(SecurityParam.FAILURE_URL)
                .defaultSuccessUrl(SecurityParam.SUCCESS_URL)
                .usernameParameter(SecurityParam.EMAIL)
                .passwordParameter(SecurityParam.PASSWORD)
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher(SecurityParam.LOGOUT_URL))
                .logoutSuccessUrl(SecurityParam.SUCCESS_URL)
                .and().exceptionHandling().accessDeniedPage(SecurityParam.ACCESS_DENIED_URL);
    }

    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring()
                .antMatchers(SecurityParam.WEB_SECURITY_IGNORE_PATH);
    }
}
