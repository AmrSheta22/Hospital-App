package com.example.mobiledevproj;

public class Appointment {
    public String patientID;
    public String doctorID;
    // id is incremental so we don't need number of appointment
    public Appointment() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public Appointment(String patientID, String doctorID) {
        this.patientID = patientID;
        this.doctorID = doctorID;
    }
    public String getdoctorID() {
        return doctorID;
    }

    public void setdoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getpatientID() {
        return patientID;
    }

    public void setpatientID(String patientID) {
        this.patientID = patientID;
    }
}

    //Appointment d1 = new Appointment("1", "1", "1");
    // ref.child("appointment").child("1").setValue(d1);