package com.example.mobiledevproj;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Patient {
        public String name;
        public String password;
        public String address;
        public boolean gender;
        public List diseases;
        public String email;
        public int age;
        public Patient() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public Patient(String name, String password, String address, boolean gender, List diseases, String email, int age) {
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