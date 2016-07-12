package com.example.gurupradeep.jewelery_app.Databases;

/**
 * Created by Guru Pradeep on 14-06-2016.
 */
public class Login {
    String username;
    String password;
    public Login()
    {

    }
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

