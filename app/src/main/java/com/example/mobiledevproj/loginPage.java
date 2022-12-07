package com.example.mobiledevproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        TextView btn = (TextView) findViewById(R.id.textView2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginPage.this, signupPage.class));
            }
        });
        EditText txt = findViewById(R.id.username_p);
        Button btn2;
        btn2 = findViewById(R.id.log_in_p);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String the_text = txt.getText().toString();
                if (the_text.equals("0")) {
                    DoctorView();
                }
                else if (the_text.equals("1")) {
                    PharmaView();
                }
                else {
                    PatientView();
                }
            }
        });
    }
    public void DoctorView(){
        Intent intent = new Intent(this,doctor_page.class);
        startActivity(intent);
    }
    public void PharmaView(){
        Intent intent = new Intent(this,pharmacy_page.class);
        startActivity(intent);
    }
    public void PatientView(){
        Intent intent = new Intent(this,profile.class);
        startActivity(intent);
    }

}