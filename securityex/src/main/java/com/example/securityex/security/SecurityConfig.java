package com.example.securityex.security;

import lombok.extern.java.Log;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("sucirity config...");
        http.authorizeRequests().antMatchers("/guest/**").permitAll();
        http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
        http.formLogin().loginPage("/login");
        http.exceptionHandling().accessDeniedPage("/accessDenied");
        http.logout().logoutUrl("/logout").invalidateHttpSession(true);
        /*
        위와 같은 의미
        http
            .authorizeRequests()
                .antMatchers("/guest/**").permitAll()
                .antMatchers("/manager/**").hasRole("MANAGER");
         */
    }
}
