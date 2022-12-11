package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class DoctorProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
        Intent mIntent = getIntent();
        String x = mIntent.getStringExtra("key");
        Button btn;
        btn = findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            Intent i = new Intent(this, Departments.class);
            startActivity(i);
        });

        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, doctors.class);
            i.putExtra("btnText",x);
            startActivity(i);
        });
    }
}