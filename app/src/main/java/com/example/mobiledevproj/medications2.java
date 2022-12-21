package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class medications2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medications2);
        String symptom = getIntent().getStringExtra("symptom");
        // if child.getValue.contains(symptom)


    }
}