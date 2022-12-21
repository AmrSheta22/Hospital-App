package com.example.mobiledevproj;

import java.lang.reflect.Array;
import java.util.List;

public class Doctor {
    public String id;
    public String name;
    public String password;
    public String department;
    public String email;
    public int age;
    public double rating;
    public int numberOfPatients;
    public int yearsOfExp;
    public String imagepath;
    public Doctor() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Doctor(String id,String imagepath, String name, String password, String department, String email, int age, double rating, int numberOfPatients ,int yearsOfExp) {
        this.id = id;
        this.imagepath = imagepath;
        this.name = name;
        this.password = password;
        this.department = department;
        this.rating = rating;
        this.yearsOfExp = yearsOfExp;
        this.numberOfPatients = numberOfPatients;
        this.email = email;
        this.age = age;

    }
    public String getDoctor() {
        return id;
    }

    public void setDoctor(String id) {
        this.id = id;
    }


}
    //Doctor d1 = new Doctor("name", "1123456", "general", "haha@gmail.com", 11, 4.6, 500, 4);
    //ref.child("doctors").child("1").setValue(d1);
