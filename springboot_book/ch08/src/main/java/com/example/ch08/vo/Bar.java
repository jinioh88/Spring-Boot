package com.example.ch08.vo;

public interface Bar {
    String say();

    static Bar newInstance(String message) {
        return new DefaultBar(message);
    }
}
