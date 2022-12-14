package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class pharmacyOptions extends AppCompatActivity {
    Button a;
    Button invoice;
    Button question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        a = (Button) findViewById(R.id.button1);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent med = new Intent(pharmacyOptions.this, medications.class);
                startActivity(med);
            }
        });

        invoice = (Button) findViewById(R.id.invoice);
        invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent invo = new Intent(pharmacyOptions.this, Invoice.class);
                startActivity(invo);
            }
        });

        question = (Button) findViewById(R.id.questions);
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ques = new Intent(pharmacyOptions.this, Symptoms.class);
                startActivity(ques);
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
