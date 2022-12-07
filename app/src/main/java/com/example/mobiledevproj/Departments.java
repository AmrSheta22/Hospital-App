package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Departments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialties);
        Button btn0, btn1, btn2, btn3, btn4;
        btn0 = findViewById(R.id.button);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        final View.OnClickListener mListener = new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Departments.this,doctors.class);
                // This below line sends Key- btnText and Value- Apple
                //i.putExtra("btnText","Apple");
                startActivity(i);
                };
        };
        btn0.setOnClickListener(mListener);
        btn1.setOnClickListener(mListener);
        btn2.setOnClickListener(mListener);
        btn3.setOnClickListener(mListener);
        btn4.setOnClickListener(mListener);
        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, profile.class);
            startActivity(i);
        });
    }

}