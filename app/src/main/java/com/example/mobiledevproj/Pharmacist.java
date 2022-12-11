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
    //Pharmacist d1 = new Pharmacist("hadh@gmail.com", "123456789");
    //ref.child("pharmacist").child("1").setValue(d1)
