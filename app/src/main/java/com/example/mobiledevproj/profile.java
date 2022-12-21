package com.example.mobiledevproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class profile extends AppCompatActivity {
    Patient p1;
    String keys;
    String ord;
    DatabaseReference curr;
    DatabaseReference yorr;
    DatabaseReference ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String id = user.getUid();
        ref.child("users").child(id).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    p1=task.getResult().getValue(Patient.class);
                    TextView hello=findViewById(R.id.name);
                    hello.setText(p1.name);
                }
            }
        });

        curr = ref.child("appointment");
        curr.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                DataSnapshot fc = snapshot.getChildren().iterator().next();
                ord = String.valueOf(fc.getRef().getKey());
            }}

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        yorr = ref.child("appointment");
        yorr.orderByChild("patientID").equalTo(id).addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot datas: snapshot.getChildren()){
                    keys = datas.getKey();
                }}

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        TextView cur;
        cur=findViewById(R.id.q1_info);
        cur.setOnClickListener(view -> {
            cur.setText("Current Number: "+String.valueOf(ord));
        });

        TextView yor;
        yor=findViewById(R.id.q2_info);
        yor.setOnClickListener(view -> {
            if(String.valueOf(keys)=="null") {
                yor.setText("Book Now");
            }else {
                yor.setText("Your Number: " + String.valueOf(keys));
            }
        });

        ImageButton btn;
        btn = findViewById(R.id.btn_hospital);
        btn.setOnClickListener(view -> {
            Intent i = new Intent(this, Departments.class);
            i.putExtra("name",p1.name);
            startActivity(i);
        });

        ImageButton btn2;
        btn2 = findViewById(R.id.btn_pharmacy);
        btn2.setOnClickListener(view -> {
            Intent i = new Intent(this, pharmacyOptions.class);
            i.putExtra("name",p1.name);
            startActivity(i);
        });

        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, loginPage.class);
            i.putExtra("name",p1.name);
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