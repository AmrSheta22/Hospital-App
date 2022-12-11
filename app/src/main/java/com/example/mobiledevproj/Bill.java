package com.example.mobiledevproj;

import java.util.List;

public class Bill {
    public String image_path;
    public String patientID;
    public String pharmacistID;
    public List medications; //id
    // id is incremental so we don't need number of appointment
    public Bill() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public Bill( String image_path, String patientID, String pharmacistID) {
        this.image_path = image_path;
        this.patientID = patientID ;
        this.pharmacistID = pharmacistID;
    }
    public Bill(List medications, String patientID, String pharmacistID) {
        this.pharmacistID = pharmacistID;
        this.patientID = patientID ;
        this.medications = medications;
    }
}
//Bill d1 = new Bill("/here/", "1", "1");
//ref.child("Bill").child("1").setValue(d1);

//meds contain list of ids (medication nodes)
//String[] meds = {"1", "2"};
//List nameList = new ArrayList<String>(Arrays.asList(meds));
//Bill d2 = new Bill(nameList, "1", "1");
//ref.child("Bill").child("2").setValue(d2);
