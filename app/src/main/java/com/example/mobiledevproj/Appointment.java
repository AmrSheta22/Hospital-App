package com.example.mobiledevproj;

public class Appointment {
    public int number;
    public String patientID;
    public String doctorID;
    // id is incremental so we don't need number of appointment
    public Appointment() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public Appointment(int number, String patientID, String doctorID) {
        this.number = number;
        this.patientID = patientID;
        this.doctorID = doctorID;
    }
}

    //Appointment d1 = new Appointment("1", "1", "1");
    // ref.child("appointment").child("1").setValue(d1);