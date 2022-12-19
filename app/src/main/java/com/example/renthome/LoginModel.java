package com.example.renthome;

public class LoginModel {
    String name, password, role, key;
    public LoginModel() {
    }

    public LoginModel(String name, String password, String role, String key) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
