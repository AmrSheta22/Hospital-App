package com.example.mobiledevproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

public class doctors extends AppCompatActivity {
    DatabaseReference ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
    Doctor d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
        Intent mIntent = getIntent();
        TextView txt = findViewById(R.id.textView4);
        String x = mIntent.getStringExtra("btnText");
        txt.setText(x);
        String hi_name =getIntent().getStringExtra("name");
        TextView hello=findViewById(R.id.name);
        hello.setText(hi_name);
        ImageButton btn;
        ArrayList<String> corr_ids = new ArrayList<String>();
        ArrayList<Integer> IdsOfDoc = new ArrayList<Integer>();
        final View.OnClickListener Doc_listener = new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(doctors.this,DoctorProfile.class);
                LinearLayout l = (LinearLayout) v;

                i.putExtra("Id", corr_ids.get(v.getId()));
                i.putExtra("name",hi_name);
                startActivity(i);
            }
        };
        /*
        btn = findViewById(R.id.imb1);
        btn.setOnClickListener(view -> {
            Intent i = new Intent(this, DoctorProfile.class);
            i.putExtra("name",hi_name);

            i.putExtra("key",x);
            startActivity(i);
        });

         */
        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, Departments.class);
            i.putExtra("name",hi_name);
            startActivity(i);
        });
        ImageButton prof;
        prof=findViewById(R.id.imageButton5);
        prof.setOnClickListener(view -> {
            Intent i = new Intent(this, p_p_p.class);
            startActivity(i);
        });
        Query query5 = ref.child("doctors");
        query5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("hi", "I reached here");
                if (snapshot.exists()) {
                    Log.d("hi", "I reached to here");
                    LinearLayout Layout = findViewById(R.id.linear);
                    int count = 0;
                    for (DataSnapshot i: snapshot.getChildren()) {
                        Log.d("hi", x);
                        Log.d("hi", i.child("department").getValue().toString());

                        if (i.child("department").getValue().toString().equals(x)){

                            Log.d("hi", "department");

                            LinearLayout theparent = new LinearLayout(doctors.this);
                            corr_ids.add(i.child("id").getValue().toString());
                            IdsOfDoc.add(count);
                            theparent.setId(count);
                            count++;

                            theparent.setBackgroundResource(R.drawable.image_border);
                            theparent.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                            theparent.setOrientation(LinearLayout.HORIZONTAL);
                            //setContentView(parent);
                            TextView textView = new TextView(doctors.this);
                            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.MATCH_PARENT));
                            textView.setTextColor(Color.parseColor("white"));

                            textView.setText(i.child("name").getValue().toString());

                            ImageView image = new ImageView(doctors.this);
                            image.setLayoutParams(new LinearLayout.LayoutParams(300,300));
                            image.setImageResource(R.drawable.doctor_image);


                            View view = new View(doctors.this);
                            view.setLayoutParams(new LinearLayout.LayoutParams(50,
                                    80));
                            view.setBackgroundColor(Color.parseColor("#ffffff"));


                            theparent.addView(image);
                            theparent.addView(textView);
                            Layout.addView(theparent);
                            Layout.addView(view);

                        }
                    }                }
                for (int i = 0; i < IdsOfDoc.size(); i++) {
                    findViewById(IdsOfDoc.get(i)).setOnClickListener(Doc_listener);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}