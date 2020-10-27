package com.example.producer.model;

public class UserProfile {


    private long id;
    private String FullName;
    private int age;
    private String email;

    public UserProfile(long id, String fullName, int age, String email) {
        FullName = fullName;
        this.age = age;
        this.email = email;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}