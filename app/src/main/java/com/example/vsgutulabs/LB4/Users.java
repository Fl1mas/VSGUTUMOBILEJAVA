package com.example.vsgutulabs.LB4;

import java.io.Serializable;

public class Users implements Serializable {
    private String nickname;
    private String password;


    public Users(String nickname,String password){
        this.nickname = nickname;
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
