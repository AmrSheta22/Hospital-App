package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class DoctorProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
        Button btn;
        btn = findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            Intent i = new Intent(this, Departments.class);
            startActivity(i);
        });

    }
}