package com.example.ch04.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private Integer age;
    private Date createdAt;

    @Column(name="role")
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;

    public UserEntity(String userName, Integer age, UserRole role) {
        this.userName = userName;
        this.age = age;
        this.role = role;
    }

    @PrePersist
    public void beforeCreate() {
        createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
