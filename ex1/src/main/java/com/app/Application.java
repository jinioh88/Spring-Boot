package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    // @Autowired ExController controller; // 패키지가 달라 컴포넌트 스캔 못함
    @Autowired ExController2 controller2;

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }
}
