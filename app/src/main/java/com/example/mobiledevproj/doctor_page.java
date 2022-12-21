package com.example.mobiledevproj;

import static com.example.mobiledevproj.R.id.p;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class doctor_page extends AppCompatActivity {
    DatabaseReference ref;
    DatabaseReference reff;
    String pat;
    String nam;
    String ord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_page);
        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, loginPage.class);
            startActivity(i);
        });
        //////////
        ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("appointment");
        ref.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot fc = snapshot.getChildren().iterator().next();

                pat = String.valueOf(fc.child("patientID").getValue());
                ord = String.valueOf(fc.getRef().getKey());
                reff = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("users").child(pat).child("name");
                reff.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        nam = dataSnapshot.getValue(String.class);
                        //do what you want with the email
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ImageButton rese;
        rese=findViewById(R.id.p);
        rese.setOnClickListener(view -> {
            TextView txt1 = findViewById(R.id.info);
            txt1.setText(String.valueOf(ord));
            TextView txt2 = findViewById(R.id.pname);
            txt2.setText(String.valueOf(nam));
        });
        ImageButton next;
        next=findViewById(R.id.nextnum);
        next.setOnClickListener(view -> {
            TextView txt1 = findViewById(R.id.info);
            txt1.setText(String.valueOf(ord));
            TextView txt2 = findViewById(R.id.pname);
            txt2.setText(String.valueOf(nam));
        });
        //////////
    }

}