package com.example.boot08.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.activation.DataSource;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    javax.sql.DataSource dataSource;

    @Autowired
    CustomUsersService customUsersService;

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        log.info("build Auth global...");
//
//        String query1 = "select uid username, concat('{noop}',upw) password, true enable from tbl_members where uid=?";
//        String query2 = "select member uid, role_name role from tbl_member_roles where member=?";
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(query1)
//                .rolePrefix("ROLE_")
//                .authoritiesByUsernameQuery(query2);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("secufiry config...");

        http.authorizeRequests().antMatchers("/guest/**").permitAll();
        http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
        http.formLogin().loginPage("/login");
        http.exceptionHandling().accessDeniedPage("/accessDenied");
        http.logout().logoutUrl("/logout").invalidateHttpSession(true);
        //http.userDetailsService(customUsersService);
        http.rememberMe().key("custom").userDetailsService(customUsersService);
    }
}
