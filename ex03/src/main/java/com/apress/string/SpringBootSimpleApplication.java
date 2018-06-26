package com.apress.string;

import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringBootSimpleApplication implements CommandLineRunner, ApplicationRunner {

    public static void main(String[] args) {
        final Logger log = LoggerFactory.getLogger(SpringBootSimpleApplication.class);

        SpringApplication app = new SpringApplication(SpringBootSimpleApplication.class);
        app.setBanner(new Banner() {

            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                out.print("\n\n\t나만의 멋진 배너!!\n\n".toUpperCase());
            }

        });
        app.run(args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

    }
}
