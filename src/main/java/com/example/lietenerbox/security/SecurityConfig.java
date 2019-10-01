package com.example.lietenerbox.security;

import lombok.extern.java.Log;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        log.info("security config.....");
        http.authorizeRequests().antMatchers("/guest/**").permitAll()
                                .antMatchers("/manager/**").hasRole("MANAGER");

        http.formLogin().loginPage("/person/loginForm");

    }
}
