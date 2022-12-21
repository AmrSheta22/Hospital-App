package com.example.mobiledevproj;

import java.util.List;

public class Bill {
    public String id;
    public String image_path;
    public String patientID;
    public String pharmacistID;
    public List medications; //id
    // id is incremental so we don't need number of appointment
    // hi hi
    // hi hi captin
    public Bill() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public Bill(String id, String image_path, String patientID, String pharmacistID) {
        this.id = id;
        this.image_path = image_path;
        this.patientID = patientID ;
        this.pharmacistID = pharmacistID;
    }
    public Bill(String id, List medications, String patientID, String pharmacistID) {
        this.id = id;
        this.pharmacistID = pharmacistID;
        this.patientID = patientID ;
        this.medications = medications;
    }
}
//Bill d1 = new Bill("id", "/here/", "1", "1");
//ref.child("Bill").child("1").setValue(d1);

//meds contain list of ids (medication nodes)
//String[] meds = {"1", "2"};
//List nameList = new ArrayList<String>(Arrays.asList(meds));
//Bill d2 = new Bill("id",nameList, "1", "1");
//ref.child("Bill").child("2").setValue(d2);
