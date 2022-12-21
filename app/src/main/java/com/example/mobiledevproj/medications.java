package com.example.mobiledevproj;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class medications extends AppCompatActivity {
    Button btn;
    //DatabaseReference ref;
    DatabaseReference ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
    //@SuppressLint("MissingInflatedId")
    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_11);
        String hi_name =getIntent().getStringExtra("name");
        TextView hello=findViewById(R.id.name);
        hello.setText(hi_name);

        btn = findViewById(R.id.done);
        btn.setOnClickListener(view -> {
            Intent i = new Intent(this, receiptPatient.class);
            i.putExtra("name",hi_name);
            startActivity(i);

        });
        ImageButton btn15;
        btn15 = findViewById(R.id.imageButton2);
        btn15.setOnClickListener(view -> {
            Intent i = new Intent(this, pharmacyOptions.class);
            i.putExtra("name",hi_name);

            startActivity(i);
        });
        ImageButton prof;
        prof=findViewById(R.id.imageButton5);
        prof.setOnClickListener(view -> {
            Intent i = new Intent(this, p_p_p.class);
            startActivity(i);
        });
        Query query1=ref.child("medication");
        Log.d("hi","ahmed");
        query1.addValueEventListener(new ValueEventListener() {
            @SuppressLint("ResourceType")
            @Override

            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Log.d("hi","mona");
                    LinearLayout myLayout = findViewById(R.id.linear);
                    for (DataSnapshot i:snapshot.getChildren()){
                            LinearLayout parent = new LinearLayout(medications.this);
                            parent.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                            parent.setOrientation(LinearLayout.HORIZONTAL);
                            //setContentView(parent);
                            TextView textView = new TextView(medications.this);
                            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT));
                            textView.setText(i.child("name").getValue().toString());
                            Button button = new Button(medications.this);
                            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));
                            button.setId(Integer.parseInt(i.child("id").getValue().toString()));
                            TextView textView2 = new TextView(medications.this);
                            textView2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));
                            textView2.setText("0");
                            textView2.setId(Integer.parseInt(i.child("id").getValue().toString())+200);
                            Button button2 = new Button(medications.this);
                            button2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));
                            button2.setId(Integer.parseInt(i.child("id").getValue().toString())+100);
                            parent.addView(textView);
                            parent.addView(button);
                            parent.addView(textView2);
                            parent.addView(button2);
                            myLayout.addView(parent);}

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
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
//}