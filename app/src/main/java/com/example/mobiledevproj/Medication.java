package com.example.mobiledevproj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class Medication {
        public String id;
        public String name;
        public double price;
        public List diseases;

    public Medication() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public Medication(String id, String patientID, double price, List diseases) {
        this.id = id;
        this.name = patientID;
        this.price = price;
        this.diseases = diseases;
    }
}
    //String[] diseases = {"diabetes", "heart disease"};
    //List nameList = new ArrayList<String>(Arrays.asList(diseases));
    //Medication d1 = new Medication("id random", "1", 1.0, nameList);
    //ref.child("medication").child("1").setValue(d1);

    //String[] diseases = {"arthrites"};
    //List nameList = new ArrayList<String>(Arrays.asList(diseases));
    //Medication d1 = new Medication("id random", "hyvfhjv", 4.0, nameList);
    //ref.child("medication").child("2").setValue(d1);