package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class doctorOrPharmacist extends AppCompatActivity {
    Button doctor, pharmacist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_or_pharmacist);
        doctor = findViewById(R.id.button20);
        pharmacist = findViewById(R.id.button21);
        doctor.setOnClickListener(view -> {
            Intent i = new Intent(this, makeDoctor.class);
            startActivity(i);
        });
        pharmacist.setOnClickListener(view -> {
            Intent i = new Intent(this, makePharmacist.class);
            startActivity(i);
        });
        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, loginPage.class);
            startActivity(i);
        });
    }
}