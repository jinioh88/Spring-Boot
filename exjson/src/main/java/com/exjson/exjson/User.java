package com.exjson.exjson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NON_PRIVATE)
public class User {
    @JsonProperty("age") protected int age;
    @JsonProperty("name") protected String name;
    @JsonIgnore protected String sPassword;

    public User() {}

    public User(int age, String name, String sPassword) {
        this.age = age;
        this.name = name;
        this.sPassword = sPassword;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
