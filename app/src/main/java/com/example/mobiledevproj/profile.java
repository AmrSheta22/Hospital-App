package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ImageButton btn;
        btn = findViewById(R.id.btn_hospital);
        btn.setOnClickListener(view -> {
            Intent i = new Intent(this, Departments.class);
            startActivity(i);
        });
        ImageButton btn2;
        btn2 = findViewById(R.id.btn_pharmacy);
        btn2.setOnClickListener(view -> {
            Intent i = new Intent(this, pharmacyOptions.class);
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