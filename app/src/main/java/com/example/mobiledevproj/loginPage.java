package com.example.mobiledevproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class loginPage extends AppCompatActivity {
    // Write a message to the database
    DatabaseReference ref = FirebaseDatabase.getInstance("https://hospital-app-be6c3-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
    Patient p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        TextView btn = (TextView) findViewById(R.id.textView7);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginPage.this, signupPage.class));
            }
        });
        String regexPassword = ".{7,}";
        EditText txt = findViewById(R.id.username_p);
        EditText lol = findViewById(R.id.password_p);
        AwesomeValidation V2 = new AwesomeValidation(ValidationStyle.BASIC);
        V2.addValidation(this, R.id.username_p, RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        V2.addValidation(this,R.id.password_p,regexPassword,R.string.invalid_password);
        V2.addValidation(this,R.id.password_p,RegexTemplate.NOT_EMPTY,R.string.Empty_Password);

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
                    Doctor d1 = new Doctor("Ahmed", "ah1234567", "general", "DrAhmed@gmail.com", 40, 4.6, 500, 13);
                    ref.child("doctors").child("1").setValue(d1);

                    Doctor d2 = new Doctor("Mohamed", "mh1234567", "general", "DrMohamed@gmail.com", 45, 4.3, 420, 10);
                    ref.child("doctors").child("2").setValue(d2);

                    Doctor d3 = new Doctor("Hagar","ha1234567","general", "DrHagar@gmail.com",43,4,320,15);
                    ref.child("doctors").child("3").setValue(d3);

                    Doctor d4 = new Doctor("Sama", "sa1234567", "general", "DrSama@gmail.com", 27, 3.8, 200, 3);
                    ref.child("doctors").child("4").setValue(d4);

                    Doctor d5 = new Doctor("Ali","a1234567","general", "DrAli@gmail.com",30,4,300,5);
                    ref.child("doctors").child("5").setValue(d5);

                    Doctor d6 = new Doctor("Mahmoud", "ma1234567", "neurology", "DrMahmoud@gmail.com", 40, 4.6, 500, 13);
                    ref.child("doctors").child("6").setValue(d6);

                    Doctor d7 = new Doctor("Yasmin","ya234567","neurology", "DrYasmin@gmail.com",30,4,300,5);
                    ref.child("doctors").child("7").setValue(d7);

                    Doctor d8 = new Doctor("Mohamed", "mh1234567", "neurology", "DrMohamed@gmail.com", 45, 4.3, 420, 10);
                    ref.child("doctors").child("8").setValue(d8);

                    Doctor d9 = new Doctor("Hagar","ha1234567","neurology", "DrHagar@gmail.com",43,4,320,15);
                    ref.child("doctors").child("9").setValue(d9);

                    Doctor d10 = new Doctor("Sama", "sa1234567", "neurology", "DrSama@gmail.com", 27, 3.8, 200, 3);
                    ref.child("doctors").child("10").setValue(d10);

                    Doctor d11 = new Doctor("Ali","a1234567","cardiology", "DrAli@gmail.com",30,4,300,5);
                    ref.child("doctors").child("11").setValue(d11);

                    Doctor d12 = new Doctor("Ali","a1234567","cardiology", "DrAli@gmail.com",30,4,300,5);
                    ref.child("doctors").child("12").setValue(d12);

                    Doctor d13 = new Doctor("Ali","a1234567","cardiology", "DrAli@gmail.com",30,4,300,5);
                    ref.child("doctors").child("13").setValue(d13);

                    Doctor d14 = new Doctor("Ali","a1234567","cardiology", "DrAli@gmail.com",30,4,300,5);
                    ref.child("doctors").child("14").setValue(d14);

                    Doctor d15 = new Doctor("Ali","a1234567","cardiology", "DrAli@gmail.com",30,4,300,5);
                    ref.child("doctors").child("15").setValue(d15);

                    Doctor d16 = new Doctor("Ali","a1234567","cancer care", "DrAli@gmail.com",30,4,300,5);
                    ref.child("doctors").child("16").setValue(d16);

                    Doctor d17 = new Doctor("Ali","a1234567","cancer care", "DrAli@gmail.com",30,4,300,5);
                    ref.child("doctors").child("16").setValue(d16);

                    Doctor d18 = new Doctor("Ali","a1234567","cancer care", "DrAli@gmail.com",30,4,300,5);
                    ref.child("doctors").child("16").setValue(d16);

                    Doctor d19 = new Doctor("Ali","a1234567","cancer care", "DrAli@gmail.com",30,4,300,5);
                    ref.child("doctors").child("16").setValue(d19);

                    Doctor d20 = new Doctor("Ali","a1234567","cancer care", "DrAli@gmail.com",30,4,300,5);
                    ref.child("doctors").child("20").setValue(d20);

                    Doctor d21 = new Doctor("Naira","na1234567","orthopedic", "DrNaira@gmail.com",30,4,300,5);
                    ref.child("doctors").child("21").setValue(d21);

                    Doctor d22 = new Doctor("Naira","na1234567","orthopedic", "DrNaira@gmail.com",30,4,300,5);
                    ref.child("doctors").child("22").setValue(d22);

                    Doctor d23 = new Doctor("Naira","na1234567","orthopedic", "DrNaira@gmail.com",30,4,300,5);
                    ref.child("doctors").child("23").setValue(d23);

                    Doctor d24 = new Doctor("Naira","na1234567","orthopedic", "DrNaira@gmail.com",30,4,300,5);
                    ref.child("doctors").child("24").setValue(d24);

                    Doctor d25 = new Doctor("Naira","na1234567","orthopedic", "DrNaira@gmail.com",30,4,300,5);
                    ref.child("doctors").child("25").setValue(d25);

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
