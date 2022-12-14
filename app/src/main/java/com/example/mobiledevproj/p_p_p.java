package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class p_p_p extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pp_p);
        EditText age = findViewById(R.id.age);
        EditText gender = findViewById(R.id.gender);
        EditText dis = findViewById(R.id.diseases);
        EditText email = findViewById(R.id.email);
        EditText address = findViewById(R.id.Address);
        ImageButton btn = findViewById(R.id.editt);
        Button out=findViewById(R.id.sign_out);
        Button done=findViewById(R.id.edit_done);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
           age.setEnabled(true);
           gender.setEnabled(true);
           dis.setEnabled(true);
           email.setEnabled(true);
           address.setEnabled(true);
           done.setVisibility(v.VISIBLE);

            }
        });
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i;
                i = new Intent(p_p_p.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, profile.class);
            startActivity(i);
        });
        ImageButton prof;
        prof=findViewById(R.id.imageButton5);
        prof.setOnClickListener(view -> {
            Intent i = new Intent(this, p_p_p.class);
            startActivity(i);
        });
    }

    }
