package com.example.ch08.vo;

public class DefaultBar implements Bar {
    private String message;

    public DefaultBar() {}

    public DefaultBar(String message) {
        this.message = message;
    }

    @Override
    public String say() {
        return null;
    }
}
