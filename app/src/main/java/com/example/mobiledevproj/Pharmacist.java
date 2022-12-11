package com.example.mobiledevproj;

public class Pharmacist {
    public String email;
    public String password;


    public Pharmacist() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public Pharmacist(String email, String password) {
        this.password = password;
        this.email = email;
    }
}
