package com.example.mobiledevproj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class Medication {
        public String name;
        public double price;
        public List diseases;

    public Medication() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public Medication(String patientID, double price, List diseases) {
        this.name = patientID;
        this.price = price;
        this.diseases = diseases;
    }
}
    //String[] diseases = {"diabetes", "heart disease"};
    //List nameList = new ArrayList<String>(Arrays.asList(diseases));
    //Medication d1 = new Medication("1", 1.0, nameList);
    //ref.child("medication").child("1").setValue(d1);