package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Singup2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup2);
        Button resg;
        resg = findViewById(R.id.Register);
        resg.setOnClickListener(view -> {
            Intent i = new Intent(this, profile.class);
            startActivity(i);
        });
    }
}