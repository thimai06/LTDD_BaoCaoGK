package com.example.ungdungtruyen;

import java.io.Serializable;

public class User implements Serializable {
    private String password,gmail;
    public User(){

    }
    public User(String password,String email){
        this.gmail = email;
        this.password = password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.gmail = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return gmail;
    }
}
