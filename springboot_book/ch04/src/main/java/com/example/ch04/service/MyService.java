package com.example.ch04.service;

import com.example.ch04.config.MyAnnotation;

public class MyService {
    @MyAnnotation(strValue = "hi", intValue = 0607)
    public void printSomething() {
        System.out.println("test my annotation");
    }
}
