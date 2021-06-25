package com.example.firebasestart.pojo;

public class User {
    private String firstName;
    private String lastName;
    private String gender;
    private String middleName;

    public User() {
    }

    public User(String firstName, String lastName, String gender, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
