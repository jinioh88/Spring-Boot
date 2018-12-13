package com.example.ch04.model;

import org.springframework.hateoas.ResourceSupport;

public class TodoResource extends ResourceSupport {
    private String title;

    public TodoResource() {
    }

    public TodoResource(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}