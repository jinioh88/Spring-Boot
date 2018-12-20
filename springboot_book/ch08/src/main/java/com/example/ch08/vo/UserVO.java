package com.example.ch08.vo;

import javax.validation.constraints.NotNull;

public class UserVO {

    private String id;
    @NotNull(message = "userName 필드가 null 입니다.")
    private String userName;
    private String pwd;

    public UserVO() {
    }

    public UserVO(String id, String userName, String pwd) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
