package com.example.mobiledevproj;

import com.google.firebase.database.Exclude;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Patient {
    public String id;
    public String name;
    public String password;
    public String address;
    public boolean gender;
    public ArrayList<String> diseases;
    public String email;
    public int age;
    public Map<String, Boolean> stars = new HashMap<>();

    public Patient() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Patient(String id, String name, String password, String address, boolean gender, ArrayList<String> diseases, String email, int age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.diseases = diseases;
        this.email = email;
        this.age = age;
    }



}
    //String[] diseases = {"diabetes", "heart disease"};
    //List nameList = new ArrayList<String>(Arrays.asList(diseases));
    //Patient p1 = new Patient("name", "1123456", "40 street miami", true, nameList, "haha@gmail.com", 11);
    //ref.child("users").child("1").setValue(p1);