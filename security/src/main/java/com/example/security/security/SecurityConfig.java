package com.example.security.security;

import lombok.extern.java.Log;
import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Log
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    ExUserService userService;

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/guest/**").permitAll()
                .antMatchers("/manager/**").hasRole("MANAGER")
                .antMatchers("/admin/**").hasRole("ADMIN").and()
                .formLogin().loginPage("/login").and()
                .exceptionHandling().accessDeniedPage("/accessDenied").and()
                .rememberMe().key("ex").userDetailsService(userService).tokenRepository(getJDBCRepository())
                .tokenValiditySeconds(60*60*24).and()
                .logout().logoutUrl("/logout").invalidateHttpSession(true);
//                .userDetailsService(userService);

    }

    private PersistentTokenRepository getJDBCRepository() {
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
        repository.setDataSource(dataSource);
        return repository;
    }

//    @Autowired
//    public void configreGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        // inMemory방법
//        auth.inMemoryAuthentication()
//                .withUser("manager")
//                .password("{noop}1111")
//                .roles("MANAGER").and()
//                .withUser("admin")
//                .password("{noop}1111")
//                .roles("ADMIN");
//        // JDBC이용 인증처리
//        String query1 = "select uid username, concat('{noop}',upw) password, true enabled from tbl_members where uid= ?";
//        String query2 = "select member uid, role_name role from tbl_member_roles where member= ?";
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(query1)
//                .rolePrefix("ROLE_")
//                .authoritiesByUsernameQuery(query2);
//    }
}
