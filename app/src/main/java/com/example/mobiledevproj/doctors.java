package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class doctors extends AppCompatActivity {

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
        btn = findViewById(R.id.imb1);
        btn.setOnClickListener(view -> {
            Intent i = new Intent(this, DoctorProfile.class);
            i.putExtra("name",hi_name);

            i.putExtra("key",x);
            startActivity(i);
        });
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
    }
}