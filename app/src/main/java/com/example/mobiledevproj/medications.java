package com.example.mobiledevproj;
import android.widget.TextView;
import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.HashMap;

public class medications extends AppCompatActivity {
    TextView textview;
    DatabaseReference ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_11);
        Button btn;
        btn = findViewById(R.id.done);
        textview=findViewById(R.id.item1);
        mAuth = FirebaseAuth.getInstance();

        btn.setOnClickListener(view -> {
            Intent i = new Intent(this, receiptPatient.class);
            startActivity(i);
        });
        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, pharmacyOptions.class);
            startActivity(i);
        });
        ImageButton prof;
        prof=findViewById(R.id.imageButton5);
        prof.setOnClickListener(view -> {
            Intent i = new Intent(this, p_p_p.class);
            startActivity(i);
        });

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference juneRef = rootRef.child("medication").child("id").child("1");
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String msg = ds.child("name").getValue(String.class);
                    textview.setText(msg);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        };
        juneRef.addListenerForSingleValueEvent(valueEventListener);

    }}

//HashMap mbtn = new HashMap();
//HashMap txt = new HashMap();
//final View.OnClickListener mListener = new View.OnClickListener() {
//    public void onClick(View v) {
//        Button b =(Button)v;
//        String s = getResources().getResourceEntryName(b.getId());
//        String id = s.substring(s.length() -1);
//    }
//};

//for (int j = 2; j < 19 ; j = j + 2 ){
//    String id = "button"+Integer.toString(j);
//    int resID = getResources().getIdentifier(id, "id", getPackageName());
//    mbtn.put((j-2),findViewById(resID));
//}
//for (int j = 8; j < 17 ; j++ ){
//    String id = "textView"+Integer.toString(j);
//    int resID = getResources().getIdentifier(id, "id", getPackageName());
//    txt.put((j-8),findViewById(resID));
//}*/