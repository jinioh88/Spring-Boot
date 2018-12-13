package com.example.ch04.importSelect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BConfig {
    @Bean
    MyBean myBean() {
        return new MyBean("from Bconfig");
    }
}
