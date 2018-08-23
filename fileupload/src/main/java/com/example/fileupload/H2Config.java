package com.example.fileupload;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.h2.server.web.WebServlet;


@Configuration
public class H2Config {
    @Bean
    public ServletRegistrationBean h2servletReg() {
        ServletRegistrationBean regi = new ServletRegistrationBean(new WebServlet());
        regi.addUrlMappings("/console/*");
        return regi;
    }

}
