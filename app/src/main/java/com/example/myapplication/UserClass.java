package com.example.myapplication;

public class UserClass {
    private String name;
    private String email;
    private String password;

    //constructors
    public UserClass(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserClass() {
    }

    //toString


    @Override
    public String toString() {
        return "UserClass{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
