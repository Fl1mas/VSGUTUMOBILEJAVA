package com.example.vsgutulabs.LB4;

public class UsersManager {

    public static final Users[] USERS = {
            new Users("First", "1234"),
            new Users("Second", "1234"),
            new Users("Third", "1234")
    };

    public static Users findUserByCredentials(String nickname, String password) {
        for (Users user : USERS) {
            if (user.getNickname().equals(nickname) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}