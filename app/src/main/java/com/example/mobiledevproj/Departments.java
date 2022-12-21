package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;


public class Departments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialties);
        String hi_name =getIntent().getStringExtra("name");
        TextView hello=findViewById(R.id.name);
        hello.setText(hi_name);
        LinearLayout lout1,lout2,lout3,lout4,lout5;
        lout1 = findViewById(R.id.linearlayout1);
        lout2 = findViewById(R.id.linearlayout2);
        lout3 = findViewById(R.id.linearlayout3);
        lout4 = findViewById(R.id.linearlayout4);
        lout5 = findViewById(R.id.linearlayout5);
        final View.OnClickListener mListener = new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Departments.this,doctors.class);
                LinearLayout l = (LinearLayout) v;
                String s = getResources().getResourceEntryName(l.getId());
                String id = "textView"+s.substring(s.length() -1);
                int resID = getResources().getIdentifier(id, "id", getPackageName());
                TextView txt = findViewById(resID);
                i.putExtra("btnText", txt.getText().toString().toLowerCase(Locale.ROOT));
                i.putExtra("name",hi_name);
                startActivity(i);
            }
        };
        lout1.setOnClickListener(mListener);
        lout2.setOnClickListener(mListener);
        lout3.setOnClickListener(mListener);
        lout4.setOnClickListener(mListener);
        lout5.setOnClickListener(mListener);
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