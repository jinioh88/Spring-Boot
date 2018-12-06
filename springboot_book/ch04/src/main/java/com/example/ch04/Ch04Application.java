package com.example.ch04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ch04Application {

    public static void main(String[] args) {
        ApplicationContext ctx = (ApplicationContext) SpringApplication.run(Ch04Application.class, args);

    }
}
