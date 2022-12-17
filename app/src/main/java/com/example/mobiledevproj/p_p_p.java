package com.example.mobiledevproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p_p_p extends AppCompatActivity {
    DatabaseReference ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
    private FirebaseAuth mAuth;
    Patient p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pp_p);
        EditText age = findViewById(R.id.age);
        EditText gender = findViewById(R.id.gender);
        EditText dis = findViewById(R.id.diseases);
        EditText email = findViewById(R.id.email);
        EditText address = findViewById(R.id.Address);
        TextView hello = findViewById(R.id.name);
        ImageButton btn = findViewById(R.id.editt);
        Button out = findViewById(R.id.sign_out);
        Button done = findViewById(R.id.edit_done);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String id = user.getUid();

        ref.child("users").child(id).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    p1 = task.getResult().getValue(Patient.class);

                    // Log.d("firebase", p1.getinfo());
                    address.setText(p1.address);
                    email.setText(p1.email);
                    if (p1.gender) {
                        gender.setText("Male");
                    } else {
                        gender.setText("Female");
                    }
                    String xx = p1.diseases.toString();
                    dis.setText(xx.substring(1, xx.length()-1));
                    String ag = String.valueOf(p1.age);
                    age.setText(ag);
                    hello.setText(p1.name);
                }
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age.setEnabled(true);
                dis.setEnabled(true);
                email.setEnabled(true);
                address.setEnabled(true);
                done.setVisibility(v.VISIBLE);


            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> chronic_diseases = new ArrayList<>(Arrays.asList(dis.getText().toString().split(",")));
                int edtage = Integer.parseInt(age.getText().toString());
                String edtaddress = address.getText().toString();
                String name = hello.getText().toString();
                String edtemail = email.getText().toString();
                ref.child("users").child(id).setValue(new Patient(id, p1.name, p1.password, edtaddress, p1.gender, chronic_diseases, edtemail, edtage));

            }
        });

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(p_p_p.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mAuth.signOut();
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
        prof = findViewById(R.id.imageButton5);
        prof.setOnClickListener(view -> {
            Intent i = new Intent(this, p_p_p.class);
            startActivity(i);
        });

    }

}

