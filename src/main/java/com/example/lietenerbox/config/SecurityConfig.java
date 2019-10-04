package com.example.lietenerbox.config;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Log
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("security config.....");

        http.authorizeRequests().antMatchers("/persons/**").permitAll()
                .antMatchers("/groups/**").hasRole("NORMAL")
                .antMatchers("/wordInGroup/**").hasRole("NORMAL")
                .antMatchers("/itemInGroup/**").hasRole("NORMAL")
                .antMatchers("/items/**").hasRole("NORMAL")
                .antMatchers("/words/**").hasRole("NORMAL")
                .antMatchers("/study/**").permitAll()
                .antMatchers("/persons/loginForm").permitAll()
//                .antMatchers("/persons/**").hasRole("NORMAL")
                .antMatchers("/admin/**").hasRole("ADMIN");


        http.formLogin().disable();//security에서 제공하는 로그인 페이지 사용 안함

    }
}
